package snsoft.wind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>标题： TODO</p>
 * <p>功能： </p>
 * <p>所属模块： TODO</p>
 * <p>版权： Copyright © 2018 SNSOFT</p>
 * <p>公司: 北京南北天地科技股份有限公司</p>
 * <p>创建日期：2018年3月27日 下午3:26:06</p>
 * <p>类全名：snsoft.wind.controller.SnMailController</p>
 * 作者：liuyou
 * 初审：
 * 复审：
 * 监听使用界面:
 * @version 8.0
 */
@Controller
@RequestMapping("/sys/mail")
public class SnMailController extends SnBaseController
{

	/**
	 * 发送
	 */
	@RequestMapping("/send")
	public String send(Model model, String email)
	{
		if (isPost())
		{
			model.addAttribute("email", email);
			//model.addAttribute("loginName", getSSOToken().getData());
			boolean rlt = true;//mailHelper.sendMail(email, "SpringWind 测试邮件！", "/mail/tplSend.html", model);
			String tipMsg = "发送邮件至【" + email + "】失败！！";
			if (rlt)
			{
				tipMsg = "已成功发送邮件至【" + email + "】注意查收！！";
			}
			model.addAttribute("tipMsg", tipMsg);
		}
		return "/mail/send";
	}
}
