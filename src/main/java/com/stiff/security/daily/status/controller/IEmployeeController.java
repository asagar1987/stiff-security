package com.stiff.security.daily.status.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stiff.security.daily.status.form.EmployeeForm;
import com.stiff.security.daily.status.service.IDesignationService;
import com.stiff.security.daily.status.service.IEmployeeService;
import com.stiff.security.daily.status.service.IFieldOfficerService;
import com.stiff.security.daily.status.service.ILocationService;

public interface IEmployeeController
{

	IFieldOfficerService getFieldOfficerService();

	void setFieldOfficerService(IFieldOfficerService fieldOfficerService);

	IEmployeeService getEmployeeService();

	void setEmployeeService(IEmployeeService employeeService);

	ILocationService getLocationService();

	void setLocationService(ILocationService locationService);

	IDesignationService getDesignationService();

	void setDesignationService(IDesignationService designationService);

	String getdata(EmployeeForm employeeForm, BindingResult result, Map model, HttpSession session);

	String editEmployee(long id, String designation, EmployeeForm employeeForm, BindingResult result, Map model,
			HttpSession session);

	String removeEmployee(long id, String designation, EmployeeForm employeeForm, BindingResult result, Map model,
			HttpSession session);

	String processForm(EmployeeForm employeeForm, BindingResult result, Map model, HttpSession session);

}