package snsoft.wind.redis;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月22日 下午5:01:59</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.wind.redis.SnRedisAspect</p>
 * @version 1.0
 */
@Order(1)
@Component
@Aspect
public class SnRedisAspect
{
	@Autowired
	private RedisTemplate redisTemplate; 
	
	@Pointcut("@annotation(SnCacheable))")
	public void pointCut()
	{
		System.out.println("进入Controller组件处理");
	}

	@AfterReturning(pointcut = "pointCut()", returning = "returnValue")
	public void excuteRedis(JoinPoint point, Object returnValue)
	{
		System.out.println("进入Controller组件处理,返回值为" + returnValue);
		if(redisTemplate!=null)
		{
			System.out.println("redis缓存成功");
		}else
		{
			System.out.println("redis缓存失败");
		}
		
	}
}
