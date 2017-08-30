package com.stiff.security.daily.status.form;

import org.springframework.stereotype.Component;

@Component
public class EmployeeForm
{
	private long employeeId;
	public long getEmployeeId() 
	{
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	private String employeeName;
	private long designationId;
	private String username;
	private String password;
	private String shift;
	private long siteId;
	public String getEmployeeName()
	{
		return employeeName;
	}
	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}
	public long getDesignationId()
	{
		return designationId;
	}
	public void setDesignationId(long designationId)
	{
		this.designationId = designationId;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getShift()
	{
		return shift;
	}
	public void setShift(String shift)
	{
		this.shift = shift;
	}
	public long getSiteId()
	{
		return siteId;
	}
	public void setSiteId(long siteId)
	{
		this.siteId = siteId;
	}
	
}
