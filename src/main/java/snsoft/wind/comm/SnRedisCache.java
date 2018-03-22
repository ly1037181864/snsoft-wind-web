package snsoft.wind.comm;

import java.io.Serializable;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p>项目标题： 缓存工具类</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月20日 下午5:36:41</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.wind.comm.SnRedisCache</p>
 * @version 1.0
 */
public class SnRedisCache implements Cache
{
	/**redis**/
	private RedisTemplate<String, Object> redisTemplate;
	/**缓存名称**/
	private String name;
	/**超时时间**/
	private long timeout;

	public RedisTemplate<String, Object> getRedisTemplate()
	{
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate)
	{
		this.redisTemplate = redisTemplate;
	}

	public long getTimeout()
	{
		return timeout;
	}

	public void setTimeout(long timeout)
	{
		this.timeout = timeout;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public Object getNativeCache()
	{
		return this.redisTemplate;
	}

	@Override
	public ValueWrapper get(Object key)
	{
		System.out.println("------缓存获取-------" + key.toString());
		final String keyf = key.toString();
		Object object = null;
		object = redisTemplate.execute(new RedisCallback<Object>()
		{
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException
			{
				byte[] key = keyf.getBytes();
				byte[] value = connection.get(key);
				if (value == null)
				{
					System.out.println("------缓存不存在-------");
					return null;
				}
				return SerializationUtils.deserialize(value);
			}
		});
		ValueWrapper obj = (object != null ? new SimpleValueWrapper(object) : null);
		System.out.println("------获取到内容-------" + obj);
		return obj;
	}

	@Override
	public <T> T get(Object key, Class<T> type)
	{
		return null;
	}

	@Override
	public <T> T get(Object key, Callable<T> valueLoader)
	{
		return null;
	}

	@Override
	public void put(Object key, Object value)
	{
		System.out.println("-------加入缓存------");
		System.out.println("key----:" + key);
		System.out.println("key----:" + value);
		final String keyString = key.toString();
		final Object valuef = value;
		final long liveTime = 86400;
		redisTemplate.execute(new RedisCallback<Long>()
		{
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException
			{
				byte[] keyb = keyString.getBytes();
				byte[] valueb = SerializationUtils.serialize((Serializable) valuef);
				connection.set(keyb, valueb);
				if (liveTime > 0)
				{
					connection.expire(keyb, liveTime);
				}
				return 1L;
			}
		});
	}

	@Override
	public ValueWrapper putIfAbsent(Object key, Object value)
	{
		return null;
	}

	@Override
	public void evict(Object key)
	{
		System.out.println("-------緩存刪除------");
		final String keyf = key.toString();
		redisTemplate.execute(new RedisCallback<Long>()
		{
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException
			{
				return connection.del(keyf.getBytes());
			}
		});
	}

	@Override
	public void clear()
	{
		System.out.println("-------緩存清理------");
		redisTemplate.execute(new RedisCallback<String>()
		{
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException
			{
				connection.flushDb();
				return "ok";
			}
		});
	}
}
