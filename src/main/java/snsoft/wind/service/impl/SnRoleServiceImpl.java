package snsoft.wind.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import snsoft.wind.dao.ISnUserRoleDao;
import snsoft.wind.entity.SnUserRole;
import snsoft.wind.service.ISnRoleService;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月6日 下午8:59:36</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.service.impl.SnRoleServiceImpl</p>
 * @version 1.0
 */
@Service("sn-SnRoleService")
public class SnRoleServiceImpl implements ISnRoleService
{
	@Resource(name = "sn-SnUserRoleDao")
	private ISnUserRoleDao userRoleDao;

	public void deleteByUserId(Long userId)
	{
		SnUserRole ur = new SnUserRole();
		ur.setUid(userId);
		userRoleDao.delete(ur);
	}
}
