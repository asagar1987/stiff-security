package com.stiff.security.daily.status.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Table(name="marketingmeeting")
@Component

public class MarketingMeeting implements Serializable
{
	
	
	@Override
	public String toString()
	{
		return "MarketingMeeting [meetingId=" + meetingId + ", siteName=" + siteName + ", siteAddress=" + siteAddress
				+ ", meetingDate=" +  ", contactPerson=" + contactPerson + ", contactNumber="
				+ contactNumber + ", fieldOfficer=" + fieldOfficer + ", contactEmail=" + contactEmail + ", remarks="
				+ remarks + "]";
	}
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	private long meetingId;
	@Column(name="sitename")
	private String siteName;
	@Column(name="siteaddress")
	private String siteAddress;
	
	@Column(name="contactperson")
	private String contactPerson;
	@Column(name="contactnumber")
	private String contactNumber;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.REFRESH)
	@JoinColumn(name="filledBy")
	private FieldOfficer fieldOfficer;
	@Column(name="meetingdate")
	private String meetingDate;
	
	
	public String getMeetingDate()
	{
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate)
	{
		this.meetingDate = meetingDate;
	}
	public FieldOfficer getFieldOfficer()
	{
		return fieldOfficer;
	}
	public void setFieldOfficer(FieldOfficer fieldOfficer)
	{
		this.fieldOfficer = fieldOfficer;
	}
	public long getMeetingId()
	{
		return meetingId;
	}
	public void setMeetingId(long meetingId)
	{
		this.meetingId = meetingId;
	}
	public String getSiteName()
	{
		return siteName;
	}
	public void setSiteName(String siteName)
	{
		this.siteName = siteName;
	}
	public String getSiteAddress()
	{
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress)
	{
		this.siteAddress = siteAddress;
	}
	
	public String getContactPerson()
	{
		return contactPerson;
	}
	public void setContactPerson(String contactPerson)
	{
		this.contactPerson = contactPerson;
	}
	public String getContactNumber()
	{
		return contactNumber;
	}
	public void setContactNumber(String contactNumber)
	{
		this.contactNumber = contactNumber;
	}
	public String getContactEmail()
	{
		return contactEmail;
	}
	public void setContactEmail(String contactEmail)
	{
		this.contactEmail = contactEmail;
	}
	public String getRemarks()
	{
		return remarks;
	}
	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}
	@Column(name="contactemail")
	private String contactEmail;
	@Column(name="remarks")
	private String remarks;
	
}
