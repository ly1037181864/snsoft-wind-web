package snsoft.wind.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;
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
	@Override
	public SnUserRole query(Long id)
	{
		Session session = getSession();
		try
		{
			return session.get(SnUserRole.class, String.valueOf(id));
		} finally
		{
			close();
		}
	}

	@Override
	public SnUserRole query(SnUserRole userRole)
	{
		return null;
	}

	@Override
	public SnUserRole query(String fitler, Map<String, Object> params)
	{
		if (fitler != null && params != null && params.size() > 0)
		{
			String hql = "from SnUserRole where 1=1 and " + fitler;
			Session session = getSession();
			try
			{
				Query query = session.createQuery(hql);
				for (String key : params.keySet())
				{
					query.setParameter(key, params.get(key));
				}
				return (SnUserRole) query.getSingleResult();
			} finally
			{
				close();
			}
		}
		return null;
	}

	@Override
	public void save(SnUserRole userRole)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.save(userRole);
			rollback = false;
		} finally
		{
			commit(rollback);
		}
	}

	@Override
	public void delete(SnUserRole userRole)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.delete(userRole);
			rollback = false;
		} finally
		{
			commit(rollback);
		}
	}

	@Override
	public void update(SnUserRole userRole)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.update(userRole);
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
	public List<SnUserRole> loadAll()
	{
		String hql = "from SnUserRole";
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
}
