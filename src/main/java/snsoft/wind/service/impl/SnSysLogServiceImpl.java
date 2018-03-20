package snsoft.wind.service.impl;

import org.springframework.stereotype.Service;

import snsoft.wind.service.ISnSysLogService;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月7日 上午9:33:33</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.service.impl.SnSysLogServiceImpl</p>
 * @version 1.0
 */
@Service("sn-SnSysLogService")
public class SnSysLogServiceImpl implements ISnSysLogService
{
	private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s,[IP]:%s";
	// @Override
	// public void saveLog(ProceedingJoinPoint joinPoint, String methodName,
	// String operate)
	// {
	// /**
	// * 日志入库
	// */
	// HttpServletRequest request = SnHttpHelper.getHttpServletRequest();
	// SnSysLog sl = new SnSysLog();
	// Token tk = SSOHelper.attrToken(request);
	// if (tk != null)
	// {
	// sl.setUid(tk.getId());
	// }
	// sl.setContent(operateContent(joinPoint, methodName, request));
	// sl.setOperation(operate);
	// sl.setCrTime(new Date());
	// }
	/**
	 * 获取当前执行的方法
	 * @param joinPoint 连接点
	 * @param methodName 方法名称
	 * @return 操作内容
	 */
	// @SuppressWarnings("unchecked")
	// public String operateContent(ProceedingJoinPoint joinPoint, String
	// methodName, HttpServletRequest request)
	// {
	// String className = joinPoint.getTarget().getClass().getName();
	// Object[] params = joinPoint.getArgs();
	// StringBuffer bf = new StringBuffer();
	// if (params != null && params.length > 0)
	// {
	// Enumeration<String> paraNames = request.getParameterNames();
	// while (paraNames.hasMoreElements())
	// {
	// String key = paraNames.nextElement();
	// bf.append(key).append("=");
	// bf.append(request.getParameter(key)).append("&");
	// }
	// if (StringUtils.isBlank(bf.toString()))
	// {
	// bf.append(request.getQueryString());
	// }
	// }
	// return String.format(LOG_CONTENT, className, methodName, bf.toString(),
	// IpHelper.getIpAddr(request));
	// }
}
