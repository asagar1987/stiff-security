package com.stiff.security.daily.status.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stiff.security.daily.status.form.DailyStatusReportForm;
import com.stiff.security.daily.status.model.DailyStatusReport;
import com.stiff.security.daily.status.model.Employee;
import com.stiff.security.daily.status.service.IEmployeeService;
import com.stiff.security.daily.status.service.ILocationService;

public interface IDailyStatusReportController
{

	List<DailyStatusReport> getMyDailyReportsList();

	void setMyDailyReportsList(List<DailyStatusReport> myDailyReportsList);

	List<Employee> getEmployeeList();

	void setEmployeeList(List<Employee> employeeList);

	IEmployeeService getEmployeeService();

	void setEmployeeService(IEmployeeService employeeService);

	ILocationService getLocationService();

	void setLocationService(ILocationService locationService);

	String getdata(DailyStatusReportForm dailyStatusReportForm, BindingResult result, Map model, HttpSession session);

	List<Employee> getEmpoyees(String tagName);

	String getReport(int reportId, HttpSession session);

	HttpEntity<byte[]> getReport(int reportId, String name, HttpSession session);

	String processForm(DailyStatusReportForm dailyStatusReportForm, BindingResult result, Map model,
			HttpSession session);

}