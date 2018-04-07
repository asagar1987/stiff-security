/**
 * 
 */
package com.stiff.security.entity.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author asaga3
 *
 */
@Entity
@Table(name="leave_application")

public class LeaveApplication implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8557248948201323770L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getSubmissionDate()
	{
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate)
	{
		this.submissionDate = submissionDate;
	}

	public Date getLeaveDate()
	{
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate)
	{
		this.leaveDate = leaveDate;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public byte[] getFileData()
	{
		return fileData;
	}

	public void setFileData(byte[] fileData)
	{
		this.fileData = fileData;
	}

	public LeaveType getLeaveType()
	{
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType)
	{
		this.leaveType = leaveType;
	}

	@Column(name="submissiondate")
	private Date submissionDate;
	
	@Column(name="leavedate")
	private Date leaveDate;
	
	@Column(name="filename")
	private String fileName;
	
	@Column(name="filedata")
	private byte[] fileData;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Employee employee;
	
	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

		//bi-directional many-to-one association to EventType
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="leave_typeid", nullable=false, insertable=false, updatable=false)
		private LeaveType leaveType;

		@Override
		public String toString()
		{
			return "LeaveApplication [id=" + id + ", submissionDate=" + submissionDate + ", leaveDate=" + leaveDate
					+ ", fileName=" + fileName + ", fileData=" + Arrays.toString(fileData) + ", leaveType=" + leaveType
					+ "]";
		}
	
	
}
