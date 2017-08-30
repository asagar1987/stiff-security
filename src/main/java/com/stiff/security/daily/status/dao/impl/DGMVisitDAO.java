package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.stiff.security.daily.status.dao.IDGMVisitDAO;
import com.stiff.security.daily.status.model.DGMVisit;

@Repository("dgmVisitDAO")
public class DGMVisitDAO implements IDGMVisitDAO 
{

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMVisitDAO#setSessionFactory(org.hibernate.SessionFactory)
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
 * @see com.stiff.security.daily.status.dao.IDGMVisitDAO#addDGMVisit(com.stiff.security.daily.status.model.DGMVisit)
 */
@Override
public void addDGMVisit(DGMVisit mm) throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(mm);
		
	}
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMVisitDAO#getMyVisits(long)
	 */
	@Override
	public List<DGMVisit> getMyVisits(long id)
	{
		return sessionFactory.getCurrentSession().createQuery("from DGMVisit where filledBy = :filledBy").setLong("filledBy", id).list();
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMVisitDAO#getAllVisits()
	 */
	@Override
	public List<DGMVisit> getAllVisits()
	{
		return sessionFactory.getCurrentSession().createQuery("from DGMVisit").list();
	}
}
