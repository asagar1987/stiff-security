package com.stiff.security.daily.status.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Table(name="sites")
@Component
public class Site implements Serializable
{

	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="siteid")
	private long siteId;
	@Column(name="sitename")
	private String siteName;
	@Column(name="siteaddress")
	private String siteAddress;
	@OneToMany(mappedBy="site", fetch=FetchType.EAGER)
	private  Set<Employee> workers;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="fieldofficerid")
	private FieldOfficer fieldOfficer;
	@OneToMany(mappedBy="site", fetch=FetchType.EAGER)
	private Set<DailyStatusReport> dailyStatusReport;
	
	
	public Set<DailyStatusReport> getDailyStatusReport()
	{
		return dailyStatusReport;
	}
	public void setDailyStatusReport(Set<DailyStatusReport> dailyStatusReport)
	{
		this.dailyStatusReport = dailyStatusReport;
	}
	public FieldOfficer getFieldOfficer()
	{
		return fieldOfficer;
	}
	public void setFieldOfficer(FieldOfficer fieldOfficer)
	{
		this.fieldOfficer = fieldOfficer;
	}
	public long getSiteId()
	{
		return siteId;
	}
	public void setSiteId(long siteId)
	{
		this.siteId = siteId;
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
	public Set<Employee> getWorkers()
	{
		return workers;
	}
	public void setWorkers(Set<Employee> workers)
	{
		this.workers = workers;
	}
	@Override
	public String toString()
	{
		return "Site [siteId=" + siteId + ", siteName=" + siteName + ", siteAddress=" + siteAddress + ", workers="
				+ workers + "]";
	}
	
	public Site()
	{
		
	}
	
	public Site(String siteName, String siteAddress, FieldOfficer fieldOfficer)
	{
		this.siteName=siteName;
		this.siteAddress=siteAddress;
		this.fieldOfficer=fieldOfficer;
	}
	
	
	

}
