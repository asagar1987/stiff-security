package com.stiff.security.daily.status.form;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class DailyStatusReportForm
{

	@Override
	public String toString()
	{
		return "DailyStatusReportForm [siteId=" + siteId + ", filledBy=" + filledBy + ", reportDate=" + reportDate
				+ ", filledDate=" + filledDate + ", vacantPosts=" + vacantPosts + ", overTimes=" + overTimes
				+ ",  shift=" + shift + "]";
	}
	private long siteId;
	private long filledBy;
	private String reportDate;
	private long filledDate;
	private long vacantPosts;
	private String overTimes;
	
	private List<byte[]> applications;
	public List<byte[]> getApplications()
	{
		return applications;
	}
	public void setApplications(List<byte[]> applications)
	{
		this.applications = applications;
	}
	public long getSiteId()
	{
		return siteId;
	}
	public void setSiteId(long siteId)
	{
		this.siteId = siteId;
	}
	public long getFilledBy()
	{
		return filledBy;
	}
	public void setFilledBy(long filledBy)
	{
		this.filledBy = filledBy;
	}
	
	public String getReportDate()
	{
		return reportDate;
	}
	public void setReportDate(String reportDate)
	{
		this.reportDate = reportDate;
	}
	public long getFilledDate()
	{
		return filledDate;
	}
	public void setFilledDate(long filledDate)
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
	public String getOverTimes()
	{
		return overTimes;
	}
	public void setOverTimes(String overTimes)
	{
		this.overTimes = overTimes;
	}
	
	public String getShift()
	{
		return shift;
	}
	public void setShift(String shift)
	{
		this.shift = shift;
	}
	private List<MultipartFile> files;
	public List<MultipartFile> getFiles()
	{
		return files;
	}
	public void setFiles(List<MultipartFile> files)
	{
		this.files = files;
	}
	private String shift;

	

}
