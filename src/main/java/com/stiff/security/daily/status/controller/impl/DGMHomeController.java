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

import com.stiff.security.daily.status.controller.IDGMHomeController;
import com.stiff.security.daily.status.form.LoginForm;
import com.stiff.security.daily.status.model.DGMNightConduct;
import com.stiff.security.daily.status.model.DGMSecurityAuditConduct;
import com.stiff.security.daily.status.model.DGMTrainingConduct;
import com.stiff.security.daily.status.model.DGMVisit;
import com.stiff.security.daily.status.model.DailyStatusReport;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.service.IDGMNightConductService;
import com.stiff.security.daily.status.service.IDGMSecurityAuditConductService;
import com.stiff.security.daily.status.service.IDGMTrainingConductService;
import com.stiff.security.daily.status.service.IDGMVisitService;
import com.stiff.security.daily.status.service.IDailyStatusReportService;

@Component
@Controller
@RequestMapping("dgmHome")
public class DGMHomeController implements IDGMHomeController 
{
	
	@Autowired
	private IDGMNightConductService dgmNightConductService;
	@Autowired
	private IDGMVisitService dgmVisitService;
	@Autowired
	private IDGMSecurityAuditConductService dgmSecurityAuditConductService;
	@Autowired
	private IDGMTrainingConductService dgmTrainingConductService;
	@Autowired
	private IDailyStatusReportService dailyStatusReportService;
	
	private List<DGMVisit> myVisitList;
	private List<DGMTrainingConduct> myTrainingConductList;
	private List<DGMNightConduct> myNightConductList;
	private List<DGMSecurityAuditConduct> mySecurityAuditConductList;
	private List<DailyStatusReport> myDailyStatusReportList;
	
	

	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMHomeController#getdata(com.stiff.security.daily.status.form.LoginForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid LoginForm loginForm, BindingResult result, Map model, HttpSession session)
	{
		
		System.out.println("Get Data from DGM controller");
		if(session.getAttribute("loggedInUser")==null)
			return "loginForm";
		long id = ((FieldOfficer)session.getAttribute("loggedInUser")).getFieldOfficerId();
		myNightConductList = dgmNightConductService.getVisitsForOfficer(id);
		myVisitList = dgmVisitService.getVisitsForOfficer(id);
		myTrainingConductList = dgmTrainingConductService.getVisitsForOfficer(id);
		mySecurityAuditConductList = dgmSecurityAuditConductService.getVisitsForOfficer(id);
		myDailyStatusReportList = dailyStatusReportService.getReportsForOfficer(id);
	
		
		model.put("myNightConductList", myNightConductList);
		model.put("myVisitList",myVisitList);
		model.put("myTrainingConductList", myTrainingConductList);
		model.put("mySecurityAuditConductList", mySecurityAuditConductList);
		model.put("myDailyStatusReportList", myDailyStatusReportList);
		System.out.println("Exiting DGM Controller");
		return "dgmHome";
	}
}
