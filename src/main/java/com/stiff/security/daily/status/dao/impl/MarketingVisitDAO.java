package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.stiff.security.daily.status.dao.IMarketingVisitDAO;
import com.stiff.security.daily.status.model.MarketingVisit;

@Repository("marketingVisitDAO")
public class MarketingVisitDAO implements IMarketingVisitDAO
{

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IMarketingVisitDAO#setSessionFactory(org.hibernate.SessionFactory)
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
 * @see com.stiff.security.daily.status.dao.IMarketingVisitDAO#addMarketingVisit(com.stiff.security.daily.status.model.MarketingVisit)
 */
@Override
public void addMarketingVisit(MarketingVisit mm) throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(mm);
		
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IMarketingVisitDAO#getMyVisits(long)
	 */
	@Override
	public List<MarketingVisit> getMyVisits(long id)
	{
		return sessionFactory.getCurrentSession().createQuery("from MarketingVisit where filledBy = :filledBy").setLong("filledBy", id).list();
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IMarketingVisitDAO#getAllMeetings()
	 */
	@Override
	public List<MarketingVisit> getAllVisits()
	{
		return sessionFactory.getCurrentSession().createQuery("from MarketingVisit").list();
	}
}
