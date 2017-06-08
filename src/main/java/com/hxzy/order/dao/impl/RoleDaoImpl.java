package com.hxzy.order.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxzy.order.dao.intf.RoleDao;
import com.hxzy.order.model.Admin;
import com.hxzy.order.model.Function;
import com.hxzy.order.model.Role;
import com.hxzy.order.page.Page;
import com.hxzy.order.util.MyHibernateDaoSupport;

@Repository("roleDao")
public class RoleDaoImpl extends MyHibernateDaoSupport implements RoleDao{

	@Override
	public void add(Role role) {
		getHibernateTemplate().save(role);
	}

	@Override
	public void delete(String idStr) {
		String[] ids = idStr.split(",");

		final String queryString = "DELETE Role WHERE id in (:ids) ";
		getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery(queryString);
				query.setParameterList("ids", ids);
				query.executeUpdate();
				return null;
			}
		});
	}

	@Override
	public void update(Role role) {
		getHibernateTemplate().update(role);
	}

	@Override
	public List<Role> query(Page page) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Role>>() {
			@Override
			public List<Role> doInHibernate(Session session) throws HibernateException {
				StringBuilder hql = new StringBuilder("FROM Role WHERE 1=1");
				Query<Role> query = session.createQuery(hql.toString(),Role.class);
				query.setFirstResult(page.getStartIndex());
				query.setMaxResults(Page.MAXCOUNT);
				return query.list();
			}
		});
	}

	@Override
	public Role queryById(String id) {
		return getHibernateTemplate().get(Role.class, id);
//		return getHibernateTemplate().execute(new HibernateCallback<Role>() {
//			@Override
//			public Role doInHibernate(Session session) throws HibernateException {
//				String hql = "FROM Role WHERE id =:id";
//				Query<Role> query = session.createQuery(hql, Role.class);
//				query.setParameter("id", id);
//				return query.uniqueResult();
//			}
//		});
	}

	@Override
	public int dayCount(String date) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "SELECT count(*) FROM Role WHERE id like '%" + date + "%'";
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
				long count = (long)query.uniqueResult();
				return (int)count;
			}
		});
	}

}
