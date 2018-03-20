package snsoft.wind.dao;

import java.util.List;

import snsoft.wind.entity.SnRolePermission;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月6日 下午8:25:59</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.dao.ISnRolePermissionDao</p>
 * @version 1.0
 */
public interface ISnRolePermissionDao extends ISnSuperDao<SnRolePermission>
{
	/**
	 * 根据角色ID获取对应的所有关联权限的ID
	 * @param id 角色Id
	 * @return
	 */
	List<Long> selecPermissionIdsByRoleId(Long id);
}
