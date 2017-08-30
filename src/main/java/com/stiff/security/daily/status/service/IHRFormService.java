package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.model.HRForm;

public interface IHRFormService
{

	List<HRForm> getVisitsForOfficer(long id);

	List<HRForm> getAllVisits();

	void addHRForm(HRForm m);

	HRForm getReportById(int reportId);

}