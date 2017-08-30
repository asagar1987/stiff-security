package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stiff.security.daily.status.dao.IDGMNightConductDAO;
import com.stiff.security.daily.status.model.DGMNightConduct;

@Repository("dgmNightConductDAO")
public class DGMNightConductDAO implements IDGMNightConductDAO
{
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMNightConductDAO#setSessionFactory(org.hibernate.SessionFactory)
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
 * @see com.stiff.security.daily.status.dao.IDGMNightConductDAO#addNightConductDAO(com.stiff.security.daily.status.model.DGMNightConduct)
 */
@Override
public void addNightConductDAO(DGMNightConduct mm) throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(mm);
		
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMNightConductDAO#getMyVisits(long)
	 */
	@Override
	public List<DGMNightConduct> getMyVisits(long id)
	{
		return sessionFactory.getCurrentSession().createQuery("from DGMNightConduct where filledBy = :filledBy").setLong("filledBy", id).list();
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMNightConductDAO#getAllVisits()
	 */
	@Override
	public List<DGMNightConduct> getAllVisits()
	{
		return sessionFactory.getCurrentSession().createQuery("from DGMNightConduct").list();
	}
}
