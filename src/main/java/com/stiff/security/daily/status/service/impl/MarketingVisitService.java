package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IMarketingVisitDAO;
import com.stiff.security.daily.status.model.MarketingVisit;
import com.stiff.security.daily.status.service.IMarketingVisitService;

@Service("marketingVisitService")
@Component
public class MarketingVisitService implements IMarketingVisitService
{
	@Autowired
	private IMarketingVisitDAO marketingVisitDAO;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingVisitService#getMarketingVisitDAO()
	 */
	@Override
	public IMarketingVisitDAO getMarketingVisitDAO()
	{
		return marketingVisitDAO;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingVisitService#setMarketingVisitDAO(com.stiff.security.daily.status.dao.IMarketingVisitDAO)
	 */
	@Override
	public void setMarketingVisitDAO(IMarketingVisitDAO marketingVisitDAO)
	{
		this.marketingVisitDAO = marketingVisitDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingVisitService#getVisitsForOfficer(long)
	 */
	@Override
	@Transactional
	public List<MarketingVisit> getVisitsForOfficer(long id)
	{
		try
		{
			return marketingVisitDAO.getMyVisits(id);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingVisitService#getAllVisits()
	 */
	@Override
	@Transactional
	public List<MarketingVisit> getAllVisits()
	{
		try
		{
			return marketingVisitDAO.getAllVisits();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingVisitService#addMarketingVisit(com.stiff.security.daily.status.model.MarketingVisit)
	 */
	@Override
	@Transactional
	public void addMarketingVisit(MarketingVisit m)
	{
		try
		{
			marketingVisitDAO.addMarketingVisit(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
