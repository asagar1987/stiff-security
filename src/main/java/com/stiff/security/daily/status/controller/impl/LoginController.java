package com.stiff.security.daily.status.controller.impl;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stiff.security.daily.status.controller.ILoginController;
import com.stiff.security.daily.status.form.LoginForm;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.service.IFieldOfficerService;

/**
 * 
 * @author asaga3
 *
 */
@Controller
@Component
@RequestMapping("loginForm")
@Scope("session")
public class LoginController implements ILoginController
{

	@Autowired
	public IFieldOfficerService fieldOfficerService;
	
	private FieldOfficer userExists;

	public IFieldOfficerService getFieldOfficerService()
	{
		return fieldOfficerService;
	}

	public void setFieldOfficerService(IFieldOfficerService fieldOfficerService)
	{
		this.fieldOfficerService = fieldOfficerService;
	}

	public FieldOfficer getUserExists()
	{
		return userExists;
	}

	public void setUserExists(FieldOfficer userExists)
	{
		this.userExists = userExists;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.ILoginController#showForm(java.util.Map)
	 */
	@Override
	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model)
	{
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginForm";
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.ILoginController#processForm(com.stiff.security.daily.status.form.LoginForm, org.springframework.validation.BindingResult, java.util.Map)
	 */
	@Override
	@SuppressWarnings(
	{ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result, Map model, final RedirectAttributes redirectAttributes, HttpSession session)
	{
		System.out.println("Processing Login Form");
		if (result.hasErrors())
		{
			return "loginForm";
		}

		/*
		 * String userName = "UserName"; String password = "password"; loginForm
		 * = (LoginForm) model.get("loginForm"); if
		 * (!loginForm.getUserName().equals(userName) ||
		 * !loginForm.getPassword().equals(password)) { return "loginform"; }
		 */
		
		String username=loginForm.getUsername();
		String password=loginForm.getPassword();
		
		userExists= fieldOfficerService.checkLogin(username, password);
		if (userExists != null)
		{
			model.put("loginForm", loginForm);
			model.put("loginDetails", userExists);
			session.setAttribute("loggedInUser", userExists);
			if(username.equals("admin") || userExists.getDesignation().getDesignationName().contains("Administrator"))
				return "AdminHomeRedirect";
			else if(userExists.getDesignation().getDesignationName().contains("Field Officer"))
			{
				
				/*DailyStatusReportForm dailyStatusReportForm = new DailyStatusReportForm();
				model.put("dailyStatusReportForm",dailyStatusReportForm);
				return "dailyStatusReportForm";*/
				redirectAttributes.addFlashAttribute("loginDetails", userExists);

			    return "redirect:dailyStatusReportForm";
			}
			else if(userExists.getDesignation().getDesignationName().equalsIgnoreCase("Marketing Officer") || userExists.getDesignation().getDesignationName().equalsIgnoreCase("Telecaller") || userExists.getDesignation().getDesignationName().equalsIgnoreCase("Telecallers") || userExists.getDesignation().getDesignationName().equalsIgnoreCase("Marketing/Telecallers"))
			{
				
				/*DailyStatusReportForm dailyStatusReportForm = new DailyStatusReportForm();
				model.put("dailyStatusReportForm",dailyStatusReportForm);
				return "dailyStatusReportForm";*/
				redirectAttributes.addFlashAttribute("loginDetails", userExists);

			    return "MarketingHomeRedirect";
			}
			else if(userExists.getDesignation().getDesignationName().equalsIgnoreCase("Deputy General Manager") || userExists.getDesignation().getDesignationName().equalsIgnoreCase("DGM") || userExists.getDesignation().getDesignationName().equalsIgnoreCase("GM") || userExists.getDesignation().getDesignationName().equalsIgnoreCase("General Manager") )
			{
				
				/*DailyStatusReportForm dailyStatusReportForm = new DailyStatusReportForm();
				model.put("dailyStatusReportForm",dailyStatusReportForm);
				return "dailyStatusReportForm";*/
				redirectAttributes.addFlashAttribute("loginDetails", userExists);

			    return "DGMHomeRedirect";
			}
			else if(userExists.getDesignation().getDesignationName().equalsIgnoreCase("HR Manager") || userExists.getDesignation().getDesignationName().contains("HR") )
			{
				
				/*DailyStatusReportForm dailyStatusReportForm = new DailyStatusReportForm();
				model.put("dailyStatusReportForm",dailyStatusReportForm);
				return "dailyStatusReportForm";*/
				redirectAttributes.addFlashAttribute("loginDetails", userExists);

			    return "HRRedirect";
			}


			
			else
				return "loginForm";
		}
		else
		{
			result.rejectValue("username", "invaliduser");
			return "loginForm";
		}

	}

	
}
