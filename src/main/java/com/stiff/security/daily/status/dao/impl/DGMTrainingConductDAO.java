package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.stiff.security.daily.status.dao.IDGMTrainingConductDAO;
import com.stiff.security.daily.status.model.DGMTrainingConduct;

@Repository("dgmTrainingConductDAO")
public class DGMTrainingConductDAO implements IDGMTrainingConductDAO
{

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMTrainingConductDAO#setSessionFactory(org.hibernate.SessionFactory)
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
 * @see com.stiff.security.daily.status.dao.IDGMTrainingConductDAO#addTrainingConduct(com.stiff.security.daily.status.model.DGMTrainingConduct)
 */
@Override
public void addTrainingConduct(DGMTrainingConduct mm) throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(mm);
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMTrainingConductDAO#getMyVisits(long)
	 */
	@Override
	public List<DGMTrainingConduct> getMyVisits(long id)
	{
		return sessionFactory.getCurrentSession().createQuery("from DGMTrainingConduct where filledBy = :filledBy").setLong("filledBy", id).list();
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMTrainingConductDAO#getAllVisits()
	 */
	@Override
	public List<DGMTrainingConduct> getAllVisits()
	{
		return sessionFactory.getCurrentSession().createQuery("from DGMTrainingConduct").list();
	}
}
