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

import com.stiff.security.daily.status.controller.IHRReportsController;
import com.stiff.security.daily.status.form.LoginForm;
import com.stiff.security.daily.status.model.DGMNightConduct;
import com.stiff.security.daily.status.model.DGMSecurityAuditConduct;
import com.stiff.security.daily.status.model.DGMTrainingConduct;
import com.stiff.security.daily.status.model.DGMVisit;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.model.HRForm;
import com.stiff.security.daily.status.service.IDGMNightConductService;
import com.stiff.security.daily.status.service.IDGMSecurityAuditConductService;
import com.stiff.security.daily.status.service.IDGMTrainingConductService;
import com.stiff.security.daily.status.service.IDGMVisitService;
import com.stiff.security.daily.status.service.IHRFormService;

@Component
@Controller
@RequestMapping("hrReportsForm")
public class HRReportsController implements IHRReportsController 
{
	
	@Autowired
	private IHRFormService hrFormService;
	
	private List<HRForm> myHRFormList;
	
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IHRReportsController#getdata(com.stiff.security.daily.status.form.LoginForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid LoginForm loginForm, BindingResult result, Map model, HttpSession session)
	{
		
		System.out.println("Get Data from marketing controller");
		if(session.getAttribute("loggedInUser")==null)
			return "loginForm";
		
		myHRFormList = hrFormService.getAllVisits();
		model.put("myHRFormList", myHRFormList);
		
		
		System.out.println("Exiting Marketing Controller");
		return "hrReportsForm";
	}
}
