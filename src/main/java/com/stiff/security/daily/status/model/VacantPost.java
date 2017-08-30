package com.stiff.security.daily.status.model;

import java.io.Serializable;
import java.util.Arrays;

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

@SuppressWarnings("serial")
@Component
@Entity
@Table(name="vacantposts")
public class VacantPost implements Serializable
{
	

	@Override
	public String toString()
	{
		return "VacantPost [vacantId=" + vacantId + ", fileName=" + fileName + ", leaveApplication="
				+ Arrays.toString(leaveApplication) + ", dailyStatusReport=" + dailyStatusReport + "]";
	}
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="vacantid")
	private long vacantId;
	
	public long getVacantId()
	{
		return vacantId;
	}
	public void setVacantId(long vacantId)
	{
		this.vacantId = vacantId;
	}
	@Column(name="filename")
	private String fileName;
	@Column(name="leaveapplication")
	private byte[] leaveApplication;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="reportid")
	private DailyStatusReport dailyStatusReport;
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public byte[] getLeaveApplication()
	{
		return leaveApplication;
	}
	public void setLeaveApplication(byte[] leaveApplication)
	{
		this.leaveApplication = leaveApplication;
	}
	public DailyStatusReport getDailyStatusReport()
	{
		return dailyStatusReport;
	}
	public void setDailyStatusReport(DailyStatusReport dailyStatusReport)
	{
		this.dailyStatusReport = dailyStatusReport;
	}
	
	
}
