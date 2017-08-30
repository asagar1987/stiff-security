package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.stiff.security.daily.status.dao.IHRFormDAO;
import com.stiff.security.daily.status.model.HRForm;

@Repository("hrFormDAO")
public class HRFormDAO implements IHRFormDAO
{
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IHRFormDAO#setSessionFactory(org.hibernate.SessionFactory)
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
 * @see com.stiff.security.daily.status.dao.IHRFormDAO#addHRForm(com.stiff.security.daily.status.model.HRForm)
 */
@Override
public void addHRForm(HRForm mm) throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(mm);
		
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IHRFormDAO#getMyVisits(long)
	 */
	@Override
	public List<HRForm> getMyVisits(long id)
	{
		return sessionFactory.getCurrentSession().createQuery("from HRForm where filledBy = :filledBy").setLong("filledBy", id).list();
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IHRFormDAO#getAllVisits()
	 */
	@Override
	public List<HRForm> getAllVisits()
	{
		return sessionFactory.getCurrentSession().createQuery("from HRForm").list();
	}

	@Override
	public HRForm getReportById(int reportId)
	{
		return (HRForm)sessionFactory.getCurrentSession().createQuery("from HRForm where hrreportid = :hrreportid").setLong("hrreportid",reportId).list().get(0);
	}
}
