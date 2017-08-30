package com.stiff.security.daily.status.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.model.MarketingFollowup;

public interface IFollowupController
{

	String getdata(MarketingFollowup followupForm, BindingResult result, Map model);

	String processForm(MarketingFollowup followupForm, BindingResult result, Map model, HttpSession session);

}