package com.hxzy.order.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxzy.order.dao.intf.KindDao;
import com.hxzy.order.model.Kind;
import com.hxzy.order.page.Page;
import com.hxzy.order.util.MyHibernateDaoSupport;

@Repository("kindDao")
public class KindDaoImpl extends MyHibernateDaoSupport implements KindDao{

	@Override
	public void add(Kind kind) {
		getHibernateTemplate().save(kind);
	}

	@Override
	public void delete(String idStr) {
		String[] ids = idStr.split(",");

		final String queryString = "DELETE Kind WHERE id in (:ids) ";
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
	public void update(Kind kind) {
		getHibernateTemplate().update(kind);
	}

	@Override
	public List<Kind> query(Page page) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Kind>>() {
			@Override
			public List<Kind> doInHibernate(Session session) throws HibernateException {
				StringBuilder hql = new StringBuilder("FROM Kind WHERE 1=1");
				Query<Kind> query = session.createQuery(hql.toString(),Kind.class);
				query.setFirstResult(page.getStartIndex());
				query.setMaxResults(Page.MAXCOUNT);
				return query.list();
			}
		});
	}

	@Override
	public Kind queryById(String id) {
		return getHibernateTemplate().get(Kind.class, id);
	}

	@Override
	public int dayCount(String date) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "SELECT count(*) FROM Kind WHERE id like '%" + date + "%'";
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
				long count = (long)query.uniqueResult();
				return (int)count;
			}
		});
	}

}
