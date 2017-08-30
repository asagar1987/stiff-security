package com.stiff.security.daily.status.form;

import org.springframework.stereotype.Component;

@Component
public class LocationForm
{
	private String locationName;
	private String locationAddress;
	private long siteOfficerId;
	
	public String getLocationName()
	{
		return locationName;
	}
	public void setLocationName(String locationName)
	{
		this.locationName = locationName;
	}
	public String getLocationAddress()
	{
		return locationAddress;
	}
	public void setLocationAddress(String locationAddress)
	{
		this.locationAddress = locationAddress;
	}
	public long getSiteOfficerId()
	{
		return siteOfficerId;
	}
	public void setSiteOfficerId(long siteOfficerId)
	{
		this.siteOfficerId = siteOfficerId;
	}
	
	
	
}
