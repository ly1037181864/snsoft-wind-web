package snsoft.wind.service;

import java.util.List;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月6日 下午8:38:43</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.service.ISnRolePermissionService</p>
 * @version 1.0
 */
public interface ISnRolePermissionService
{
	/**
	 * <p>判断是否存在角色对应的权限</p>
	 * @param permissionId 权限ID
	 * @return
	 */
	boolean existRolePermission(Long permissionId);

	/**
	 * 根据角色ID获取对应的所有关联权限的ID
	 * @param id
	 * @return
	 */
	List<Long> selecPermissionIdsByRoleId(Long id);
}
