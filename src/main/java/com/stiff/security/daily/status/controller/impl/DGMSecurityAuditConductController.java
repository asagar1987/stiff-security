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

import com.stiff.security.daily.status.controller.IDGMSecurityAuditConductController;
import com.stiff.security.daily.status.model.DGMSecurityAuditConduct;
import com.stiff.security.daily.status.model.DGMTrainingConduct;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.service.IDGMSecurityAuditConductService;

@Controller
@Component
@RequestMapping("dgmSecurityAuditConductForm")

public class DGMSecurityAuditConductController implements IDGMSecurityAuditConductController
{
	
	@Autowired
	private IDGMSecurityAuditConductService dgmSecurityAuditConductService;
	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMSecurityAuditConductController#getdata(com.stiff.security.daily.status.model.DGMSecurityAuditConduct, org.springframework.validation.BindingResult, java.util.Map)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid DGMSecurityAuditConduct dgmSecurityAuditConductForm, BindingResult result, Map model)
	{
		dgmSecurityAuditConductForm = new DGMSecurityAuditConduct();
		model.put("dgmSecurityAuditConductForm", dgmSecurityAuditConductForm);
		return "dgmSecurityAuditConductForm";

	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMSecurityAuditConductController#processForm(com.stiff.security.daily.status.model.DGMSecurityAuditConduct, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid DGMSecurityAuditConduct dgmSecurityAuditConductForm, BindingResult result, @SuppressWarnings("rawtypes") Map model, HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		System.out.println("Processing Designation Form");
		
		try
		{
			dgmSecurityAuditConductForm.setFieldOfficer((FieldOfficer)session.getAttribute("loggedInUser"));
			//visitForm.setvisitDate(new Date(visitForm.getTempDate()));
			System.out.println(dgmSecurityAuditConductForm.toString());
			
			dgmSecurityAuditConductService.addMarketingVisit(dgmSecurityAuditConductForm);
			return "DGMHomeRedirect";
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			result.rejectValue("visitDate", "designationAddException");
			return getdata(dgmSecurityAuditConductForm, result, model);
		}
		
	}

}
