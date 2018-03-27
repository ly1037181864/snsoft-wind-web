package snsoft.wind.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import snsoft.wind.entity.SnSysLog;
import snsoft.wind.service.ISnSysLogService;

/**
 * <p>标题： TODO</p>
 * <p>功能： </p>
 * <p>所属模块： TODO</p>
 * <p>版权： Copyright © 2018 SNSOFT</p>
 * <p>公司: 北京南北天地科技股份有限公司</p>
 * <p>创建日期：2018年3月27日 下午2:51:13</p>
 * <p>类全名：snsoft.wind.controller.SnLogController</p>
 * 作者：liuyou
 * 初审：
 * 复审：
 * 监听使用界面:
 * @version 8.0
 */
@Controller
@RequestMapping("/log")
public class SnLogController extends SnBaseController
{
	@Resource(name = "sn-SnSysLogService")
	ISnSysLogService sysLogService;

	@RequestMapping("/list")
	public String list(Model model)
	{
		return "/log/list";
	}

	@ResponseBody
	@RequestMapping("/getLogList")
	public String getLogList()
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
		List<SnSysLog> logs = sysLogService.selectByPage(_index, _size);
		if (logs == null || logs.size() <= 0)
		{
			throw new RuntimeException("没有找到有效的日志记录");
		}
		JSONObject jo = new JSONObject();
		jo.put("total", logs.size());
		jo.put("rows", logs);
		return toJson(jo);
	}

	@ResponseBody
	@RequestMapping("/delete/{id}")
	public String delLog(@PathVariable Long id)
	{
		sysLogService.deleteById(id);
		return Boolean.TRUE.toString();
	}
}
