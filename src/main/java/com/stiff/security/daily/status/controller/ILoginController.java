package com.stiff.security.daily.status.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stiff.security.daily.status.form.LoginForm;

@Component
public interface ILoginController
{

	String showForm(Map model);

	String processForm(LoginForm loginForm, BindingResult result, Map model, RedirectAttributes redirectAttributes,
			HttpSession session);

}