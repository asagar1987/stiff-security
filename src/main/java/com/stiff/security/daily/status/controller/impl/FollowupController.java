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

import com.stiff.security.daily.status.controller.IFollowupController;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.model.MarketingFollowup;
import com.stiff.security.daily.status.service.IMarketingFollowupService;

@Controller
@Component
@RequestMapping("followupForm")

public class FollowupController implements IFollowupController
{
	
	@Autowired
	private IMarketingFollowupService marketingFollowupService;
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IFollowupController#getdata(com.stiff.security.daily.status.model.MarketingFollowup, org.springframework.validation.BindingResult, java.util.Map)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid MarketingFollowup followupForm, BindingResult result, Map model)
	{
		followupForm = new MarketingFollowup();
		model.put("followupForm", followupForm);
		return "followupForm";

	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IFollowupController#processForm(com.stiff.security.daily.status.model.MarketingFollowup, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid MarketingFollowup followupForm, BindingResult result, @SuppressWarnings("rawtypes") Map model, HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		System.out.println("Processing Designation Form");
		
		try
		{
			followupForm.setFieldOfficer((FieldOfficer)session.getAttribute("loggedInUser"));
			//FollowupForm.setFollowupDate(new Date(FollowupForm.getTempDate()));
			System.out.println(followupForm.toString());
			
			marketingFollowupService.addMarketingFollowup(followupForm);
			return "MarketingHomeRedirect";
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			result.rejectValue("followupDate", "designationAddException");
			return getdata(followupForm, result, model);
		}
		
	}

}
