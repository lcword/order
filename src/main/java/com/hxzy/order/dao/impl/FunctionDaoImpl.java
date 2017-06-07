package com.hxzy.order.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxzy.order.dao.intf.FunctionDao;
import com.hxzy.order.model.Function;
import com.hxzy.order.page.Page;
import com.hxzy.order.util.MyHibernateDaoSupport;

@Repository("functionDao")
public class FunctionDaoImpl extends MyHibernateDaoSupport implements FunctionDao{

	@Override
	public void add(Function function) {
		getHibernateTemplate().save(function);
	}

	@Override
	public void delete(String idStr) {
		String[] ids = idStr.split(",");

		final String queryString = "DELETE Function WHERE id in (:ids) ";
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
	public void update(Function function) {
		getHibernateTemplate().update(function);
	}

	@Override
	public List<Function> query(Page page) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Function>>() {
			@Override
			public List<Function> doInHibernate(Session session) throws HibernateException {
				StringBuilder hql = new StringBuilder("FROM Function WHERE 1=1");
				Query<Function> query = session.createQuery(hql.toString(),Function.class);
				query.setFirstResult(page.getStartIndex());
				query.setMaxResults(Page.MAXCOUNT);
				return query.list();
			}
		});
	}

	@Override
	public Function queryById(String id) {
		return getHibernateTemplate().execute(new HibernateCallback<Function>() {
			@Override
			public Function doInHibernate(Session session) throws HibernateException {
				String hql = "FROM Role WHERE id =:id";
				Query<Function> query = session.createQuery(hql, Function.class);
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
				String hql = "SELECT count(*) FROM Function WHERE id like '%" + date + "%'";
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
				long count = (long)query.uniqueResult();
				return (int)count;
			}
		});
	}
}
