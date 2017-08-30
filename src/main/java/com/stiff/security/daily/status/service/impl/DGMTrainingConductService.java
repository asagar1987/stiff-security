package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDGMTrainingConductDAO;
import com.stiff.security.daily.status.model.DGMTrainingConduct;
import com.stiff.security.daily.status.model.MarketingVisit;
import com.stiff.security.daily.status.service.IDGMTrainingConductService;

@Service("dgmTrainingConductService")
@Component
public class DGMTrainingConductService implements IDGMTrainingConductService
{
	@Autowired
	private IDGMTrainingConductDAO dgmTrainingConductDAO;

	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMTrainingConductService#getDgmTrainingConductDAO()
	 */
	@Override
	public IDGMTrainingConductDAO getDgmTrainingConductDAO()
	{
		return dgmTrainingConductDAO;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMTrainingConductService#setDgmTrainingConductDAO(com.stiff.security.daily.status.dao.IDGMTrainingConductDAO)
	 */
	@Override
	public void setDgmTrainingConductDAO(IDGMTrainingConductDAO dgmTrainingConductDAO)
	{
		this.dgmTrainingConductDAO = dgmTrainingConductDAO;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMTrainingConductService#getVisitsForOfficer(long)
	 */
	@Override
	@Transactional
	public List<DGMTrainingConduct> getVisitsForOfficer(long id)
	{
		try
		{
			return dgmTrainingConductDAO.getMyVisits(id);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMTrainingConductService#getAllVisits()
	 */
	@Override
	@Transactional
	public List<DGMTrainingConduct> getAllVisits()
	{
		try
		{
			return dgmTrainingConductDAO.getAllVisits();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMTrainingConductService#addMarketingVisit(com.stiff.security.daily.status.model.DGMTrainingConduct)
	 */
	@Override
	@Transactional
	public void addMarketingVisit(DGMTrainingConduct m)
	{
		try
		{
			dgmTrainingConductDAO.addTrainingConduct(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
