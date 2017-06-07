package com.hxzy.order.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxzy.order.dao.intf.ModuleDao;
import com.hxzy.order.model.Module;
import com.hxzy.order.page.Page;
import com.hxzy.order.util.MyHibernateDaoSupport;

@Repository("moduleDao")
public class ModuleDaoImpl extends MyHibernateDaoSupport implements ModuleDao{

	@Override
	public void add(Module module) {
		getHibernateTemplate().save(module);
	}

	@Override
	public void delete(String idStr) {
		String[] ids = idStr.split(",");

		final String queryString = "DELETE Module WHERE id in (:ids) ";
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
	public void update(Module module) {
		getHibernateTemplate().update(module);
	}

	@Override
	public List<Module> query(Page page) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Module>>() {
			@Override
			public List<Module> doInHibernate(Session session) throws HibernateException {
				StringBuilder hql = new StringBuilder("FROM Module WHERE 1=1");
				Query<Module> query = session.createQuery(hql.toString(),Module.class);
				query.setFirstResult(page.getStartIndex());
				query.setMaxResults(Page.MAXCOUNT);
				return query.list();
			}
		});
	}
	
	@Override
	public Module queryById(String id) {
		return getHibernateTemplate().execute(new HibernateCallback<Module>() {
			@Override
			public Module doInHibernate(Session session) throws HibernateException {
				String hql = "FROM Module WHERE id =:id";
				Query<Module> query = session.createQuery(hql, Module.class);
				query.setParameter("id", id);
				return query.uniqueResult();
			}
		});
	}

	@Override
	public int dayCount(String date) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "SELECT count(*) FROM Module WHERE id like '%" + date + "%'";
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
				long count = (long)query.uniqueResult();
				return (int)count;
			}
		});
	}

}
