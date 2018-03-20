package snsoft.wind.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import snsoft.wind.dao.ISnRolePermissionDao;
import snsoft.wind.entity.SnRolePermission;
import snsoft.wind.service.ISnRolePermissionService;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月6日 下午8:54:21</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.service.impl.SnRolePermissionServiceImpl</p>
 * @version 1.0
 */
@Service("sn-SnRolePermissionService")
public class SnRolePermissionServiceImpl implements ISnRolePermissionService
{
	@Resource(name = "sn-SnRolePermissionDao")
	private ISnRolePermissionDao permissionDao;

	public boolean existRolePermission(Long permissionId)
	{
		SnRolePermission rolePermission = permissionDao.query(permissionId);
		return rolePermission == null ? false : true;
	}

	public List<Long> selecPermissionIdsByRoleId(Long id)
	{
		return permissionDao.selecPermissionIdsByRoleId(id);
	}
}
