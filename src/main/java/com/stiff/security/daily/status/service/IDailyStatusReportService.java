package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.model.DailyStatusReport;
import com.stiff.security.daily.status.model.Employee;

public interface IDailyStatusReportService
{

	void addNewReport(DailyStatusReport dsr);

	List<DailyStatusReport> getReportsForOfficer(long id);

	DailyStatusReport getReportById(int reportId);

	List<DailyStatusReport> getAllReport();

}