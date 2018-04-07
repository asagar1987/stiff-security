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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the marketing database table.
 * 
 */
@Entity
@Table(name="marketing")
@NamedQuery(name="Marketing.findAll", query="SELECT m FROM Marketing m")
public class Marketing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String contactperson;

	@Column(length=45)
	private String contactpersonaddress;

	@Column(length=45)
	private String contactpersonnumber;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(length=45)
	private String remarks;

	@Column(length=45)
	private String siteaddress;

	@Column(length=45)
	private String sitename;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_ID", nullable=false)
	private Employee employee;

	//bi-directional many-to-one association to Marketing
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="marketing_ID")
	private Marketing marketing;

	//bi-directional many-to-one association to Marketing
	@OneToMany(mappedBy="marketing")
	private List<Marketing> followUpThread;

	//bi-directional many-to-one association to MarketingActivityType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="marketing_activity_ID", nullable=false)
	private MarketingActivityType marketingActivityType;

	public Marketing() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContactperson() {
		return this.contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getContactpersonaddress() {
		return this.contactpersonaddress;
	}

	public void setContactpersonaddress(String contactpersonaddress) {
		this.contactpersonaddress = contactpersonaddress;
	}

	public String getContactpersonnumber() {
		return this.contactpersonnumber;
	}

	public void setContactpersonnumber(String contactpersonnumber) {
		this.contactpersonnumber = contactpersonnumber;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSiteaddress() {
		return this.siteaddress;
	}

	public void setSiteaddress(String siteaddress) {
		this.siteaddress = siteaddress;
	}

	public String getSitename() {
		return this.sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Marketing getMarketing() {
		return this.marketing;
	}

	public void setMarketing(Marketing marketing) {
		this.marketing = marketing;
	}

	public List<Marketing> getFollowUpThread() {
		return this.followUpThread;
	}

	public void setFollowUpThread(List<Marketing> followUpThread) {
		this.followUpThread = followUpThread;
	}

	public Marketing addFollowUpThread(Marketing followUpThread) {
		getFollowUpThread().add(followUpThread);
		followUpThread.setMarketing(this);

		return followUpThread;
	}

	public Marketing removeFollowUpThread(Marketing followUpThread) {
		getFollowUpThread().remove(followUpThread);
		followUpThread.setMarketing(null);

		return followUpThread;
	}

	public MarketingActivityType getMarketingActivityType() {
		return this.marketingActivityType;
	}

	public void setMarketingActivityType(MarketingActivityType marketingActivityType) {
		this.marketingActivityType = marketingActivityType;
	}

}