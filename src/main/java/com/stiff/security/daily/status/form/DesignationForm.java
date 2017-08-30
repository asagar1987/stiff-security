package com.stiff.security.daily.status.form;

import org.springframework.stereotype.Component;

@Component
public class DesignationForm
{
	
	private String designationName;
	
	private long designationId;

	public String getDesignationName()
	{
		return designationName;
	}

	public void setDesignationName(String designationName)
	{
		this.designationName = designationName;
	}

	public long getDesignationId()
	{
		return designationId;
	}

	public void setDesignationId(long designationId)
	{
		this.designationId = designationId;
	}

	@Override
	public String toString()
	{
		return "DesignationForm [designationName=" + designationName + ", designationId=" + designationId + "]";
	}
	
}
