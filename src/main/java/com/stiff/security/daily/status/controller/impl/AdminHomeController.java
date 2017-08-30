package com.stiff.security.daily.status.controller.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.controller.IAdminHomeController;
import com.stiff.security.daily.status.form.LoginForm;
import com.stiff.security.daily.status.model.DailyStatusReport;
import com.stiff.security.daily.status.service.IDailyStatusReportService;

@Controller
@Component
@RequestMapping("AdminHome")
public class AdminHomeController implements IAdminHomeController
{
	
	List<DailyStatusReport> myDailyReportsList;
	
	
	@Autowired
	private IDailyStatusReportService dailyStatusReportService;
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminHomeController#getdata(com.stiff.security.daily.status.form.LoginForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid LoginForm loginForm, BindingResult result, Map model, HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "loginForm";
		myDailyReportsList = dailyStatusReportService.getAllReport();
		model.put("myDailyReportsList",myDailyReportsList);
		return "AdminHome";
	}
}
