package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.Site;

public interface ILocationDAO
{

	void setSessionFactory(SessionFactory sessionFactory);

	List<Site> listAllLocations();

	void addLocation(Site location) throws Exception;

	Site getSiteById(long siteId);

	void updateSite(Site s);
	
	List<Site> getSiteForOfficer(long officerId);

}