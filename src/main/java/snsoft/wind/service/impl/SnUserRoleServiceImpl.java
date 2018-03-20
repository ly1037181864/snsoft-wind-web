package snsoft.wind.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import snsoft.wind.dao.ISnUserRoleDao;
import snsoft.wind.entity.SnUserRole;
import snsoft.wind.service.ISnUserRoleService;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月7日 上午9:44:31</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.service.impl.SnUserRoleServiceImpl</p>
 * @version 1.0
 */
@Service("sn-SnUserRoleService")
public class SnUserRoleServiceImpl implements ISnUserRoleService
{
	@Resource(name = "sn-SnUserRoleDao")
	ISnUserRoleDao userRoleDao;

	public boolean existRoleUser(Long roleId)
	{
		SnUserRole role = userRoleDao.query(roleId);
		return role == null ? false : true;
	}
}
