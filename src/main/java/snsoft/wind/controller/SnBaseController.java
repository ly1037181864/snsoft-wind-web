package snsoft.wind.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.kisso.common.util.HttpUtil;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月19日 下午3:19:07</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.wind.controller.SnBaseController</p>
 * @version 1.0
 */
public class SnBaseController
{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());;
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	@Autowired
	protected HttpSession session;
	@Autowired
	protected ServletContext application;

	/**
	 * 是否为 post 请求
	 */
	protected boolean isPost()
	{
		return HttpUtil.isPost(request);
	}

	/**
	 * 重定向至地址 url
	 * 
	 * @param url
	 *            请求地址
	 * @return
	 */
	protected String redirectTo(String url)
	{
		StringBuffer rto = new StringBuffer("redirect:");
		rto.append(url);
		return rto.toString();
	}
}
