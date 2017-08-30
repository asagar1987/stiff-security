package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.stiff.security.daily.status.dao.IDGMSecurityAuditConductDAO;
import com.stiff.security.daily.status.model.DGMSecurityAuditConduct;

@Repository("dgmSecurityAuditConductDAO")
public class DGMSecurityAuditConductDAO implements IDGMSecurityAuditConductDAO
{

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMSecurityAuditConductDAO#setSessionFactory(org.hibernate.SessionFactory)
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
 * @see com.stiff.security.daily.status.dao.IDGMSecurityAuditConductDAO#addDGMSecurityAuditConduct(com.stiff.security.daily.status.model.DGMSecurityAuditConduct)
 */
@Override
public void addDGMSecurityAuditConduct(DGMSecurityAuditConduct mm) throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(mm);
		
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMSecurityAuditConductDAO#getMyVisits(long)
	 */
	@Override
	public List<DGMSecurityAuditConduct> getMyVisits(long id)
	{
		return sessionFactory.getCurrentSession().createQuery("from DGMSecurityAuditConduct where filledBy = :filledBy").setLong("filledBy", id).list();
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDGMSecurityAuditConductDAO#getAllVisits()
	 */
	@Override
	public List<DGMSecurityAuditConduct> getAllVisits()
	{
		return sessionFactory.getCurrentSession().createQuery("from DGMSecurityAuditConduct").list();
	}
}
