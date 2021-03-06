package com.stiff.security.daily.status.model;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="marketingvisit")
@Component

public class MarketingVisit implements Serializable
{
	
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	private long visitId;
	@Column(name="sitename")
	private String siteName;
	@Column(name="siteaddress")
	private String siteAddress;
	@Column(name="visitdate")
	private String visitDate;
	@Column(name="contactperson")
	private String contactPerson;
	@Column(name="contactnumber")
	private String contactNumber;
	@Column(name="contactemail")
	private String contactEmail;
	@Column(name="remarks")
	private String remarks;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.REFRESH)
	@JoinColumn(name="filledBy")
	private FieldOfficer fieldOfficer;
	
	
	public FieldOfficer getFieldOfficer()
	{
		return fieldOfficer;
	}
	public void setFieldOfficer(FieldOfficer fieldOfficer)
	{
		this.fieldOfficer = fieldOfficer;
	}
	public long getVisitId()
	{
		return visitId;
	}
	public void setVisitId(long visitId)
	{
		this.visitId = visitId;
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
	public String getVisitDate()
	{
		return visitDate;
	}
	public void setVisitDate(String visitDate)
	{
		this.visitDate = visitDate;
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
	
}
