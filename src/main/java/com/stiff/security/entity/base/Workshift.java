package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the workshift database table.
 * 
 */
@Entity
@Table(name="workshift")
@NamedQuery(name="Workshift.findAll", query="SELECT w FROM Workshift w")
public class Workshift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=8)
	private String endtime;

	@Column(nullable=false, length=45)
	private String shiftName;

	@Column(nullable=false, length=8)
	private String starttime;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="workshift")
	private List<Employee> employees;

	//bi-directional many-to-one association to Timesheet
	@OneToMany(mappedBy="workshift")
	private List<Timesheet> timesheets;

	//bi-directional many-to-one association to VacantPost
	@OneToMany(mappedBy="workshift")
	private List<VacantPost> vacantPosts;

	public Workshift() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getShiftName() {
		return this.shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setWorkshift(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setWorkshift(null);

		return employee;
	}

	public List<Timesheet> getTimesheets() {
		return this.timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public Timesheet addTimesheet(Timesheet timesheet) {
		getTimesheets().add(timesheet);
		timesheet.setWorkshift(this);

		return timesheet;
	}

	public Timesheet removeTimesheet(Timesheet timesheet) {
		getTimesheets().remove(timesheet);
		timesheet.setWorkshift(null);

		return timesheet;
	}

	public List<VacantPost> getVacantPosts() {
		return this.vacantPosts;
	}

	public void setVacantPosts(List<VacantPost> vacantPosts) {
		this.vacantPosts = vacantPosts;
	}

	public VacantPost addVacantPost(VacantPost vacantPost) {
		getVacantPosts().add(vacantPost);
		vacantPost.setWorkshift(this);

		return vacantPost;
	}

	public VacantPost removeVacantPost(VacantPost vacantPost) {
		getVacantPosts().remove(vacantPost);
		vacantPost.setWorkshift(null);

		return vacantPost;
	}

}