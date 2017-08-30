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

import com.stiff.security.daily.status.controller.IDGMTrainingConductController;
import com.stiff.security.daily.status.model.DGMNightConduct;
import com.stiff.security.daily.status.model.DGMTrainingConduct;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.service.IDGMTrainingConductService;

@Controller
@Component
@RequestMapping("dgmTrainingConductForm")

public class DGMTrainingConductController implements IDGMTrainingConductController
{
	
	@Autowired
	private IDGMTrainingConductService dgmTrainingConductService;
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMTrainingConductController#getdata(com.stiff.security.daily.status.model.DGMTrainingConduct, org.springframework.validation.BindingResult, java.util.Map)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid DGMTrainingConduct dgmTrainingConductForm, BindingResult result, Map model)
	{
		dgmTrainingConductForm = new DGMTrainingConduct();
		model.put("dgmTrainingConductForm", dgmTrainingConductForm);
		return "dgmTrainingConductForm";

	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMTrainingConductController#processForm(com.stiff.security.daily.status.model.DGMTrainingConduct, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid DGMTrainingConduct dgmTrainingConductForm, BindingResult result, @SuppressWarnings("rawtypes") Map model, HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		System.out.println("Processing Designation Form");
		
		try
		{
			dgmTrainingConductForm.setFieldOfficer((FieldOfficer)session.getAttribute("loggedInUser"));
			//visitForm.setvisitDate(new Date(visitForm.getTempDate()));
			System.out.println(dgmTrainingConductForm.toString());
			
			dgmTrainingConductService.addMarketingVisit(dgmTrainingConductForm);
			return "DGMHomeRedirect";
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			result.rejectValue("visitDate", "designationAddException");
			return getdata(dgmTrainingConductForm, result, model);
		}
		
	}

}
