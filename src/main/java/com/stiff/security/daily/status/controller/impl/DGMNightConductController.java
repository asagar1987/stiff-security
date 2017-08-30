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

import com.stiff.security.daily.status.controller.IDGMNightConductController;
import com.stiff.security.daily.status.model.DGMNightConduct;
import com.stiff.security.daily.status.model.DGMVisit;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.service.IDGMNightConductService;

@Controller
@Component
@RequestMapping("dgmNightConductForm")

public class DGMNightConductController implements IDGMNightConductController
{
	
	@Autowired
	private IDGMNightConductService dgmNightConductService;
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMNightConductController#getdata(com.stiff.security.daily.status.model.DGMNightConduct, org.springframework.validation.BindingResult, java.util.Map)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid DGMNightConduct dgmNightConductForm, BindingResult result, Map model)
	{
		dgmNightConductForm = new DGMNightConduct();
		model.put("dgmNightConductForm", dgmNightConductForm);
		return "dgmNightConductForm";

	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMNightConductController#processForm(com.stiff.security.daily.status.model.DGMNightConduct, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid DGMNightConduct dgmNightConductForm, BindingResult result, @SuppressWarnings("rawtypes") Map model, HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		System.out.println("Processing Designation Form");
		
		try
		{
			dgmNightConductForm.setFieldOfficer((FieldOfficer)session.getAttribute("loggedInUser"));
			//visitForm.setvisitDate(new Date(visitForm.getTempDate()));
			System.out.println(dgmNightConductForm.toString());
			
			dgmNightConductService.addDGMNightConduct(dgmNightConductForm);
			return "DGMHomeRedirect";
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			result.rejectValue("visitDate", "designationAddException");
			return getdata(dgmNightConductForm, result, model);
		}
		
	}

}
