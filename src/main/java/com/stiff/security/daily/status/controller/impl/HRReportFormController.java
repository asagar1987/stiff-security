package com.stiff.security.daily.status.controller.impl;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stiff.security.daily.status.controller.IHRReportFormController;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.model.HRForm;
import com.stiff.security.daily.status.service.IHRFormService;

@Controller
@Component
@RequestMapping("hrReportForm")

public class HRReportFormController implements IHRReportFormController
{
	
	@Autowired
	private IHRFormService hrFormService;

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IHRReportFormController#getHrFormService()
	 */
	@Override
	public IHRFormService getHrFormService()
	{
		return hrFormService;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IHRReportFormController#setHrFormService(com.stiff.security.daily.status.service.IHRFormService)
	 */
	@Override
	public void setHrFormService(IHRFormService hrFormService)
	{
		this.hrFormService = hrFormService;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IHRReportFormController#getReport(int, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(value = "/getHRReport", method = RequestMethod.GET)
	public String getReport(@RequestParam int reportId, HttpSession session) 
	{
		System.out.println("Received Report Id as "+reportId);
		if(session.getAttribute("linkReport")!=null)
			session.removeAttribute("linkReport");
		
		HRForm h = hrFormService.getReportById(reportId);
		System.out.println(h.toString());
		session.setAttribute("linkReport",h );
		return "finalHRReport";
	}
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IHRReportFormController#getdata(com.stiff.security.daily.status.model.HRForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid HRForm hrForm, BindingResult result, Map model, HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		
		hrForm = new HRForm();
		model.put("hrForm", hrForm);
		return "hrReportForm";

	}
	
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IHRReportFormController#processForm(com.stiff.security.daily.status.model.HRForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid HRForm hrForm, BindingResult result, @SuppressWarnings("rawtypes") Map model, HttpSession session)
	{
		
		
		hrForm.setFilledBy((FieldOfficer)session.getAttribute("loggedInUser"));
		System.out.println(hrForm.toString());
		hrFormService.addHRForm(hrForm);
		return getdata(hrForm, result, model, session);
		
	}

}
