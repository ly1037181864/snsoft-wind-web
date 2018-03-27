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
 * <p>创建日期：2018年3月27日 下午2:43:40</p>
 * <p>类全名：snsoft.wind.controller.SnIndexController</p>
 * 作者：liuyou
 * 初审：
 * 复审：
 * 监听使用界面:
 * @version 8.0
 */
@Controller
public class SnIndexController extends SnBaseController
{
	/**
	 * 首页
	 */
	@RequestMapping("/index")
	public String index(Model model)
	{
		return "/index";
	}

	/**
	 * 主页
	 */
	@RequestMapping("/home")
	public String home()
	{
		return "/home";
	}

	/**
	 * SW 捐赠
	 */
	@RequestMapping("/donate")
	public String donate()
	{
		return "/donate";
	}
}
