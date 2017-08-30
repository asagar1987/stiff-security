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

import com.stiff.security.daily.status.controller.IDesignationController;
import com.stiff.security.daily.status.form.DesignationForm;
import com.stiff.security.daily.status.model.Designation;
import com.stiff.security.daily.status.service.IDesignationService;

@Controller
@Component
@RequestMapping("designationForm")

public class DesignationController implements IDesignationController
{
	
	@Autowired
	private IDesignationService designationService;
	
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDesignationController#getDesignationService()
	 */
	@Override
	public IDesignationService getDesignationService()
	{
		return designationService;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDesignationController#setDesignationService(com.stiff.security.daily.status.service.IDesignationService)
	 */
	@Override
	public void setDesignationService(IDesignationService designationService)
	{
		this.designationService = designationService;
	}

	

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDesignationController#getdata(com.stiff.security.daily.status.form.DesignationForm, org.springframework.validation.BindingResult, java.util.Map)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid DesignationForm designationForm, BindingResult result, Map model)
	{
		List<Designation> list = designationService.getAllDesignations();
		designationForm = new DesignationForm();
		model.put("desingationForm", designationForm);
		model.put("designationList", list);
		return "designationForm";

	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDesignationController#processForm(com.stiff.security.daily.status.form.DesignationForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid DesignationForm designationForm, BindingResult result, @SuppressWarnings("rawtypes") Map model, HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		System.out.println("Processing Designation Form");
		if (result.hasErrors())
		{
			return getdata(designationForm, result, model);
		}
		String designation = designationForm.getDesignationName();
		if(designation.equals(""))
		{
			result.rejectValue("designationName", "designationBlankException");
			return getdata(designationForm, result, model);
		}
		else if(designationService.addDesignation(designation))
		{
			designationForm.setDesignationName("");
			return getdata(designationForm, result, model);
		}
		else
		{
			result.rejectValue("designationName", "designationAddException");
			return getdata(designationForm, result, model);
		}
		
	}

}
