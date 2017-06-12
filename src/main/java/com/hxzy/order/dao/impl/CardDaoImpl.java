package com.hxzy.order.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxzy.order.dao.intf.CardDao;
import com.hxzy.order.model.Card;
import com.hxzy.order.page.Page;
import com.hxzy.order.util.MyHibernateDaoSupport;

@Repository("cardDao")
public class CardDaoImpl extends MyHibernateDaoSupport implements CardDao{

	@Override
	public void add(Card card) {
		getHibernateTemplate().save(card);
	}

	@Override
	public void delete(String idStr) {
		String[] ids = idStr.split(",");

		final String queryString = "DELETE Card WHERE id in (:ids) ";
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
	public void update(Card card) {
		getHibernateTemplate().update(card);
	}

	@Override
	public List<Card> query(Page page) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Card>>() {
			@Override
			public List<Card> doInHibernate(Session session) throws HibernateException {
				StringBuilder hql = new StringBuilder("FROM Card WHERE 1=1");
				Query<Card> query = session.createQuery(hql.toString(),Card.class);
				query.setFirstResult(page.getStartIndex());
				query.setMaxResults(Page.MAXCOUNT);
				return query.list();
			}
		});
	}

	@Override
	public Card queryById(String id) {
		return getHibernateTemplate().get(Card.class, id);
	}

	@Override
	public int dayCount(String date) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "SELECT count(*) FROM Card WHERE id like '%" + date + "%'";
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
				long count = (long)query.uniqueResult();
				return (int)count;
			}
		});
	}

}
