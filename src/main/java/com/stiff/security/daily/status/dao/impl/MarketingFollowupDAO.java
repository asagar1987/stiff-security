package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.stiff.security.daily.status.dao.IMarketingFollowupDAO;
import com.stiff.security.daily.status.model.MarketingFollowup;
import com.stiff.security.daily.status.model.MarketingVisit;

@Repository("marketingFollowupDAO")
public class MarketingFollowupDAO implements IMarketingFollowupDAO 
{

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IMarketingFollowupDAO#setSessionFactory(org.hibernate.SessionFactory)
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
 * @see com.stiff.security.daily.status.dao.IMarketingFollowupDAO#addMarketingFollowup(com.stiff.security.daily.status.model.MarketingFollowup)
 */
@Override
public void addMarketingFollowup(MarketingFollowup mm) throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(mm);
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IMarketingFollowupDAO#getMyFollowups(long)
	 */
	@Override
	public List<MarketingFollowup> getMyFollowups(long id)
	{
		return sessionFactory.getCurrentSession().createQuery("from MarketingFollowup where filledBy = :filledBy").setLong("filledBy", id).list();
	}
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IMarketingFollowupDAO#getAllFollowups()
	 */
	@Override
	public List<MarketingFollowup> getAllFollowups()
	{
		return sessionFactory.getCurrentSession().createQuery("from MarketingFollowup").list();
	}
}
