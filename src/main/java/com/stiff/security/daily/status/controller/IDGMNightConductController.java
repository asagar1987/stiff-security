package com.stiff.security.daily.status.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.model.DGMNightConduct;

public interface IDGMNightConductController
{

	String getdata(DGMNightConduct dgmNightConductForm, BindingResult result, Map model);

	String processForm(DGMNightConduct dgmNightConductForm, BindingResult result, Map model, HttpSession session);

}