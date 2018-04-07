package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the timesheet_status database table.
 * 
 */
@Entity
@Table(name="timesheet_status")
@NamedQuery(name="TimesheetStatus.findAll", query="SELECT t FROM TimesheetStatus t")
public class TimesheetStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=30)
	private String color;

	@Column(length=45)
	private String description;

	@Column(nullable=false, length=45)
	private String timesheetstatus;

	//bi-directional many-to-one association to Timesheet
	@OneToMany(mappedBy="timesheetStatus")
	private List<Timesheet> timesheets;

	public TimesheetStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimesheetstatus() {
		return this.timesheetstatus;
	}

	public void setTimesheetstatus(String timesheetstatus) {
		this.timesheetstatus = timesheetstatus;
	}

	public List<Timesheet> getTimesheets() {
		return this.timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public Timesheet addTimesheet(Timesheet timesheet) {
		getTimesheets().add(timesheet);
		timesheet.setTimesheetStatus(this);

		return timesheet;
	}

	public Timesheet removeTimesheet(Timesheet timesheet) {
		getTimesheets().remove(timesheet);
		timesheet.setTimesheetStatus(null);

		return timesheet;
	}

}