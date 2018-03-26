package snsoft.wind.dao.impl;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class SnUserDaoImpl extends SnSuperDaoImpl implements ISnUserDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SnUser query(Long id)
	{
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			return session.get(SnUser.class, String.valueOf(id));
		} finally
		{
			close(session);
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
			Session session = null;
			try
			{
				session = sessionFactory.getCurrentSession();
				Query query = session.createQuery(hql);
				for (String key : params.keySet())
				{
					query.setParameter(key, params.get(key));
				}
				return (SnUser) query.getSingleResult();
			} finally
			{
				close(session);
			}
		}
		return null;
	}

	@Override
	public void save(SnUser user)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.save(user);
			rollback = false;
		} finally
		{
			commit(session, rollback);
		}
	}

	@Override
	public void delete(SnUser user)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.delete(user);
			rollback = false;
		} finally
		{
			commit(session, rollback);
		}
	}

	@Override
	public void update(SnUser user)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.update(user);
			rollback = false;
		} finally
		{
			commit(session, rollback);
		}
	}

	@Override
	public void update(Map<String, Object> params)
	{
	}
}
