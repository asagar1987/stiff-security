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

import com.stiff.security.daily.status.controller.IDGMVisitController;
import com.stiff.security.daily.status.model.DGMVisit;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.service.IDGMVisitService;

@Controller
@Component
@RequestMapping("dgmVisitForm")

public class DGMVisitController implements IDGMVisitController
{
	
	@Autowired
	private IDGMVisitService dgmVisitService;
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMVisitController#getdata(com.stiff.security.daily.status.model.DGMVisit, org.springframework.validation.BindingResult, java.util.Map)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid DGMVisit dgmVisitForm, BindingResult result, Map model)
	{
		dgmVisitForm = new DGMVisit();
		model.put("visitForm", dgmVisitForm);
		return "visitForm";

	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMVisitController#processForm(com.stiff.security.daily.status.model.DGMVisit, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid DGMVisit dgmVisitForm, BindingResult result, @SuppressWarnings("rawtypes") Map model, HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		System.out.println("Processing Designation Form");
		
		try
		{
			dgmVisitForm.setFieldOfficer((FieldOfficer)session.getAttribute("loggedInUser"));
			//visitForm.setvisitDate(new Date(visitForm.getTempDate()));
			System.out.println(dgmVisitForm.toString());
			
			dgmVisitService.addMarketingVisit(dgmVisitForm);
			return "DGMHomeRedirect";
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			result.rejectValue("visitDate", "designationAddException");
			return getdata(dgmVisitForm, result, model);
		}
		
	}

}
