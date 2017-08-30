package com.stiff.security.daily.status.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.model.MarketingVisit;

public interface IVisitController
{

	String getdata(MarketingVisit visitForm, BindingResult result, Map model);

	String processForm(MarketingVisit visitForm, BindingResult result, Map model, HttpSession session);

}