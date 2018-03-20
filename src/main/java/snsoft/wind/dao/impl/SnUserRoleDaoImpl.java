package snsoft.wind.dao.impl;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import snsoft.wind.dao.ISnUserRoleDao;
import snsoft.wind.entity.SnUserRole;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月14日 下午7:15:24</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.wind.dao.impl.SnUserRoleDaoImpl</p>
 * @version 1.0
 */
@Repository("sn-SnUserRoleDao")
public class SnUserRoleDaoImpl extends SnSuperDaoImpl implements ISnUserRoleDao
{
	@Autowired
	private SessionFactory sessionFactory;

	public SnUserRole query(Long id)
	{
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			return session.get(SnUserRole.class, String.valueOf(id));
		} finally
		{
			close(session);
		}
	}

	public SnUserRole query(SnUserRole userRole)
	{
		return null;
	}

	public SnUserRole query(String fitler, Map<String, Object> params)
	{
		if (fitler != null && params != null && params.size() > 0)
		{
			String hql = "from SnUserRole where 1=1 and " + fitler;
			Session session = null;
			try
			{
				session = sessionFactory.getCurrentSession();
				Query query = session.createQuery(hql);
				for (String key : params.keySet())
				{
					query.setParameter(key, params.get(key));
				}
				return (SnUserRole) query.getSingleResult();
			} finally
			{
				close(session);
			}
		}
		return null;
	}

	public void save(SnUserRole userRole)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.save(userRole);
			rollback = false;
		} finally
		{
			commit(session, rollback);
		}
	}

	public void delete(SnUserRole userRole)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.delete(userRole);
			rollback = false;
		} finally
		{
			commit(session, rollback);
		}
	}

	public void update(SnUserRole userRole)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.update(userRole);
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
