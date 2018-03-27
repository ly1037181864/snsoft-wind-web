package snsoft.wind.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import snsoft.wind.dao.ISnPermissionDao;
import snsoft.wind.entity.SnPermission;
import snsoft.wind.entity.vo.SnMenuVO;
import snsoft.wind.service.ISnPermissionService;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月6日 下午8:43:35</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.service.impl.SnPermissionServiceImpl</p>
 * @version 1.0
 */
@Service("sn-SnPermissionService")
public class SnPermissionServiceImpl implements ISnPermissionService
{
	@Resource(name = "sn-SnPermissionDao")
	ISnPermissionDao snPermissionDao;

	@Override
	@Cacheable(value = "permissionCache", key = "#userId")
	public List<SnMenuVO> selectMenuVOByUserId(Long userId)
	{
		List<SnMenuVO> perList = null;// baseMapper.selectMenuByUserId(userId,
										// 0L);
		if (perList == null || perList.isEmpty())
		{
			return null;
		}
		List<SnMenuVO> mvList = new ArrayList<SnMenuVO>();
		for (SnMenuVO mv : perList)
		{
			// mv.setMvList(baseMapper.selectMenuByUserId(userId, mv.getId()));
			mvList.add(mv);
		}
		return mvList;
	}

	@Override
	@Cacheable(value = "permissionCache", key = "#userId")
	public List<SnPermission> selectAllByUserId(Long userId)
	{
		return null;
	}

	@Override
	public void deleteById(Long id)
	{
		SnPermission sion = new SnPermission();
		sion.setId(id);
		snPermissionDao.delete(sion);
	}

	@Override
	public List<SnPermission> queryByPage(int index, int size)
	{
		return snPermissionDao.queryByPage(index, size);
	}

	@Override
	public List<SnPermission> loadAll()
	{
		return snPermissionDao.loadAll();
	}
}
