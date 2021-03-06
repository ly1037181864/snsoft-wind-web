package snsoft.wind.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import snsoft.wind.dao.ISnUserDao;
import snsoft.wind.entity.SnUser;
import snsoft.wind.service.ISnUserService;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月7日 上午9:46:22</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.service.impl.SnUserServiceImpl</p>
 * @version 1.0
 */
@Service("sn-SnUserService")
public class SnUserServiceImpl implements ISnUserService
{
	@Resource(name = "sn-SnUserDao")
	ISnUserDao userDao;

	@Override
	public SnUser selectByLoginName(String loginName)
	{
		String fitler = "loginName=:loginName";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		return userDao.query(fitler, params);
	}

	@Override
	public void deleteUser(Long userId)
	{
		SnUser user = new SnUser();
		user.setId(userId);
		userDao.delete(user);
	}

	@Override
	public SnUser selectById(Long userId)
	{
		return userDao.query(userId);
	}

	@Override
	public void insert(SnUser user)
	{
		userDao.save(user);
	}

	@Override
	public void update(SnUser user)
	{
		userDao.update(user);
	}

	@Override
	public List<SnUser> queryByPage(int index, int size)
	{
		return userDao.queryByPage(index, size);
	}
}
