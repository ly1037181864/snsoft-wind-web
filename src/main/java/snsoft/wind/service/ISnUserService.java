package snsoft.wind.service;

import java.util.List;

import snsoft.wind.entity.SnUser;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月6日 下午8:32:48</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.service.ISnUserService</p>
 * @version 1.0
 */
public interface ISnUserService
{
	/**根据用户名查找用户信息
	 * @param loginName
	 * @return
	 */
	public SnUser selectByLoginName(String loginName);

	/**根据用户ID查找用户信息
	 * @param loginName
	 * @return
	 */
	public SnUser selectById(Long userId);

	/**删除用户信息
	 * @param userId
	 */
	void deleteUser(Long userId);

	/**新增用户
	 * @param user
	 */
	public void insert(SnUser user);

	/**更新用户
	 * @param user
	 */
	public void update(SnUser user);

	/**分页查询
	 * @param index
	 * @param size
	 */
	public List<SnUser> queryByPage(int index, int size);
}
