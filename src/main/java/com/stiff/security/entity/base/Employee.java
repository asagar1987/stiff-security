package com.stiff.security.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=100)
	private String displayname;

	@Column(nullable=false)
	private int enabled;

	@Column(nullable=false, length=45)
	private String firstname;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date hiredate;

	@Column(nullable=false, length=45)
	private String lastname;

	@Column(nullable=false, length=150)
	private String password;

	@Lob
	private byte[] profilepicture;

	@Temporal(TemporalType.DATE)
	private Date terminationdate;

	@Column(nullable=false, length=45)
	private String username;

	//bi-directional many-to-one association to Conduct
	@OneToMany(mappedBy="employee")
	private List<Conduct> conducts;

	//bi-directional many-to-one association to DailyReport
	@OneToMany(mappedBy="employee")
	private List<DailyReport> dailyReports;

	//bi-directional many-to-one association to Department
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="department_ID", nullable=false)
	private Department department;

	//bi-directional many-to-one association to Designation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="designation_ID", nullable=false)
	private Designation designation;

	//bi-directional many-to-one association to EmployeeStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employeestatus_ID", nullable=false)
	private EmployeeStatus employeeStatus;

	//bi-directional many-to-one association to Worklocation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="worklocation_ID", nullable=false)
	private Worklocation worklocation;

	//bi-directional many-to-one association to Workshift
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="workshift_ID", nullable=false)
	private Workshift workshift;

		//bi-directional many-to-one association to Marketing
	@OneToMany(mappedBy="employee")
	private List<Marketing> marketings;

	
	@OneToMany(mappedBy="employee")
	private List<LeaveApplication> leaveApplications;
	public List<LeaveApplication> getLeaveApplications()
	{
		return leaveApplications;
	}

	public void setLeaveApplications(List<LeaveApplication> leaveApplications)
	{
		this.leaveApplications = leaveApplications;
	}

	//bi-directional many-to-one association to Overtime
	@OneToMany(mappedBy="employee")
	private List<Overtime> overtimes;

	//bi-directional many-to-many association to Address
	@ManyToMany
	private List<Address> addresses;

	//bi-directional many-to-many association to Timesheet
	@ManyToMany
	@JoinColumn(name="ID", referencedColumnName="ID", nullable=false, insertable=false, updatable=false)
	private List<Timesheet> timesheets;

	//bi-directional many-to-many association to Contact
	@ManyToMany
	@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private List<Contact> contacts;

	//bi-directional many-to-many association to Event
	@ManyToMany(mappedBy="invitedEmployees")
	private List<Event> events;

	public Employee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getProfilepicture() {
		return this.profilepicture;
	}

	public void setProfilepicture(byte[] profilepicture) {
		this.profilepicture = profilepicture;
	}

	public Date getTerminationdate() {
		return this.terminationdate;
	}

	public void setTerminationdate(Date terminationdate) {
		this.terminationdate = terminationdate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Conduct> getConducts() {
		return this.conducts;
	}

	public void setConducts(List<Conduct> conducts) {
		this.conducts = conducts;
	}

	public Conduct addConduct(Conduct conduct) {
		getConducts().add(conduct);
		conduct.setEmployee(this);

		return conduct;
	}

	public Conduct removeConduct(Conduct conduct) {
		getConducts().remove(conduct);
		conduct.setEmployee(null);

		return conduct;
	}

	public List<DailyReport> getDailyReports() {
		return this.dailyReports;
	}

	public void setDailyReports(List<DailyReport> dailyReports) {
		this.dailyReports = dailyReports;
	}

	public DailyReport addDailyReport(DailyReport dailyReport) {
		getDailyReports().add(dailyReport);
		dailyReport.setEmployee(this);

		return dailyReport;
	}

	public DailyReport removeDailyReport(DailyReport dailyReport) {
		getDailyReports().remove(dailyReport);
		dailyReport.setEmployee(null);

		return dailyReport;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Designation getDesignation() {
		return this.designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public EmployeeStatus getEmployeeStatus() {
		return this.employeeStatus;
	}

	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Worklocation getWorklocation() {
		return this.worklocation;
	}

	public void setWorklocation(Worklocation worklocation) {
		this.worklocation = worklocation;
	}

	public Workshift getWorkshift() {
		return this.workshift;
	}

	public void setWorkshift(Workshift workshift) {
		this.workshift = workshift;
	}

	

	public List<Marketing> getMarketings() {
		return this.marketings;
	}

	public void setMarketings(List<Marketing> marketings) {
		this.marketings = marketings;
	}

	public Marketing addMarketing(Marketing marketing) {
		getMarketings().add(marketing);
		marketing.setEmployee(this);

		return marketing;
	}

	public Marketing removeMarketing(Marketing marketing) {
		getMarketings().remove(marketing);
		marketing.setEmployee(null);

		return marketing;
	}

	public List<Overtime> getOvertimes() {
		return this.overtimes;
	}

	public void setOvertimes(List<Overtime> overtimes) {
		this.overtimes = overtimes;
	}

	public Overtime addOvertime(Overtime overtime) {
		getOvertimes().add(overtime);
		overtime.setEmployee(this);

		return overtime;
	}

	public Overtime removeOvertime(Overtime overtime) {
		getOvertimes().remove(overtime);
		overtime.setEmployee(null);

		return overtime;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Timesheet> getTimesheets() {
		return this.timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	
	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}