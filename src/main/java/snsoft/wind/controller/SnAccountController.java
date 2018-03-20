package snsoft.wind.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baomidou.framework.controller.SuperController;

import snsoft.wind.entity.SnUser;
import snsoft.wind.service.ISnUserService;

/**
 * <p>项目标题：  账户相关操作</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月7日 上午10:06:58</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.controller.SnAccountController</p>
 * @version 1.0
 */
@Controller
@RequestMapping("/account")
public class SnAccountController extends SuperController
{
	@Resource(name = "sn-SnUserService")
	private ISnUserService userService;

	@RequestMapping(value = "/login")
	public String index(Model model)
	{
		return "/login";
	}

	/**
	 * 注册
	 */
	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	public String register(Model model, SnUser user)
	{
		model.addAttribute("tipMsg", "注册用户名【" + user.getLoginName() + "】已存在！");
		return "/register";
	}

	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public String logout(Model model)
	{
		return "redirect:/account/login.html";
	}

	/**
	 * 锁定
	 */
	@RequestMapping("/lockscreen")
	public String lockscreen(Model model, String password)
	{
		model.addAttribute("loginName", "");
		return "/lockscreen";
	}
}
