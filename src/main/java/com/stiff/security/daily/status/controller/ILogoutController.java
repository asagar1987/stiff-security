package com.stiff.security.daily.status.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stiff.security.daily.status.form.LoginForm;

public interface ILogoutController
{

	String processForm(LoginForm loginForm, BindingResult result, Map model, RedirectAttributes redirectAttributes,
			HttpSession session);

}