package snsoft.wind.service;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月6日 下午8:35:41</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.service.ISnUserRoleService</p>
 * @version 1.0
 */
public interface ISnUserRoleService
{
	/**
	 * <p>判断是否存在角色对应的用户</p>
	 * @param roleId 角色ID
	 * @return
	 */
	boolean existRoleUser(Long roleId);
}
