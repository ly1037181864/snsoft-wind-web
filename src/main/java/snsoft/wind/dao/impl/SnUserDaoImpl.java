package snsoft.wind.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import snsoft.wind.dao.ISnUserDao;
import snsoft.wind.entity.SnUser;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月14日 下午7:13:57</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.wind.dao.SnUserDaoImpl</p>
 * @version 1.0
 */
@Repository("sn-SnUserDao")
public class SnUserDaoImpl extends SnSuperDaoImpl implements ISnUserDao
{

	@Override
	public SnUser query(Long id)
	{
		Session session = getSession();
		try
		{
			return session.get(SnUser.class, String.valueOf(id));
		} finally
		{
			close();
		}
	}

	@Override
	public SnUser query(SnUser user)
	{
		return null;
	}

	@Override
	public SnUser query(String fitler, Map<String, Object> params)
	{
		if (fitler != null && params != null && params.size() > 0)
		{
			String hql = "from SnUser where 1=1 and " + fitler;
			Session session = getSession();
			try
			{
				Query query = session.createQuery(hql);
				for (String key : params.keySet())
				{
					query.setParameter(key, params.get(key));
				}
				return (SnUser) query.getSingleResult();
			} finally
			{
				close();
			}
		}
		return null;
	}

	@Override
	public void save(SnUser user)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.save(user);
			rollback = false;
		} finally
		{
			commit(rollback);
		}
	}

	@Override
	public void delete(SnUser user)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.delete(user);
			rollback = false;
		} finally
		{
			commit(rollback);
		}
	}

	@Override
	public void update(SnUser user)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.update(user);
			rollback = false;
		} finally
		{
			commit(rollback);
		}
	}

	@Override
	public void update(Map<String, Object> params)
	{
	}

	@Override
	public List<SnUser> loadAll()
	{
		String hql = "from SnUser";
		Session session = getSession();
		try
		{
			Query query = session.createQuery(hql);
			return query.list();
		} finally
		{
			close();
		}
	}

	@Override
	public List<SnUser> queryByPage(int index, int size)
	{
		String hql = "from SnUser";
		Session session = getSession();
		try
		{
			Query query = session.createQuery(hql);
			//设置分页位置
			query.setFirstResult(index);
			query.setMaxResults(size);
			return query.list();
		} finally
		{
			close();
		}
	}
}
