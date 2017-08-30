package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDailyStatusReportDAO;
import com.stiff.security.daily.status.model.DailyStatusReport;
import com.stiff.security.daily.status.model.Employee;
import com.stiff.security.daily.status.service.IDailyStatusReportService;

@Service("dailyStatusReportService")
@Component
public class DailyStatusReportService implements IDailyStatusReportService
{
	@Autowired
	private IDailyStatusReportDAO dailyStatusReportDAO;
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDailyStatusReportService#addNewReport(com.stiff.security.daily.status.model.DailyStatusReport)
	 */
	@Override
	@Transactional
	public void addNewReport(DailyStatusReport dsr)
	{
		try
		{
			dailyStatusReportDAO.addReport(dsr);
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION OCCURRED " +e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public List<DailyStatusReport> getReportsForOfficer(long id)
	{
		try
		{
			return dailyStatusReportDAO.getReportsForOfficer(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	@Transactional
	public DailyStatusReport getReportById(int reportId)
	{
		try
		{
			return dailyStatusReportDAO.getReportById(reportId);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	@Transactional
	public List<DailyStatusReport> getAllReport()
	{
		try
		{
			return dailyStatusReportDAO.getAllReports();
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
