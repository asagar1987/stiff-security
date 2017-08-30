package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDGMNightConductDAO;
import com.stiff.security.daily.status.model.DGMNightConduct;
import com.stiff.security.daily.status.service.IDGMNightConductService;

@Service("dgmNightConductService")
@Component
public class DGMNightConductService implements IDGMNightConductService
{
	@Autowired
	private IDGMNightConductDAO dgmNightConductDAO;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMNightConductService#getDgmNightConductDAO()
	 */
	@Override
	public IDGMNightConductDAO getDgmNightConductDAO()
	{
		return dgmNightConductDAO;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMNightConductService#setDgmNightConductDAO(com.stiff.security.daily.status.dao.IDGMNightConductDAO)
	 */
	@Override
	public void setDgmNightConductDAO(IDGMNightConductDAO dgmNightConductDAO)
	{
		this.dgmNightConductDAO = dgmNightConductDAO;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMNightConductService#getVisitsForOfficer(long)
	 */
	@Override
	@Transactional
	public List<DGMNightConduct> getVisitsForOfficer(long id)
	{
		try
		{
			return dgmNightConductDAO.getMyVisits(id);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMNightConductService#getAllVisits()
	 */
	@Override
	@Transactional
	public List<DGMNightConduct> getAllVisits()
	{
		try
		{
			return dgmNightConductDAO.getAllVisits();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMNightConductService#addDGMNightConduct(com.stiff.security.daily.status.model.DGMNightConduct)
	 */
	@Override
	@Transactional
	public void addDGMNightConduct(DGMNightConduct m)
	{
		try
		{
			dgmNightConductDAO.addNightConductDAO(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
