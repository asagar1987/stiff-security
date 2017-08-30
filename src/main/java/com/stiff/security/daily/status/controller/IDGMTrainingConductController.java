package com.stiff.security.daily.status.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.model.DGMTrainingConduct;

public interface IDGMTrainingConductController
{

	String getdata(DGMTrainingConduct dgmTrainingConductForm, BindingResult result, Map model);

	String processForm(DGMTrainingConduct dgmTrainingConductForm, BindingResult result, Map model, HttpSession session);

}