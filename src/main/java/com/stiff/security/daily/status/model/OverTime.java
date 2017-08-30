package com.stiff.security.daily.status.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="overtimes")
public class OverTime
{

	@Override
	public String toString()
	{
		return "OverTime [overTimeId=" + overTimeId + ", dailyStatusReport=" + dailyStatusReport + ", employeeName="
				+ employeeName + "]";
	}
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="overtimeid")
	private long overTimeId;
	public long getOverTimeId()
	{
		return overTimeId;
	}
	public void setOverTimeId(long overTimeId)
	{
		this.overTimeId = overTimeId;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="reportid")
	private DailyStatusReport dailyStatusReport;
	@Column(name="employeename")
	private String employeeName;
	public DailyStatusReport getDailyStatusReport()
	{
		return dailyStatusReport;
	}
	public void setDailyStatusReport(DailyStatusReport dailyStatusReport)
	{
		this.dailyStatusReport = dailyStatusReport;
	}
	public String getEmployeeName()
	{
		return employeeName;
	}
	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}
	
}
