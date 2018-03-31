package snsoft.wind.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.kisso.common.encrypt.SaltEncoder;

import snsoft.wind.entity.SnUser;
import snsoft.wind.service.ISnRoleService;
import snsoft.wind.service.ISnUserService;

/**
 * <p>标题： TODO</p>
 * <p>功能： </p>
 * <p>所属模块： TODO</p>
 * <p>版权： Copyright © 2018 SNSOFT</p>
 * <p>公司: 北京南北天地科技股份有限公司</p>
 * <p>创建日期：2018年3月27日 下午5:55:53</p>
 * <p>类全名：snsoft.wind.controller.SnUserController</p>
 * 作者：liuyou
 * 初审：
 * 复审：
 * 监听使用界面:
 * @version 8.0
 */
@Controller
@RequestMapping("/perm/user")
public class SnUserController extends SnBaseController
{
	@Resource(name = "sn-SnUserService")
	private ISnUserService userService;
	@Resource(name = "sn-SnRoleService")
	private ISnRoleService roleService;

	@RequestMapping("/list")
	public String list(Model model)
	{
		return "/user/list";
	}

	@RequestMapping("/edit")
	public String edit(Model model, Long id)
	{
		if (id != null)
		{
			model.addAttribute("user", userService.selectById(id));
		}
		model.addAttribute("roleList", roleService.loadAll());
		return "/user/edit";
	}

	@ResponseBody
	@RequestMapping("/editUser")
	public String editUser(SnUser user)
	{
		boolean rlt = false;
		if (user != null)
		{
			user.setPassword(SaltEncoder.md5SaltEncode(user.getLoginName(), user.getPassword()));
			if (user.getId() != null)
			{
				userService.update(user);
			} else
			{
				user.setCrTime(new Date());
				user.setLastTime(user.getCrTime());
				userService.insert(user);
			}
			rlt = true;
		}
		return rlt == true ? "true" : "false";
	}

	@ResponseBody
	@RequestMapping("/getUserList")
	public String getUserList()
	{
		int _size = 10, _index = 0;
		if (request.getParameter("_size") != null)
		{
			_size = Integer.parseInt(request.getParameter("_size"));
		}
		if (request.getParameter("_index") != null)
		{
			_index = Integer.parseInt(request.getParameter("_index"));
		}
		List<SnUser> users = userService.queryByPage(_index, _size);
		if (users == null || users.size() <= 0)
		{
			throw new RuntimeException("未查询到有效的信息");
		}
		JSONObject jo = new JSONObject();
		jo.put("total", users.size());
		jo.put("rows", users);
		return toJson(jo);
	}

	@ResponseBody
	@RequestMapping("/delUser/{userId}")
	public String delUser(@PathVariable Long userId)
	{
		userService.deleteUser(userId);
		return Boolean.TRUE.toString();
	}

	@ResponseBody
	@RequestMapping("/{userId}")
	public SnUser getUser(@PathVariable Long userId)
	{
		return userService.selectById(userId);
	}

	/**
	 * 设置头像
	 */
	@RequestMapping(value = "/setAvatar", method = RequestMethod.GET)
	public String setAvatar()
	{
		return "/user/avatar";
	}
}
