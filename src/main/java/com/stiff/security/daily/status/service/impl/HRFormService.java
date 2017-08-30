package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IHRFormDAO;
import com.stiff.security.daily.status.model.HRForm;
import com.stiff.security.daily.status.service.IHRFormService;

@Service("hrFormService")
@Component
public class HRFormService implements IHRFormService
{
	@Autowired
	private IHRFormDAO hrFormDAO;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IHRFormService#getVisitsForOfficer(long)
	 */
	@Override
	@Transactional
	public List<HRForm> getVisitsForOfficer(long id)
	{
		try
		{
			return hrFormDAO.getMyVisits(id);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IHRFormService#getAllVisits()
	 */
	@Override
	@Transactional
	public List<HRForm> getAllVisits()
	{
		try
		{
			return hrFormDAO.getAllVisits();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IHRFormService#addHRForm(com.stiff.security.daily.status.model.HRForm)
	 */
	@Override
	@Transactional
	public void addHRForm(HRForm m)
	{
		try
		{
			hrFormDAO.addHRForm(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	@Override
	@Transactional
	public HRForm getReportById(int reportId)
	{
		try
		{
			return hrFormDAO.getReportById(reportId);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
}
