package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.ILocationDAO;
import com.stiff.security.daily.status.model.Site;

@Transactional
@Repository("locationDAO")
public class LocationDAO implements ILocationDAO
{
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.ILocationDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see com.stiff.security.daily.status.dao.ILocationDAO#listAllLocations()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Site> listAllLocations()
	{
		System.out.println("Fetching List of Locations");
		Session session = sessionFactory.getCurrentSession();
		
		String SQL_QUERY = " from Site";
		Query query = session.createQuery(SQL_QUERY);
		List<Site> list= query.list();
		
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.ILocationDAO#addLocation(com.stiff.security.daily.status.model.Site)
	 */
	@Override
	public void addLocation(Site location) throws Exception
	{
		System.out.println("Adding new location by name "+location.getSiteName());
		Session session = sessionFactory.getCurrentSession();
		
		session.save(location);
		//session.save(location.getFieldOfficer());
		
		
		
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.ILocationDAO#getSiteById(long)
	 */
	@Override
	public Site getSiteById(long siteId)
	{
		Session session = sessionFactory.getCurrentSession();
		Site fo =  (Site)session.load(Site.class, siteId);
		
		return fo;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.ILocationDAO#updateSite(com.stiff.security.daily.status.model.Site)
	 */
	@Override
	public void updateSite(Site s)
	{
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(s);
		
	}

	@Override
	public List<Site> getSiteForOfficer(long officerId)
	{
		System.out.println("Fetching List of Locations");
		Session session = sessionFactory.getCurrentSession();
		
		String SQL_QUERY = " from Site where fieldofficerId=?";
		
		Query query = session.createQuery(SQL_QUERY);
		query.setLong(1, officerId);
		List<Site> list= query.list();
		
		return list;
	}
}
