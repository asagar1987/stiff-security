package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.stiff.security.daily.status.dao.IDesignationDAO;
import com.stiff.security.daily.status.model.Designation;


@Repository("designationDAO")
public class DesignationDAO implements IDesignationDAO
{
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDesignationDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDesignationDAO#listAllDesignations()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Designation> listAllDesignations()
	{
		System.out.println("Fetching List of Designations");
		Session session = sessionFactory.getCurrentSession();
		String SQL_QUERY = " from Designation";
		Query query = session.createQuery(SQL_QUERY);
		return (List<Designation>)query.list();
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDesignationDAO#addDesignation(java.lang.String)
	 */
	@Override
	public void addDesignation(String designationName) throws Exception
	{
		System.out.println("Adding new designation by name "+designationName);
		Session session = sessionFactory.getCurrentSession();
		session.save(new Designation(designationName));
		
		
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDesignationDAO#getDesignationById(long)
	 */
	@Override
	public Designation getDesignationById(long designationId)
	{
		Session session = sessionFactory.getCurrentSession();
		Designation fo =  (Designation)session.load(Designation.class, designationId);
		return fo;
	}
}
