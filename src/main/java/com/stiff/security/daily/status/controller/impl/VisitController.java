package com.stiff.security.daily.status.controller.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.controller.IVisitController;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.model.MarketingVisit;
import com.stiff.security.daily.status.service.IMarketingVisitService;

@Controller
@Component
@RequestMapping("visitForm")

public class VisitController implements IVisitController
{
	
	@Autowired
	private IMarketingVisitService marketingVisitService;
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IVisitController#getdata(com.stiff.security.daily.status.model.MarketingVisit, org.springframework.validation.BindingResult, java.util.Map)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid MarketingVisit visitForm, BindingResult result, Map model)
	{
		visitForm = new MarketingVisit();
		model.put("visitForm", visitForm);
		return "visitForm";

	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IVisitController#processForm(com.stiff.security.daily.status.model.MarketingVisit, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid MarketingVisit visitForm, BindingResult result, @SuppressWarnings("rawtypes") Map model, HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		System.out.println("Processing Designation Form");
		
		try
		{
			visitForm.setFieldOfficer((FieldOfficer)session.getAttribute("loggedInUser"));
			//visitForm.setvisitDate(new Date(visitForm.getTempDate()));
			System.out.println(visitForm.toString());
			
			marketingVisitService.addMarketingVisit(visitForm);
			return "MarketingHomeRedirect";
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			result.rejectValue("visitDate", "designationAddException");
			return getdata(visitForm, result, model);
		}
		
	}

}
