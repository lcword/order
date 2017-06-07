package com.hxzy.order.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hxzy.order.dao.intf.AdminDao;
import com.hxzy.order.dto.AdminDto;
import com.hxzy.order.model.Admin;
import com.hxzy.order.page.Page;
import com.hxzy.order.util.MyHibernateDaoSupport;

@Repository("adminDao")
public class AdminDaoImpl extends MyHibernateDaoSupport implements AdminDao {

	@Override
	public void add(Admin Admin) {
		getHibernateTemplate().save(Admin);
	}

	@Override
	public void delete(String idStr) {
		String[] ids = idStr.split(",");

		final String queryString = "DELETE Admin WHERE id in (:ids) ";
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
	public void update(Admin Admin) {
		getHibernateTemplate().update(Admin);
	}

	@Override
	public List<Admin> query(Page<AdminDto> page) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Admin>>() {
			@Override
			public List<Admin> doInHibernate(Session session) throws HibernateException {
				StringBuilder hql = new StringBuilder("FROM Admin WHERE 1=1");
				Query<Admin> query = session.createQuery(hql.toString(), Admin.class);
				query.setFirstResult(page.getStartIndex());
				query.setMaxResults(Page.MAXCOUNT);
				return query.list();
			}
		});
	}

	@Override
	public int count(AdminDto AdminDto) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				StringBuilder hql = new StringBuilder("SELECT count(*) FROM Admin WHERE 1=1");
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql.toString());
				long count = (long) query.uniqueResult();
				return (int) count;
			}
		});
	}

	@Override
	public Admin queryById(String id) {
		return getHibernateTemplate().execute(new HibernateCallback<Admin>() {
			@Override
			public Admin doInHibernate(Session session) throws HibernateException {
				String hql = "FROM Admin WHERE id =:id";
				Query<Admin> query = session.createQuery(hql, Admin.class);
				query.setParameter("id", id);
				return query.uniqueResult();
			}
		});
	}

	@Override
	public Admin exist(Admin Admin) {
		String hql = "FROM Admin WHERE username =:username AND password =:password";
		Admin loginer = getHibernateTemplate().execute(new HibernateCallback<Admin>() {
			@Override
			public Admin doInHibernate(Session session) throws HibernateException {
				Query<Admin> query = session.createQuery(hql, Admin.class);
				query.setParameter("username", Admin.getUsername());
				query.setParameter("password", Admin.getPassword());
				Admin Admin = query.uniqueResult();
				return Admin;
			}
		});
		return loginer;
	}

	@Override
	public boolean checkName(String username) {
		Admin register = getHibernateTemplate().execute(new HibernateCallback<Admin>() {
			@Override
			public Admin doInHibernate(Session session) throws HibernateException {
				String hql = "FROM Admin WHERE username =:username";
				Query<Admin> query = session.createQuery(hql, Admin.class);
				query.setParameter("username", username);
				return query.uniqueResult();
			}
		});
		return register != null ? true : false;
	}

}
