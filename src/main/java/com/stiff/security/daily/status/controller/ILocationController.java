package com.stiff.security.daily.status.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.form.LocationForm;
import com.stiff.security.daily.status.service.IFieldOfficerService;
import com.stiff.security.daily.status.service.ILocationService;

public interface ILocationController
{

	void setLocationService(ILocationService locationService);

	String getdata(LocationForm locationForm, BindingResult result, Map model, HttpSession session);

	IFieldOfficerService getFieldOfficerService();

	void setFieldOfficerService(IFieldOfficerService fieldOfficerService);

	ILocationService getLocationService();

	String processForm(LocationForm locationForm, BindingResult result, Map model, HttpSession session);

}