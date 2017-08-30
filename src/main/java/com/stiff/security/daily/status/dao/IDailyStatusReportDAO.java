package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.DailyStatusReport;

public interface IDailyStatusReportDAO
{

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IDesignationDAO#setSessionFactory(org.hibernate.SessionFactory)
	 */
	void setSessionFactory(SessionFactory sessionFactory);

	void addReport(DailyStatusReport dsr);

	List<DailyStatusReport> getReportsForOfficer(long id);

	DailyStatusReport getReportById(int reportId);

	List<DailyStatusReport> getAllReports();

}