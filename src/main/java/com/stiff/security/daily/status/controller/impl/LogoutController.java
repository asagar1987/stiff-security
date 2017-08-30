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

import com.stiff.security.daily.status.controller.ILogoutController;
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
@RequestMapping("logoutForm")
@Scope("session")
public class LogoutController implements ILogoutController
{

	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.ILogoutController#processForm(com.stiff.security.daily.status.form.LoginForm, org.springframework.validation.BindingResult, java.util.Map, org.springframework.web.servlet.mvc.support.RedirectAttributes, javax.servlet.http.HttpSession)
	 */
	@Override
	@SuppressWarnings(
	{ "rawtypes"})
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm,BindingResult result, Map model, final RedirectAttributes redirectAttributes, HttpSession session)
	{
		System.out.println("Processing Logout Form");
		session.removeAttribute("loggedInUser");
		return "loginForm";
	}

	
}
