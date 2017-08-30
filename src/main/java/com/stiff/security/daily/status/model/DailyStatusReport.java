package com.stiff.security.daily.status.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Table(name="dailyreports")
@Component

public class DailyStatusReport implements Serializable
{

	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	private int reportId;
	@Column(name="reportdate")
	private Date dateTime;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="filledby")
	private FieldOfficer fieldOfficer;
	@Column(name="filleddate")
	private Date filledDate;
	@Column(name="vacantposts")
	private long vacantPosts;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="siteid")
	private Site site;
	@OneToMany(mappedBy="dailyStatusReport", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<OverTime> overTimes;
	@OneToMany(mappedBy="dailyStatusReport", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<VacantPost> vacantPostsApplications;
	
	@Override
	public String toString()
	{
		return "DailyStatusReport [reportId=" + reportId + ", dateTime=" + dateTime + ", filledDate=" + filledDate + ", vacantPosts=" + vacantPosts + ", site=" + site + ", overTimes="
				+ overTimes + ", vacantPostsApplications=" + vacantPostsApplications + ", shift=" + shift + "]";
	}
	@Column(name="shift")
	private String shift;
	
	
	public String getShift()
	{
		return shift;
	}
	public void setShift(String shift)
	{
		this.shift = shift;
	}
	public Set<VacantPost> getVacantPostsApplications()
	{
		return vacantPostsApplications;
	}
	public void setVacantPostsApplications(Set<VacantPost> vacantPostsApplications)
	{
		this.vacantPostsApplications = vacantPostsApplications;
	}
	public int getReportId()
	{
		return reportId;
	}
	public void setReportId(int reportId)
	{
		this.reportId = reportId;
	}
	public Date getDateTime()
	{
		return dateTime;
	}
	public void setDateTime(Date dateTime)
	{
		this.dateTime = dateTime;
	}
	public FieldOfficer getFieldOfficer()
	{
		return fieldOfficer;
	}
	public void setFieldOfficer(FieldOfficer fieldOfficer)
	{
		this.fieldOfficer = fieldOfficer;
	}
	public Date getFilledDate()
	{
		return filledDate;
	}
	public void setFilledDate(Date filledDate)
	{
		this.filledDate = filledDate;
	}
	public long getVacantPosts()
	{
		return vacantPosts;
	}
	public void setVacantPosts(long vacantPosts)
	{
		this.vacantPosts = vacantPosts;
	}
	public Site getSite()
	{
		return site;
	}
	public void setSite(Site site)
	{
		this.site = site;
	}
	public Set<OverTime> getOverTimes()
	{
		return overTimes;
	}
	public void setOverTimes(Set<OverTime> overTimes)
	{
		this.overTimes = overTimes;
	}
	
}
