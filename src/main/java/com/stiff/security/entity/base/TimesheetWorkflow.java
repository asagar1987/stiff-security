package com.stiff.security.entity.base;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the contract_workflow_state database table.
 * 
 */
@Entity
@Table(name="timesheet_workflow")
@NamedQuery(name="TimesheetWorkflow.findAll", query="SELECT c FROM TimesheetWorkflow c")
public class TimesheetWorkflow implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public TimesheetWorkflow()
	{
		
	}
	
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

	public int getActionuser()
	{
		return actionuser;
	}

	public void setActionuser(int actionuser)
	{
		this.actionuser = actionuser;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getRemarks()
	{
		return remarks;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	public Timesheet getTimesheet()
	{
		return timesheet;
	}

	public void setTimesheet(Timesheet timesheet)
	{
		this.timesheet = timesheet;
	}

	public TimesheetStatus getFromStatus()
	{
		return fromStatus;
	}

	public void setFromStatus(TimesheetStatus fromStatus)
	{
		this.fromStatus = fromStatus;
	}

	public TimesheetStatus getToStatus()
	{
		return toStatus;
	}

	public void setToStatus(TimesheetStatus toStatus)
	{
		this.toStatus = toStatus;
	}

	@Column(nullable=false)
	private int actionuser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date date;
	
	@Column(length=100)
	private String remarks;

	//bi-directional many-to-one association to Contact
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="timesheetid", nullable=false)
	private Timesheet timesheet;

	//bi-directional many-to-one association to ContractWorkflowState
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fromstatus", nullable=false)
	private TimesheetStatus fromStatus;

	//bi-directional many-to-one association to ContractWorkflowState
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tostatus", nullable=false)
	private TimesheetStatus toStatus;

}