package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.ILocationDAO;
import com.stiff.security.daily.status.model.Site;
import com.stiff.security.daily.status.service.ILocationService;

@Service("locationService")
@Component
public class LocationService implements ILocationService
{

	@Autowired
	private ILocationDAO locationDAO;
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.ILocationService#getLocationDAO()
	 */
	@Override
	public ILocationDAO getLocationDAO()
	{
		return locationDAO;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.ILocationService#setLocationDAO(com.stiff.security.daily.status.dao.LocationDAO)
	 */
	@Override
	public void setLocationDAO(ILocationDAO locationDAO)
	{
		this.locationDAO = locationDAO;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.ILocationService#getAllLocations()
	 */
	@Override
	@Transactional
	public List<Site> getAllLocations()
	{
		return locationDAO.listAllLocations();
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.ILocationService#addLocation(com.stiff.security.daily.status.model.Site)
	 */
	@Override
	@Transactional
	public boolean addLocation(Site location)
	{
		try
		{
			locationDAO.addLocation(location);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.ILocationService#getSiteById(long)
	 */
	@Override
	@Transactional
	public Site getSiteById(long siteId)
	{
		return locationDAO.getSiteById(siteId);
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.ILocationService#updateSite(com.stiff.security.daily.status.model.Site)
	 */
	@Override
	@Transactional
	public void updateSite(Site s)
	{
		locationDAO.updateSite(s);
	}


	@Override
	@Transactional
	public List<Site> getSiteForOfficer(long officerId)
	{
		try
		{
			return locationDAO.getSiteForOfficer(officerId);
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
