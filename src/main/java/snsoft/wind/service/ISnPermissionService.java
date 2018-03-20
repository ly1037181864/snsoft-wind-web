package snsoft.wind.service;

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
 * <p>创建日期：2018年3月6日 下午8:40:14</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.service.ISnPermissionService</p>
 * @version 1.0
 */
public interface ISnPermissionService
{
	List<SnMenuVO> selectMenuVOByUserId(Long userId);

	List<SnPermission> selectAllByUserId(Long userId);
	/**
	 * <p>是否为可操作的权限</p>
	 * @param token SSO 票据顶级父类
	 * @param permission 操作权限编码
	 * @return
	 */
	// boolean isActionable(Token token, String permission);
}
