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

import com.stiff.security.daily.status.controller.IMeetingController;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.model.MarketingMeeting;
import com.stiff.security.daily.status.service.IMarketingMeetingService;

@Controller
@Component
@RequestMapping("meetingForm")

public class MeetingController implements IMeetingController
{
	
	@Autowired
	private IMarketingMeetingService marketingMeetingService;
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IMeetingController#getdata(com.stiff.security.daily.status.model.MarketingMeeting, org.springframework.validation.BindingResult, java.util.Map)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid MarketingMeeting meetingForm, BindingResult result, Map model)
	{
		meetingForm = new MarketingMeeting();
		model.put("meetingForm", meetingForm);
		return "meetingForm";

	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IMeetingController#processForm(com.stiff.security.daily.status.model.MarketingMeeting, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid MarketingMeeting meetingForm, BindingResult result, @SuppressWarnings("rawtypes") Map model, HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		System.out.println("Processing Designation Form");
		
		try
		{
			meetingForm.setFieldOfficer((FieldOfficer)session.getAttribute("loggedInUser"));
			//meetingForm.setMeetingDate(new Date(meetingForm.getTempDate()));
			System.out.println(meetingForm.toString());
			
			marketingMeetingService.addMarketingMeeting(meetingForm);
			return "MarketingHomeRedirect";
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			result.rejectValue("meetingDate", "designationAddException");
			return getdata(meetingForm, result, model);
		}
		
	}

}
