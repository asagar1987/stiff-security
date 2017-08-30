package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IMarketingMeetingDAO;
import com.stiff.security.daily.status.model.MarketingMeeting;
import com.stiff.security.daily.status.service.IMarketingMeetingService;

@Service("marketingMeetingService")
@Component
public class MarketingMeetingService implements IMarketingMeetingService
{
	@Autowired
	private IMarketingMeetingDAO marketingMeetingDAO;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingMeetingService#getMarketingMeetingDAO()
	 */
	@Override
	public IMarketingMeetingDAO getMarketingMeetingDAO()
	{
		return marketingMeetingDAO;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingMeetingService#setMarketingMeetingDAO(com.stiff.security.daily.status.dao.IMarketingMeetingDAO)
	 */
	@Override
	public void setMarketingMeetingDAO(IMarketingMeetingDAO marketingMeetingDAO)
	{
		this.marketingMeetingDAO = marketingMeetingDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingMeetingService#getMeetingsForOfficer(long)
	 */
	@Override
	@Transactional
	public List<MarketingMeeting> getMeetingsForOfficer(long id)
	{
		try
		{
			return marketingMeetingDAO.getMyMeetings(id);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingMeetingService#getAllMeetings()
	 */
	@Override
	@Transactional
	public List<MarketingMeeting> getAllMeetings()
	{
		try
		{
			return marketingMeetingDAO.getAllMeetings();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IMarketingMeetingService#addMarketingMeeting(com.stiff.security.daily.status.model.MarketingMeeting)
	 */
	@Override
	@Transactional
	public void addMarketingMeeting(MarketingMeeting m)
	{
		try
		{
			marketingMeetingDAO.addMarketingMeeting(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
