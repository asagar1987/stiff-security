package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.stiff.security.daily.status.dao.IMarketingMeetingDAO;
import com.stiff.security.daily.status.model.MarketingMeeting;

@Repository("marketingMeetingDAO")
public class MarketingMeetingDAO implements IMarketingMeetingDAO
{

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDesignationDAO#setSessionFactory(org.hibernate.SessionFactory)
	 */
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IMarketingMeetingDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see com.stiff.security.daily.status.dao.IMarketingMeetingDAO#addDesignation(com.stiff.security.daily.status.model.MarketingMeeting)
	 */
	@Override
	public void addMarketingMeeting(MarketingMeeting mm) throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(mm);
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IMarketingMeetingDAO#getMyMeetings(long)
	 */
	@Override
	public List<MarketingMeeting> getMyMeetings(long id)
	{
		return sessionFactory.getCurrentSession().createQuery("from MarketingMeeting where filledBy=:filledBy").setLong("filledBy", id).list();
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IMarketingMeetingDAO#getAllMeetings()
	 */
	@Override
	public List<MarketingMeeting> getAllMeetings()
	{
		return sessionFactory.getCurrentSession().createQuery("from MarketingMeeting").list();
	}
}
