package com.stiff.security.daily.status.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;


@SuppressWarnings("serial")
@Entity
@Table(name="hrreport")
@Component
public class HRForm implements Serializable
{

	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="hrreportid")
	private long hrReportId;
	
	@Column(name="mailCheck")
	private String mailCheck;
	@Column(name="mailCheckRemarks")
	private String mailCheckRemarks;
	
	@Column(name="nasReportProcess")
	private String nasReportProcess;
	@Column(name="nasReportProcessRemarks")
	private String nasReportProcessRemarks;
	@Column(name="nasReportMail")
	private String nasReportMail;
	@Column(name="nasReportMailRemarks")
	private String nasReportMailRemarks;
	@Column(name="nasReportPrint")
	private String nasReportPrint;
	@Column(name="nasReportPrintRemarks")
	private String nasReportPrintRemarks;
	
	@Column(name="attendance")
	private String attendance;
	@Column(name="attendanceRemarks")
	private String attendanceRemarks;
	@Column(name="uniformIssue")
	private String uniformIssue;
	@Column(name="uniformIssueRemarks")
	private String uniformIssueRemarks;
	@Column(name="uniformStock")
	private String uniformStock;
	@Column(name="uniformStockRemarks")
	private String uniformStockRemarks;

	@Column(name="staffSalary")
	private String staffSalary;
	@Column(name="staffSalaryRemarks")
	private String staffSalaryRemarks;
	@Column(name="pfEsiSheet")
	private String pfEsiSheet;
	@Column(name="pfEsiSheetRemarks")
	private String pfEsiSheetRemarks;
	@Column(name="joiningForms")
	private String joiningForms;
	
	@Column(name="joiningFormsRemarks")
	private String joiningFormsRemarks;
	@Column(name="adminWork")
	private String adminWork;
	@Column(name="adminWorkRemarks")
	private String adminWorkRemarks;
	
	@Column(name="nasPenaltyReport")
	private String nasPenaltyReport;
	@Column(name="nasPenaltyReportRemarks")
	private String nasPenaltyReportRemarks;
	
	@Column(name="siteVisit")
	private String siteVisit;
	@Column(name="siteVisitRemarks")
	private String siteVisitRemarks;
	
	@Column(name="qrCodesWorking")
	private String qrCodesWorking;
	@Column(name="qrCodesWorkingRemarks")
	private String qrCodesWorkingRemarks;
	
	@Column(name="nasReportSubmitToRakesh")
	private String nasReportSubmitToRakesh;
	@Column(name="nasReportSubmitToRakeshRemarks")
	private String nasReportSubmitToRakeshRemarks;
	
	@Column(name="pasara")
	private String pasara;
	@Column(name="pasaraRemarks")
	private String pasaraRemarks;
	
	@Column(name="nowFloats")
	private String nowFloats;
	@Column(name="nowFloatsRemarks")
	private String nowFloatsRemarks;
	
	@Column(name="rateRevision")
	private String rateRevision;
	@Column(name="rateRevisionRemarks")
	private String rateRevisionRemarks;
	
	@Column(name="groupInsurance")
	private String groupInsurance;
	@Column(name="groupInsuranceRemarks")
	private String groupInsuranceRemarks;
	
	@Column(name="smsSoftware")
	private String smsSoftware;
	@Column(name="smsSoftwareRemarks")
	private String smsSoftwareRemarks;
	
	@Column(name="tendering")
	private String tendering;
	@Column(name="tenderingRemarks")
	private String tenderingRemarks;
	
	@Column(name="trainer")
	private String trainer;
	@Column(name="trainerRemarks")
	private String trainerRemarks;
	
	@Override
	public String toString()
	{
		return "HRForm [hrReportId=" + hrReportId + ", mailCheck=" + mailCheck + ", mailCheckRemarks="
				+ mailCheckRemarks + ", nasReportProcess=" + nasReportProcess + ", nasReportProcessRemarks="
				+ nasReportProcessRemarks + ", nasReportMail=" + nasReportMail + ", nasReportMailRemarks="
				+ nasReportMailRemarks + ", nasReportPrint=" + nasReportPrint + ", nasReportPrintRemarks="
				+ nasReportPrintRemarks + ", attendance=" + attendance + ", attendanceRemarks=" + attendanceRemarks
				+ ", uniformIssue=" + uniformIssue + ", uniformIssueRemarks=" + uniformIssueRemarks + ", uniformStock="
				+ uniformStock + ", uniformStockRemarks=" + uniformStockRemarks + ", staffSalary=" + staffSalary
				+ ", staffSalaryRemarks=" + staffSalaryRemarks + ", pfEsiSheet=" + pfEsiSheet + ", pfEsiSheetRemarks="
				+ pfEsiSheetRemarks + ", joiningForms=" + joiningForms + ", joiningFormsRemarks=" + joiningFormsRemarks
				+ ", adminWork=" + adminWork + ", adminWorkRemarks=" + adminWorkRemarks + ", nasPenaltyReport="
				+ nasPenaltyReport + ", nasPenaltyReportRemarks=" + nasPenaltyReportRemarks + ", siteVisit=" + siteVisit
				+ ", siteVisitRemarks=" + siteVisitRemarks + ", qrCodesWorking=" + qrCodesWorking
				+ ", qrCodesWorkingRemarks=" + qrCodesWorkingRemarks + ", nasReportSubmitToRakesh="
				+ nasReportSubmitToRakesh + ", nasReportSubmitToRakeshRemarks=" + nasReportSubmitToRakeshRemarks
				+ ", pasara=" + pasara + ", pasaraRemarks=" + pasaraRemarks + ", nowFloats=" + nowFloats
				+ ", nowFloatsRemarks=" + nowFloatsRemarks + ", rateRevision=" + rateRevision + ", rateRevisionRemarks="
				+ rateRevisionRemarks + ", groupInsurance=" + groupInsurance + ", groupInsuranceRemarks="
				+ groupInsuranceRemarks + ", smsSoftware=" + smsSoftware + ", smsSoftwareRemarks=" + smsSoftwareRemarks
				+ ", tendering=" + tendering + ", tenderingRemarks=" + tenderingRemarks + ", trainer=" + trainer
				+ ", trainerRemarks=" + trainerRemarks + ", policeVerification=" + policeVerification
				+ ", policeVerificationRemarks=" + policeVerificationRemarks + ", reportDate=" + reportDate + "]";
	}

	@Column(name="policeVerification")
	private String policeVerification;
	@Column(name="policeVerificationRemarks")
	private String policeVerificationRemarks;
	
	@Column(name="reportDate")
	private String reportDate;
	
	public long getHrReportId()
	{
		return hrReportId;
	}

	public void setHrReportId(long hrReportId)
	{
		this.hrReportId = hrReportId;
	}

	public String getMailCheck()
	{
		return mailCheck;
	}

	public void setMailCheck(String mailCheck)
	{
		this.mailCheck = mailCheck;
	}

	public String getMailCheckRemarks()
	{
		return mailCheckRemarks;
	}

	public void setMailCheckRemarks(String mailCheckRemarks)
	{
		this.mailCheckRemarks = mailCheckRemarks;
	}

	public String getNasReportProcess()
	{
		return nasReportProcess;
	}

	public void setNasReportProcess(String nasReportProcess)
	{
		this.nasReportProcess = nasReportProcess;
	}

	public String getNasReportProcessRemarks()
	{
		return nasReportProcessRemarks;
	}

	public void setNasReportProcessRemarks(String nasReportProcessRemarks)
	{
		this.nasReportProcessRemarks = nasReportProcessRemarks;
	}

	public String getNasReportMail()
	{
		return nasReportMail;
	}

	public void setNasReportMail(String nasReportMail)
	{
		this.nasReportMail = nasReportMail;
	}

	public String getNasReportMailRemarks()
	{
		return nasReportMailRemarks;
	}

	public void setNasReportMailRemarks(String nasReportMailRemarks)
	{
		this.nasReportMailRemarks = nasReportMailRemarks;
	}

	public String getNasReportPrint()
	{
		return nasReportPrint;
	}

	public void setNasReportPrint(String nasReportPrint)
	{
		this.nasReportPrint = nasReportPrint;
	}

	public String getNasReportPrintRemarks()
	{
		return nasReportPrintRemarks;
	}

	public void setNasReportPrintRemarks(String nasReportPrintRemarks)
	{
		this.nasReportPrintRemarks = nasReportPrintRemarks;
	}

	public String getAttendance()
	{
		return attendance;
	}

	public void setAttendance(String attendance)
	{
		this.attendance = attendance;
	}

	public String getAttendanceRemarks()
	{
		return attendanceRemarks;
	}

	public void setAttendanceRemarks(String attendanceRemarks)
	{
		this.attendanceRemarks = attendanceRemarks;
	}

	public String getUniformIssue()
	{
		return uniformIssue;
	}

	public void setUniformIssue(String uniformIssue)
	{
		this.uniformIssue = uniformIssue;
	}

	public String getUniformIssueRemarks()
	{
		return uniformIssueRemarks;
	}

	public void setUniformIssueRemarks(String uniformIssueRemarks)
	{
		this.uniformIssueRemarks = uniformIssueRemarks;
	}

	public String getUniformStock()
	{
		return uniformStock;
	}

	public void setUniformStock(String uniformStock)
	{
		this.uniformStock = uniformStock;
	}

	public String getUniformStockRemarks()
	{
		return uniformStockRemarks;
	}

	public void setUniformStockRemarks(String uniformStockRemarks)
	{
		this.uniformStockRemarks = uniformStockRemarks;
	}

	public String getStaffSalary()
	{
		return staffSalary;
	}

	public void setStaffSalary(String staffSalary)
	{
		this.staffSalary = staffSalary;
	}

	public String getStaffSalaryRemarks()
	{
		return staffSalaryRemarks;
	}

	public void setStaffSalaryRemarks(String staffSalaryRemarks)
	{
		this.staffSalaryRemarks = staffSalaryRemarks;
	}

	public String getPfEsiSheet()
	{
		return pfEsiSheet;
	}

	public void setPfEsiSheet(String pfEsiSheet)
	{
		this.pfEsiSheet = pfEsiSheet;
	}

	public String getPfEsiSheetRemarks()
	{
		return pfEsiSheetRemarks;
	}

	public void setPfEsiSheetRemarks(String pfEsiSheetRemarks)
	{
		this.pfEsiSheetRemarks = pfEsiSheetRemarks;
	}

	public String getJoiningForms()
	{
		return joiningForms;
	}

	public void setJoiningForms(String joiningForms)
	{
		this.joiningForms = joiningForms;
	}

	public String getJoiningFormsRemarks()
	{
		return joiningFormsRemarks;
	}

	public void setJoiningFormsRemarks(String joiningFormsRemarks)
	{
		this.joiningFormsRemarks = joiningFormsRemarks;
	}

	public String getAdminWork()
	{
		return adminWork;
	}

	public void setAdminWork(String adminWork)
	{
		this.adminWork = adminWork;
	}

	public String getAdminWorkRemarks()
	{
		return adminWorkRemarks;
	}

	public void setAdminWorkRemarks(String adminWorkRemarks)
	{
		this.adminWorkRemarks = adminWorkRemarks;
	}

	public String getNasPenaltyReport()
	{
		return nasPenaltyReport;
	}

	public void setNasPenaltyReport(String nasPenaltyReport)
	{
		this.nasPenaltyReport = nasPenaltyReport;
	}

	public String getNasPenaltyReportRemarks()
	{
		return nasPenaltyReportRemarks;
	}

	public void setNasPenaltyReportRemarks(String nasPenaltyReportRemarks)
	{
		this.nasPenaltyReportRemarks = nasPenaltyReportRemarks;
	}

	public String getSiteVisit()
	{
		return siteVisit;
	}

	public void setSiteVisit(String siteVisit)
	{
		this.siteVisit = siteVisit;
	}

	public String getSiteVisitRemarks()
	{
		return siteVisitRemarks;
	}

	public void setSiteVisitRemarks(String siteVisitRemarks)
	{
		this.siteVisitRemarks = siteVisitRemarks;
	}

	public String getQrCodesWorking()
	{
		return qrCodesWorking;
	}

	public void setQrCodesWorking(String qrCodesWorking)
	{
		this.qrCodesWorking = qrCodesWorking;
	}

	public String getQrCodesWorkingRemarks()
	{
		return qrCodesWorkingRemarks;
	}

	public void setQrCodesWorkingRemarks(String qrCodesWorkingRemarks)
	{
		this.qrCodesWorkingRemarks = qrCodesWorkingRemarks;
	}

	public String getNasReportSubmitToRakesh()
	{
		return nasReportSubmitToRakesh;
	}

	public void setNasReportSubmitToRakesh(String nasReportSubmitToRakesh)
	{
		this.nasReportSubmitToRakesh = nasReportSubmitToRakesh;
	}

	public String getNasReportSubmitToRakeshRemarks()
	{
		return nasReportSubmitToRakeshRemarks;
	}

	public void setNasReportSubmitToRakeshRemarks(String nasReportSubmitToRakeshRemarks)
	{
		this.nasReportSubmitToRakeshRemarks = nasReportSubmitToRakeshRemarks;
	}

	public String getPasara()
	{
		return pasara;
	}

	public void setPasara(String pasara)
	{
		this.pasara = pasara;
	}

	public String getPasaraRemarks()
	{
		return pasaraRemarks;
	}

	public void setPasaraRemarks(String pasaraRemarks)
	{
		this.pasaraRemarks = pasaraRemarks;
	}

	public String getNowFloats()
	{
		return nowFloats;
	}

	public void setNowFloats(String nowFloats)
	{
		this.nowFloats = nowFloats;
	}

	public String getNowFloatsRemarks()
	{
		return nowFloatsRemarks;
	}

	public void setNowFloatsRemarks(String nowFloatsRemarks)
	{
		this.nowFloatsRemarks = nowFloatsRemarks;
	}

	public String getRateRevision()
	{
		return rateRevision;
	}

	public void setRateRevision(String rateRevision)
	{
		this.rateRevision = rateRevision;
	}

	public String getRateRevisionRemarks()
	{
		return rateRevisionRemarks;
	}

	public void setRateRevisionRemarks(String rateRevisionRemarks)
	{
		this.rateRevisionRemarks = rateRevisionRemarks;
	}

	public String getGroupInsurance()
	{
		return groupInsurance;
	}

	public void setGroupInsurance(String groupInsurance)
	{
		this.groupInsurance = groupInsurance;
	}

	public String getGroupInsuranceRemarks()
	{
		return groupInsuranceRemarks;
	}

	public void setGroupInsuranceRemarks(String groupInsuranceRemarks)
	{
		this.groupInsuranceRemarks = groupInsuranceRemarks;
	}

	public String getSmsSoftware()
	{
		return smsSoftware;
	}

	public void setSmsSoftware(String smsSoftware)
	{
		this.smsSoftware = smsSoftware;
	}

	public String getSmsSoftwareRemarks()
	{
		return smsSoftwareRemarks;
	}

	public void setSmsSoftwareRemarks(String smsSoftwareRemarks)
	{
		this.smsSoftwareRemarks = smsSoftwareRemarks;
	}

	public String getTendering()
	{
		return tendering;
	}

	public void setTendering(String tendering)
	{
		this.tendering = tendering;
	}

	public String getTenderingRemarks()
	{
		return tenderingRemarks;
	}

	public void setTenderingRemarks(String tenderingRemarks)
	{
		this.tenderingRemarks = tenderingRemarks;
	}

	public String getTrainer()
	{
		return trainer;
	}

	public void setTrainer(String trainer)
	{
		this.trainer = trainer;
	}

	public String getTrainerRemarks()
	{
		return trainerRemarks;
	}

	public void setTrainerRemarks(String trainerRemarks)
	{
		this.trainerRemarks = trainerRemarks;
	}

	public String getPoliceVerification()
	{
		return policeVerification;
	}

	public void setPoliceVerification(String policeVerification)
	{
		this.policeVerification = policeVerification;
	}

	public String getPoliceVerificationRemarks()
	{
		return policeVerificationRemarks;
	}

	public void setPoliceVerificationRemarks(String policeVerificationRemarks)
	{
		this.policeVerificationRemarks = policeVerificationRemarks;
	}

	public String getReportDate()
	{
		return reportDate;
	}

	public void setReportDate(String reportDate)
	{
		this.reportDate = reportDate;
	}

	public FieldOfficer getFilledBy()
	{
		return filledBy;
	}

	public void setFilledBy(FieldOfficer filledBy)
	{
		this.filledBy = filledBy;
	}

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.REFRESH)
	@JoinColumn(name="filledBy")
	private FieldOfficer filledBy;
	
	
}
