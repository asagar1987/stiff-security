package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.stiff.security.daily.status.dao.IFieldOfficerDAO;
import com.stiff.security.daily.status.model.FieldOfficer;

@Component
@Repository("fieldOfficerDAO")
public class FieldOfficerDAO implements IFieldOfficerDAO
{
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.stiff.security.daily.status.dao.IFieldOfficerDAO#setSessionFactory(
	 * org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession()
	{
		return sessionFactory.openSession();
	}

	@Override
	@SuppressWarnings(
	{ "unchecked" })
	public FieldOfficer checkLogin(String userName, String userPassword)
	{
		System.out.println("In Check login");
		Session session = this.sessionFactory.getCurrentSession();
		FieldOfficer userFound = null;

		String SQL_QUERY = " from FieldOfficer as o where o.username=? and o.password=? and active=1";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, userName);
		query.setParameter(1, userPassword);
		List<FieldOfficer> list = query.list();

		if ((list != null) && (list.size() > 0))
		{
			userFound = list.get(0);
		}

		return userFound;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.stiff.security.daily.status.dao.IFieldOfficerDAO#getAllOfficers()
	 */
	@Override
	@SuppressWarnings("unchecked")

	public List<FieldOfficer> getAllOfficers()
	{
		System.out.println("Getting List of Officers");
		Session session = sessionFactory.getCurrentSession();
		// Query using Hibernate Query Language
		String SQL_QUERY = " from FieldOfficer where active=1";
		Query query = session.createQuery(SQL_QUERY);

		List<FieldOfficer> list = query.list();

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.stiff.security.daily.status.dao.IFieldOfficerDAO#getFieldOfficerById(
	 * long)
	 */
	@Override
	public FieldOfficer getFieldOfficerById(long siteOfficerId)
	{
		Session session = sessionFactory.getCurrentSession();
		FieldOfficer fo = (FieldOfficer) session.get(FieldOfficer.class, siteOfficerId);

		return fo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.stiff.security.daily.status.dao.IFieldOfficerDAO#addFieldOfficer(com.
	 * stiff.security.daily.status.model.FieldOfficer)
	 */
	@Override
	public long addFieldOfficer(FieldOfficer fo)
	{
		System.out.println("Adding new Field Officer by name " + fo.getFieldOfficerName());
		Session session = sessionFactory.getCurrentSession();
		FieldOfficer newFo = (FieldOfficer) session.save(fo);
		System.out.println(newFo == null ? "IT is nULL" : newFo.toString());
		return newFo.getFieldOfficerId();
	}

	@Override
	public void updateFieldOfficer(FieldOfficer fo)
	{
		Session session = sessionFactory.getCurrentSession();
		session.update(fo);
	}

	@Override
	public void removeOfficer(FieldOfficer f)
	{
		Session session = sessionFactory.getCurrentSession();
		session.delete(f);
	}
}
