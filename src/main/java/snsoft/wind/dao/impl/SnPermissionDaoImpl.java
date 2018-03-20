package snsoft.wind.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import snsoft.wind.dao.ISnPermissionDao;
import snsoft.wind.entity.SnPermission;
import snsoft.wind.entity.vo.SnMenuVO;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月14日 下午7:17:51</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.wind.dao.impl.SnPermissionDaoImpl</p>
 * @version 1.0
 */
@Repository("sn-SnPermissionDao")
public class SnPermissionDaoImpl extends SnSuperDaoImpl implements ISnPermissionDao
{
	@Autowired
	private SessionFactory sessionFactory;

	public List<SnMenuVO> selectMenuByUserId(Long userId, Long pid)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<SnPermission> selectAllByUserId(Long userId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public SnPermission query(Long id)
	{
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			return session.get(SnPermission.class, String.valueOf(id));
		} finally
		{
			close(session);
		}
	}

	public SnPermission query(SnPermission per)
	{
		return null;
	}

	public SnPermission query(String fitler, Map<String, Object> params)
	{
		if (fitler != null && params != null && params.size() > 0)
		{
			String hql = "from SnPermission where 1=1 and " + fitler;
			Session session = null;
			try
			{
				session = sessionFactory.getCurrentSession();
				Query query = session.createQuery(hql);
				for (String key : params.keySet())
				{
					query.setParameter(key, params.get(key));
				}
				return (SnPermission) query.getSingleResult();
			} finally
			{
				close(session);
			}
		}
		return null;
	}

	public void save(SnPermission per)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.save(per);
			rollback = false;
		} finally
		{
			commit(session, rollback);
		}
	}

	public void delete(SnPermission per)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.delete(per);
			rollback = false;
		} finally
		{
			commit(session, rollback);
		}
	}

	public void update(SnPermission per)
	{
		Session session = null;
		boolean rollback = true;
		try
		{
			session = sessionFactory.getCurrentSession();
			session.update(per);
			rollback = false;
		} finally
		{
			commit(session, rollback);
		}
	}

	public void update(Map<String, Object> params)
	{
		// TODO Auto-generated method stub
	}
}