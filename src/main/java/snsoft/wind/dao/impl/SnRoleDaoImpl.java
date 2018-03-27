package snsoft.wind.dao.impl;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import snsoft.wind.dao.ISnRoleDao;
import snsoft.wind.entity.SnRole;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月14日 下午7:17:23</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.wind.dao.impl.SnRoleDaoImpl</p>
 * @version 1.0
 */
@Repository("sn-SnRoleDao")
public class SnRoleDaoImpl extends SnSuperDaoImpl implements ISnRoleDao
{

	@Override
	public SnRole query(Long id)
	{
		Session session = getSession();
		try
		{
			return session.get(SnRole.class, String.valueOf(id));
		} finally
		{
			close();
		}
	}

	@Override
	public SnRole query(SnRole t)
	{
		return null;
	}

	@Override
	public SnRole query(String fitler, Map<String, Object> params)
	{
		if (fitler != null && params != null && params.size() > 0)
		{
			String hql = "from SnRolePermission where 1=1 and " + fitler;
			Session session = getSession();
			try
			{
				Query query = session.createQuery(hql);
				for (String key : params.keySet())
				{
					query.setParameter(key, params.get(key));
				}
				return (SnRole) query.getSingleResult();
			} finally
			{
				close();
			}
		}
		return null;
	}

	@Override
	public void save(SnRole role)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.save(role);
			rollback = false;
		} finally
		{
			commit(rollback);
		}
	}

	@Override
	public void delete(SnRole role)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.delete(role);
			rollback = false;
		} finally
		{
			commit(rollback);
		}
	}

	@Override
	public void update(SnRole role)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.update(role);
			rollback = false;
		} finally
		{
			commit(rollback);
		}
	}

	@Override
	public void update(Map<String, Object> params)
	{
		// TODO Auto-generated method stub
	}
}
