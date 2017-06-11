package com.hxzy.order.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxzy.order.dao.intf.DishDao;
import com.hxzy.order.model.Dish;
import com.hxzy.order.page.Page;
import com.hxzy.order.util.MyHibernateDaoSupport;

@Repository("dishDao")
public class DishDaoImpl extends MyHibernateDaoSupport implements DishDao{

	@Override
	public void add(Dish dish) {
		getHibernateTemplate().save(dish);
	}

	@Override
	public void delete(String idStr) {
		String[] ids = idStr.split(",");

		final String queryString = "DELETE Dish WHERE id in (:ids) ";
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
	public void update(Dish dish) {
		getHibernateTemplate().update(dish);
	}

	@Override
	public List<Dish> query(Page page) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Dish>>() {
			@Override
			public List<Dish> doInHibernate(Session session) throws HibernateException {
				StringBuilder hql = new StringBuilder("FROM Dish WHERE 1=1");
				Query<Dish> query = session.createQuery(hql.toString(),Dish.class);
				query.setFirstResult(page.getStartIndex());
				query.setMaxResults(Page.MAXCOUNT);
				return query.list();
			}
		});
	}

	@Override
	public Dish queryById(String id) {
		return getHibernateTemplate().get(Dish.class, id);
	}

	@Override
	public int dayCount(String date) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "SELECT count(*) FROM Dish WHERE id like '%" + date + "%'";
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
				long count = (long)query.uniqueResult();
				return (int)count;
			}
		});
	}

}
