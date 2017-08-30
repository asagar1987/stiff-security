package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.ILocationDAO;
import com.stiff.security.daily.status.model.Site;

public interface ILocationService
{

	ILocationDAO getLocationDAO();

	void setLocationDAO(ILocationDAO locationDAO);

	List<Site> getAllLocations();

	boolean addLocation(Site location);

	Site getSiteById(long siteId);

	void updateSite(Site s);
	
	List<Site> getSiteForOfficer(long officerId);

}