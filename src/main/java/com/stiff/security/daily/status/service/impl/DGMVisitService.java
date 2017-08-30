package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDGMVisitDAO;
import com.stiff.security.daily.status.model.DGMVisit;
import com.stiff.security.daily.status.model.MarketingVisit;
import com.stiff.security.daily.status.service.IDGMVisitService;

@Service("dgmVisitService")
@Component
public class DGMVisitService implements IDGMVisitService
{
	@Autowired
	private IDGMVisitDAO dgmVisitDAO;

	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMVisitService#getVisitsForOfficer(long)
	 */
	@Override
	@Transactional
	public List<DGMVisit> getVisitsForOfficer(long id)
	{
		try
		{
			return dgmVisitDAO.getMyVisits(id);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMVisitService#getAllVisits()
	 */
	@Override
	@Transactional
	public List<DGMVisit> getAllVisits()
	{
		try
		{
			return dgmVisitDAO.getAllVisits();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMVisitService#addMarketingVisit(com.stiff.security.daily.status.model.DGMVisit)
	 */
	@Override
	@Transactional
	public void addMarketingVisit(DGMVisit m)
	{
		try
		{
			dgmVisitDAO.addDGMVisit(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMVisitService#getDgmVisitDAO()
	 */
	@Override
	public IDGMVisitDAO getDgmVisitDAO()
	{
		return dgmVisitDAO;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMVisitService#setDgmVisitDAO(com.stiff.security.daily.status.dao.IDGMVisitDAO)
	 */
	@Override
	public void setDgmVisitDAO(IDGMVisitDAO dgmVisitDAO)
	{
		this.dgmVisitDAO = dgmVisitDAO;
	}
	
}
