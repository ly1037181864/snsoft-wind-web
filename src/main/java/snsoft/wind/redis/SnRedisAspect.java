package snsoft.wind.redis;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
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
	@Pointcut("execution(* snsoft.wind.controller.SnCaptchaController.image())")
	public void pointCut()
	{
		System.out.println("进入Controller组件处理");
	}

	@AfterReturning(pointcut = "pointCut()", returning = "returnValue")
	public void excuteRedis(JoinPoint point, Object returnValue)
	{
		System.out.println("进入Controller组件处理,返回值为" + returnValue);
		SnRedisCacheManager redis = new SnRedisCacheManager();
		redis.set("captcha", returnValue);
		System.out.println("redis已缓存" + redis.get("redis"));
	}
}
