package snsoft.wind.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.query.Query;
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

	@Override
	public List<SnMenuVO> selectMenuByUserId(Long userId, Long pid)
	{
		String hql = "SELECT id, title, url, permCode, icon FROM permission p RIGHT JOIN";
		hql += " (SELECT DISTINCT r.pid FROM role_permission r WHERE EXISTS ( ";
		hql += " SELECT 1 FROM user_role u WHERE u.uid=:userId AND r.rid=u.rid )) a ON p.id=a.pid ";
		hql += " WHERE p.pid=:pid AND type=0 ORDER BY sort ";
		Session session = getSession();
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", userId);
			params.put("pid", pid);
			Query query = session.createSQLQuery(hql);
			for (String key : params.keySet())
			{
				query.setParameter(key, params.get(key));
			}
			return query.list();
		} finally
		{
			close();
		}
	}

	@Override
	public List<SnPermission> selectAllByUserId(Long userId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnPermission query(Long id)
	{
		Session session = getSession();
		try
		{
			return session.get(SnPermission.class, String.valueOf(id));
		} finally
		{
			close();
		}
	}

	@Override
	public SnPermission query(SnPermission per)
	{
		return null;
	}

	@Override
	public SnPermission query(String fitler, Map<String, Object> params)
	{
		if (fitler != null && params != null && params.size() > 0)
		{
			String hql = "from SnPermission where 1=1 and " + fitler;
			Session session = getSession();
			try
			{
				Query query = session.createQuery(hql);
				for (String key : params.keySet())
				{
					query.setParameter(key, params.get(key));
				}
				return (SnPermission) query.getSingleResult();
			} finally
			{
				close();
			}
		}
		return null;
	}

	@Override
	public void save(SnPermission per)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.save(per);
			rollback = false;
		} finally
		{
			commit(rollback);
		}
	}

	@Override
	public void delete(SnPermission per)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.delete(per);
			rollback = false;
		} finally
		{
			commit(rollback);
		}
	}

	@Override
	public void update(SnPermission per)
	{
		Session session = getSession();
		boolean rollback = true;
		try
		{
			session.update(per);
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

	@Override
	public List<SnPermission> queryByPage(int index, int size)
	{
		String hql = "from SnPermission";
		Session session = getSession();
		try
		{
			Query query = session.createQuery(hql);
			//得到滚动结果集
			ScrollableResults scroll = query.scroll();
			//滚动到最后一行
			scroll.last();
			//设置分页位置
			query.setFirstResult(index);
			query.setMaxResults(size);
			return query.list();
		} finally
		{
			close();
		}
	}

	@Override
	public List<SnPermission> loadAll()
	{
		String hql = "from SnPermission";
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
