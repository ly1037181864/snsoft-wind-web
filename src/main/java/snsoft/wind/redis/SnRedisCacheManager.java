package snsoft.wind.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

/**
 * <p>项目标题： 缓存工具类</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月20日 下午5:36:41</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.wind.redis.SnRedisCacheManager</p>
 * @version 1.0
 */
public class SnRedisCacheManager
{
	/**redis**/
	private RedisTemplate<String, Object> redisTemplate;
	/**失效时间**/
	private static final Long TIMEOUT = 3000L;

	public RedisTemplate<String, Object> getRedisTemplate()
	{
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate)
	{
		this.redisTemplate = redisTemplate;
	}

	/**
	* 指定缓存失效时间
	* @param key 键
	* @param time 时间(秒)
	* @return
	*/
	public void expire(String key, long time)
	{
		try
		{
			if (time > 0)
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			if (time <= 0)
				expire(key);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	* 指定缓存失效时间
	* @param key 键
	* @param time 时间(秒)
	* @return
	*/
	public void expire(String key)
	{
		try
		{
			redisTemplate.expire(key, TIMEOUT, TimeUnit.SECONDS);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据key 获取过期时间
	 * @param key 键 不能为null
	 * @return 时间(秒) 返回0代表为永久有效
	 */
	public long getExpire(String key)
	{
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}

	/**
	 * 判断key是否存在
	 * @param key 键
	 * @return true 存在 false不存在
	 */
	public boolean hasKey(String key)
	{
		try
		{
			return redisTemplate.hasKey(key);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除缓存
	 * @param key 可以传一个值 或多个
	 */
	@SuppressWarnings("unchecked")
	public void del(String... key)
	{
		if (key != null && key.length > 0)
		{
			if (key.length == 1)
			{
				redisTemplate.delete(key[0]);
			} else
			{
				redisTemplate.delete(CollectionUtils.arrayToList(key));
			}
		}
	}

	/**
	 * 普通缓存获取
	 * @param key 键
	 * @return 值
	 */
	public Object get(String key)
	{
		return key == null ? null : redisTemplate.opsForValue().get(key);
	}

	/**
	 * 普通缓存放入
	 * @param key 键
	 * @param value 值
	 * @return true成功 false失败
	 */
	public void set(String key, Object value)
	{
		try
		{
			redisTemplate.opsForValue().set(key, value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 普通缓存放入并设置时间
	 * @param key 键
	 * @param value 值
	 * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
	 * @return true成功 false 失败
	 */
	public void set(String key, Object value, long time)
	{
		try
		{
			if (time > 0)
			{
				redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
			} else
			{
				set(key, value);
			}
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 递增
	 * @param key 键
	 * @param by 要增加几(大于0)
	 * @return
	 */
	public long incr(String key, long delta)
	{
		if (delta <= 0)
		{
			throw new RuntimeException("递增因子必须大于0");
		}
		return redisTemplate.opsForValue().increment(key, delta);
	}

	/**
	 * 递减
	 * @param key 键
	 * @param by 要减少几(小于0)
	 * @return
	 */
	public long decr(String key, long delta)
	{
		if (delta <= 0)
		{
			throw new RuntimeException("递减因子必须大于0");
		}
		return redisTemplate.opsForValue().increment(key, -delta);
	}

	/**
	 * HashGet
	 * @param key 键 不能为null
	 * @param item 项 不能为null
	 * @return 值
	 */
	public Object hget(String key, String item)
	{
		return redisTemplate.opsForHash().get(key, item);
	}

	/**
	 * 获取hashKey对应的所有键值
	 * @param key 键
	 * @return 对应的多个键值
	 */
	public Map<Object, Object> hmget(String key)
	{
		return redisTemplate.opsForHash().entries(key);
	}

	/**
	 * HashSet
	 * @param key 键
	 * @param map 对应多个键值
	 */
	public void hmset(String key, Map<String, Object> map)
	{
		try
		{
			redisTemplate.opsForHash().putAll(key, map);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * HashSet 并设置时间
	 * @param key 键
	 * @param map  对应多个键值
	 * @param time 时间(秒)
	 */
	public void hmset(String key, Map<String, Object> map, long time)
	{
		try
		{
			redisTemplate.opsForHash().putAll(key, map);
			expire(key, time);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 向一张hash表中放入数据,如果不存在将创建
	 * @param key
	 * @param item
	 * @param value
	 * @return true 成功 false失败
	 */
	public boolean hset(String key, String item, Object value)
	{
		try
		{
			redisTemplate.opsForHash().put(key, item, value);
			return true;
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 向一张hash表中放入数据,如果不存在将创建
	 * @param key
	 * @param item
	 * @param value
	 * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
	 * @return true 成功 false失败
	 */
	public boolean hset(String key, String item, Object value, long time)
	{
		try
		{
			redisTemplate.opsForHash().put(key, item, value);
			expire(key, time);
			return true;
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除hash表中的值
	 * @param key
	 * @param item
	 */
	public void hdel(String key, Object... item)
	{
		redisTemplate.opsForHash().delete(key, item);
	}

	/**
	 * 判断hash表中是否有该项的值
	 * @param key 键 不能为null
	 * @param item 项 不能为null
	 * @return true 存在 false不存在
	 */
	public boolean hHasKey(String key, String item)
	{
		return redisTemplate.opsForHash().hasKey(key, item);
	}

	/**
	 * hash递增 如果不存在,就会创建一个 并把新增后的值返回
	 * @param key
	 * @param item
	 * @param by 要增加几(大于0)
	 * @return
	 */
	public double hincr(String key, String item, double by)
	{
		return redisTemplate.opsForHash().increment(key, item, by);
	}

	/**
	 * hash递减
	 * @param key
	 * @param item
	 * @param by 要减少记(小于0)
	 */
	public double hdecr(String key, String item, double by)
	{
		return redisTemplate.opsForHash().increment(key, item, -by);
	}

	/**
	 * 根据key获取Set中的所有值
	 * @param key
	 */
	public Set<Object> sGet(String key)
	{
		try
		{
			return redisTemplate.opsForSet().members(key);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据value从一个set中查询,是否存在
	 * @param key
	 * @param value
	 */
	public void sHasKey(String key, Object value)
	{
		try
		{
			redisTemplate.opsForSet().isMember(key, value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将数据放入set缓存
	 * @param key
	 * @param values
	 */
	public void sSet(String key, Object... values)
	{
		try
		{
			redisTemplate.opsForSet().add(key, values);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将set数据放入缓存
	 * @param key
	 * @param time
	 * @param values
	 */
	public void sSetAndTime(String key, long time, Object... values)
	{
		try
		{
			redisTemplate.opsForSet().add(key, values);
			expire(key, time);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取set缓存的长度
	 * @param key
	 */
	public long sGetSetSize(String key)
	{
		try
		{
			return redisTemplate.opsForSet().size(key);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 移除值为value的
	 * @param key
	 * @param values
	 */
	public void setRemove(String key, Object... values)
	{
		try
		{
			redisTemplate.opsForSet().remove(key, values);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取list缓存的内容
	 * @param key 键
	 * @param start 开始
	 * @param end 结束 0 到 -1代表所有值
	 */
	public List<Object> lGet(String key, long start, long end)
	{
		try
		{
			return redisTemplate.opsForList().range(key, start, end);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取list缓存的长度
	 * @param key 键
	 */
	public long lGetListSize(String key)
	{
		try
		{
			return redisTemplate.opsForList().size(key);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 通过索引 获取list中的值
	 * @param key 键
	 * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
	 */
	public Object lGetIndex(String key, long index)
	{
		try
		{
			return redisTemplate.opsForList().index(key, index);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将list放入缓存
	 * @param key 键
	 * @param value 值
	 * @param time 时间(秒)
	 */
	public void lSet(String key, Object value)
	{
		try
		{
			redisTemplate.opsForList().rightPush(key, value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将list放入缓存
	 * @param key 键
	 * @param value 值
	 * @param time 时间(秒)
	 * @return
	 */
	public void lSet(String key, Object value, long time)
	{
		try
		{
			redisTemplate.opsForList().rightPush(key, value);
			expire(key, time);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将list放入缓存
	 * @param key 键
	 * @param value 值
	 * @param time 时间(秒)
	 */
	public void lSet(String key, List<Object> value)
	{
		try
		{
			redisTemplate.opsForList().rightPushAll(key, value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将list放入缓存
	 * @param key 键
	 * @param value 值
	 * @param time 时间(秒)
	 * @return
	 */
	public void lSet(String key, List<Object> value, long time)
	{
		try
		{
			redisTemplate.opsForList().rightPushAll(key, value);
			expire(key, time);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据索引修改list中的某条数据
	 * @param key 键
	 * @param index 索引
	 * @param value 值
	 */
	public void lUpdateIndex(String key, long index, Object value)
	{
		try
		{
			redisTemplate.opsForList().set(key, index, value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 移除N个值为value
	 * @param key 键
	 * @param count 移除多少个
	 * @param value 值
	 */
	public void lRemove(String key, long count, Object value)
	{
		try
		{
			redisTemplate.opsForList().remove(key, count, value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}