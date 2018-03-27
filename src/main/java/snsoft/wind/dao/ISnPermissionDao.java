package snsoft.wind.dao;

import java.util.List;

import snsoft.wind.entity.SnPermission;
import snsoft.wind.entity.vo.SnMenuVO;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月6日 下午8:23:07</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.dao.ISnPermissionDao</p>
 * @version 1.0
 */
public interface ISnPermissionDao extends ISnSuperDao<SnPermission>
{
	List<SnMenuVO> selectMenuByUserId(Long userId, Long pid);

	List<SnPermission> selectAllByUserId(Long userId);

	public List<SnPermission> queryByPage(int index, int size);
}
