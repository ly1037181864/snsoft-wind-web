package snsoft.wind.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import snsoft.wind.entity.SnPermission;
import snsoft.wind.service.ISnPermissionService;
import snsoft.wind.service.ISnRolePermissionService;

/**
 * <p>项目标题： 角色管理相关操作</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月7日 上午10:45:09</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.controller.SnPermissionController</p>
 * @version 1.0
 */
@Controller
@RequestMapping("/perm/permission")
public class SnPermissionController extends SnBaseController
{
	@Resource(name = "sn-SnPermissionService")
	private ISnPermissionService permissionService;
	@Resource(name = "sn-SnRolePermissionService")
	private ISnRolePermissionService rolePermissionService;

	@RequestMapping("/list")
	public String list(Model model)
	{
		return "/permission/list";
	}

	@ResponseBody
	@RequestMapping("/getPermissionList")
	public String getPermissionList()
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
		List<SnPermission> sions = permissionService.queryByPage(_index, _size);
		if (sions == null || sions.size() <= 0)
		{
			throw new RuntimeException("未查询到有效的信息");
		}
		JSONObject jo = new JSONObject();
		jo.put("total", sions.size());
		jo.put("rows", sions);
		return toJson(jo);
	}

	@ResponseBody
	@RequestMapping("/delete/{permId}")
	public String delete(@PathVariable Long permId)
	{
		boolean exist = rolePermissionService.existRolePermission(permId);
		if (exist)
		{
			return "false";
		}
		permissionService.deleteById(permId);
		return "true";
	}
}
