package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDailyStatusReportDAO;
import com.stiff.security.daily.status.model.DailyStatusReport;


@Repository("dailyStatusReportDAO")
public class DailyStatusReportDAO implements IDailyStatusReportDAO 
{
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDesignationDAO#setSessionFactory(org.hibernate.SessionFactory)
	 */
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDailyStatusReportDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see com.stiff.security.daily.status.dao.IDailyStatusReportDAO#addReport(com.stiff.security.daily.status.model.DailyStatusReport)
	 */
	@Override
	@Transactional
	public void addReport(DailyStatusReport dsr)
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(dsr);
		
	}

	@Override
	public List<DailyStatusReport> getReportsForOfficer(long id)
	{
		Session session = sessionFactory.getCurrentSession();
		String SQL_QUERY="from DailyStatusReport where filledBy=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, id);
		return query.list();
		
				
		
	}

	@Override
	public DailyStatusReport getReportById(int reportId)
	{
		Session session = sessionFactory.getCurrentSession();
		String SQL_QUERY = "from DailyStatusReport where reportId=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, reportId);
		return (DailyStatusReport) query.list().get(0);
	}

	@Override
	public List<DailyStatusReport> getAllReports()
	{
		Session session = sessionFactory.getCurrentSession();
		String SQL_QUERY = "from DailyStatusReport";
		Query query = session.createQuery(SQL_QUERY);
		
		return query.list();
	}
	
	
}
