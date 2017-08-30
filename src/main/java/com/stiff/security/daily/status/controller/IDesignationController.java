package com.stiff.security.daily.status.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.form.DesignationForm;
import com.stiff.security.daily.status.service.IDesignationService;

public interface IDesignationController
{

	IDesignationService getDesignationService();

	void setDesignationService(IDesignationService designationService);

	String getdata(DesignationForm designationForm, BindingResult result, Map model);

	String processForm(DesignationForm designationForm, BindingResult result, Map model, HttpSession session);

}