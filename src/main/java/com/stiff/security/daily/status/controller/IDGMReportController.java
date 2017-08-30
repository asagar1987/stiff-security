package com.stiff.security.daily.status.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.form.LoginForm;
import com.stiff.security.daily.status.model.DGMNightConduct;
import com.stiff.security.daily.status.model.DGMSecurityAuditConduct;
import com.stiff.security.daily.status.model.DGMTrainingConduct;
import com.stiff.security.daily.status.model.DGMVisit;
import com.stiff.security.daily.status.service.IDGMNightConductService;
import com.stiff.security.daily.status.service.IDGMSecurityAuditConductService;
import com.stiff.security.daily.status.service.IDGMTrainingConductService;
import com.stiff.security.daily.status.service.IDGMVisitService;

public interface IDGMReportController
{

	IDGMVisitService getDgmVisitService();

	void setDgmVisitService(IDGMVisitService dgmVisitService);

	IDGMTrainingConductService getDgmTrainingConductService();

	void setDgmTrainingConductService(IDGMTrainingConductService dgmTrainingConductService);

	IDGMNightConductService getDgmNightConductService();

	void setDgmNightConductService(IDGMNightConductService dgmNightConductService);

	IDGMSecurityAuditConductService getDgmSecurityAuditConductService();

	void setDgmSecurityAuditConductService(IDGMSecurityAuditConductService dgmSecurityAuditConductService);

	List<DGMTrainingConduct> getMyTrainingConductList();

	void setMyTrainingConductList(List<DGMTrainingConduct> myTrainingConductList);

	List<DGMVisit> getMyVisitList();

	void setMyVisitList(List<DGMVisit> myVisitList);

	List<DGMSecurityAuditConduct> getMySecurityAuditConductList();

	void setMySecurityAuditConductList(List<DGMSecurityAuditConduct> mySecurityAuditConductList);

	List<DGMNightConduct> getMyNightConductList();

	void setMyNightConductList(List<DGMNightConduct> myNightConductList);

	String getdata(LoginForm loginForm, BindingResult result, Map model, HttpSession session);

}