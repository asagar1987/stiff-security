package com.stiff.security.daily.status.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stiff.security.daily.status.model.HRForm;
import com.stiff.security.daily.status.service.IHRFormService;

public interface IHRReportFormController
{

	IHRFormService getHrFormService();

	void setHrFormService(IHRFormService hrFormService);

	String getReport(int reportId, HttpSession session);

	String getdata(HRForm hrForm, BindingResult result, Map model, HttpSession session);

	String processForm(HRForm hrForm, BindingResult result, Map model, HttpSession session);

}