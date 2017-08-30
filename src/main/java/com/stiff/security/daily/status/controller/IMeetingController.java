package com.stiff.security.daily.status.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.model.MarketingMeeting;

public interface IMeetingController
{

	String getdata(MarketingMeeting meetingForm, BindingResult result, Map model);

	String processForm(MarketingMeeting meetingForm, BindingResult result, Map model, HttpSession session);

}