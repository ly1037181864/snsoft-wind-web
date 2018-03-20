package snsoft.wind.dao.impl;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import snsoft.wind.dao.ISnSysLogDao;
import snsoft.wind.entity.SnSysLog;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月14日 下午7:16:02</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.wind.dao.impl.SnSysLogDaoImpl</p>
 * @version 1.0
 */
@Repository("sn-SnSysLogDao")
public class SnSysLogDaoImpl extends SnSuperDaoImpl implements ISnSysLogDao
{
	@Autowired
	private SessionFactory sessionFactory;

	public SnSysLog query(Long id)
	{
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			return session.get(SnSysLog.class, String.valueOf(id));
		} finally
		{
			close(session);
		}
	}

	public SnSysLog query(SnSysLog log)
	{
		return null;
	}

	public SnSysLog query(String fitler, Map<String, Object> params)
	{
		if (fitler != null && params != null && params.size() > 0)
		{
			String hql = "from SnSysLog where 1=1 and " + fitler;
			Session session = null;
			try
			{
				session = sessionFactory.getCurrentSession();
				Query query = session.createQuery(hql);
				for (String key : params.keySet())
				{
					query.setParameter(key, params.get(key));
				}
				return (SnSysLog) query.getSingleResult();
			} finally
			{
				close(session);
			}
		}
		return null;
	}

	public void save(SnSysLog log)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.save(log);
			rollback = false;
		} finally
		{
			commit(session, rollback);
		}
	}

	public void delete(SnSysLog log)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.delete(log);
			rollback = false;
		} finally
		{
			commit(session, rollback);
		}
	}

	public void update(SnSysLog log)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.update(log);
			rollback = false;
		} finally
		{
			commit(session, rollback);
		}
	}

	public void update(Map<String, Object> params)
	{
	}
}
