package snsoft.wind.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import snsoft.wind.dao.ISnRoleDao;
import snsoft.wind.entity.SnRole;
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
	@Resource(name = "sn-SnRoleDao")
	private ISnRoleDao roleDao;

	@Override
	public List<SnRole> queryByPage(int index, int size)
	{
		return roleDao.queryByPage(index, size);
	}

	@Override
	public void deleteById(Long id)
	{
		SnRole role = new SnRole();
		role.setId(id);
		roleDao.delete(role);
	}

	@Override
	public void update(SnRole role)
	{
		roleDao.update(role);
	}

	@Override
	public void insert(SnRole role)
	{
		roleDao.save(role);
	}

	@Override
	public SnRole selectById(Long id)
	{
		return roleDao.query(id);
	}

	@Override
	public List<SnRole> loadAll()
	{
		return roleDao.loadAll();
	}
}
