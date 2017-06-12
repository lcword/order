package com.hxzy.order.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxzy.order.dao.intf.MemberDao;
import com.hxzy.order.model.Member;
import com.hxzy.order.page.Page;
import com.hxzy.order.util.MyHibernateDaoSupport;

@Repository("memberDao")
public class MemberDaoImpl extends MyHibernateDaoSupport implements MemberDao{

	@Override
	public void add(Member member) {
		getHibernateTemplate().save(member);
	}

	@Override
	public void delete(String idStr) {
		String[] ids = idStr.split(",");

		final String queryString = "DELETE Member WHERE id in (:ids) ";
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
	public void update(Member member) {
		getHibernateTemplate().update(member);
	}

	@Override
	public List<Member> query(Page page) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Member>>() {
			@Override
			public List<Member> doInHibernate(Session session) throws HibernateException {
				StringBuilder hql = new StringBuilder("FROM Member WHERE 1=1");
				Query<Member> query = session.createQuery(hql.toString(),Member.class);
				query.setFirstResult(page.getStartIndex());
				query.setMaxResults(Page.MAXCOUNT);
				return query.list();
			}
		});
	}

	@Override
	public Member queryById(String id) {
		return getHibernateTemplate().get(Member.class, id);
	}

	@Override
	public int dayCount(String date) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String hql = "SELECT count(*) FROM Member WHERE id like '%" + date + "%'";
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
				long count = (long)query.uniqueResult();
				return (int)count;
			}
		});
	}

}
