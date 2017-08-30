package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IMarketingFollowupDAO;
import com.stiff.security.daily.status.model.MarketingFollowup;
import com.stiff.security.daily.status.service.IMarketingFollowupService;

@Service("marketingFollowupService")
@Component
public class MarketingFollowupService implements IMarketingFollowupService
{
	@Autowired
	private IMarketingFollowupDAO marketingFollowupDAO;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingFollowupService#getMarketingFollowupDAO()
	 */
	@Override
	public IMarketingFollowupDAO getMarketingFollowupDAO()
	{
		return marketingFollowupDAO;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingFollowupService#setMarketingFollowupDAO(com.stiff.security.daily.status.dao.IMarketingFollowupDAO)
	 */
	@Override
	public void setMarketingFollowupDAO(IMarketingFollowupDAO marketingFollowupDAO)
	{
		this.marketingFollowupDAO = marketingFollowupDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingFollowupService#getFollowupsForOfficer(long)
	 */
	@Override
	@Transactional
	public List<MarketingFollowup> getFollowupsForOfficer(long id)
	{
		try
		{
			return marketingFollowupDAO.getMyFollowups(id);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingFollowupService#getAllFollowups()
	 */
	@Override
	@Transactional
	public List<MarketingFollowup> getAllFollowups()
	{
		try
		{
			return marketingFollowupDAO.getAllFollowups();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingFollowupService#addMarketingFollowup(com.stiff.security.daily.status.model.MarketingFollowup)
	 */
	@Override
	@Transactional
	public void addMarketingFollowup(MarketingFollowup m)
	{
		try
		{
			marketingFollowupDAO.addMarketingFollowup(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
