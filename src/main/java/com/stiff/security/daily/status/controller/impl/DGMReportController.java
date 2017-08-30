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

import com.stiff.security.daily.status.controller.IDGMReportController;
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
@RequestMapping("dgmReportsForm")
public class DGMReportController implements IDGMReportController 
{
	
	@Autowired
	private IDGMVisitService dgmVisitService;
	@Autowired
	private IDGMTrainingConductService dgmTrainingConductService;
	@Autowired
	private IDGMNightConductService dgmNightConductService;
	@Autowired
	private IDGMSecurityAuditConductService dgmSecurityAuditConductService;
	
	
	private List<DGMTrainingConduct> myTrainingConductList;
	private List<DGMVisit> myVisitList;
	private List<DGMSecurityAuditConduct> mySecurityAuditConductList;
	private List<DGMNightConduct> myNightConductList;
	

	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#getDgmVisitService()
	 */
	@Override
	public IDGMVisitService getDgmVisitService()
	{
		return dgmVisitService;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#setDgmVisitService(com.stiff.security.daily.status.service.IDGMVisitService)
	 */
	@Override
	public void setDgmVisitService(IDGMVisitService dgmVisitService)
	{
		this.dgmVisitService = dgmVisitService;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#getDgmTrainingConductService()
	 */
	@Override
	public IDGMTrainingConductService getDgmTrainingConductService()
	{
		return dgmTrainingConductService;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#setDgmTrainingConductService(com.stiff.security.daily.status.service.IDGMTrainingConductService)
	 */
	@Override
	public void setDgmTrainingConductService(IDGMTrainingConductService dgmTrainingConductService)
	{
		this.dgmTrainingConductService = dgmTrainingConductService;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#getDgmNightConductService()
	 */
	@Override
	public IDGMNightConductService getDgmNightConductService()
	{
		return dgmNightConductService;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#setDgmNightConductService(com.stiff.security.daily.status.service.IDGMNightConductService)
	 */
	@Override
	public void setDgmNightConductService(IDGMNightConductService dgmNightConductService)
	{
		this.dgmNightConductService = dgmNightConductService;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#getDgmSecurityAuditConductService()
	 */
	@Override
	public IDGMSecurityAuditConductService getDgmSecurityAuditConductService()
	{
		return dgmSecurityAuditConductService;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#setDgmSecurityAuditConductService(com.stiff.security.daily.status.service.IDGMSecurityAuditConductService)
	 */
	@Override
	public void setDgmSecurityAuditConductService(IDGMSecurityAuditConductService dgmSecurityAuditConductService)
	{
		this.dgmSecurityAuditConductService = dgmSecurityAuditConductService;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#getMyTrainingConductList()
	 */
	@Override
	public List<DGMTrainingConduct> getMyTrainingConductList()
	{
		return myTrainingConductList;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#setMyTrainingConductList(java.util.List)
	 */
	@Override
	public void setMyTrainingConductList(List<DGMTrainingConduct> myTrainingConductList)
	{
		this.myTrainingConductList = myTrainingConductList;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#getMyVisitList()
	 */
	@Override
	public List<DGMVisit> getMyVisitList()
	{
		return myVisitList;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#setMyVisitList(java.util.List)
	 */
	@Override
	public void setMyVisitList(List<DGMVisit> myVisitList)
	{
		this.myVisitList = myVisitList;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#getMySecurityAuditConductList()
	 */
	@Override
	public List<DGMSecurityAuditConduct> getMySecurityAuditConductList()
	{
		return mySecurityAuditConductList;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#setMySecurityAuditConductList(java.util.List)
	 */
	@Override
	public void setMySecurityAuditConductList(List<DGMSecurityAuditConduct> mySecurityAuditConductList)
	{
		this.mySecurityAuditConductList = mySecurityAuditConductList;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#getMyNightConductList()
	 */
	@Override
	public List<DGMNightConduct> getMyNightConductList()
	{
		return myNightConductList;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#setMyNightConductList(java.util.List)
	 */
	@Override
	public void setMyNightConductList(List<DGMNightConduct> myNightConductList)
	{
		this.myNightConductList = myNightConductList;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDGMReportController#getdata(com.stiff.security.daily.status.form.LoginForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid LoginForm loginForm, BindingResult result, Map model, HttpSession session)
	{
		
		System.out.println("Get Data from marketing controller");
		if(session.getAttribute("loggedInUser")==null)
			return "loginForm";
		long id = ((FieldOfficer)session.getAttribute("loggedInUser")).getFieldOfficerId();
		myTrainingConductList = dgmTrainingConductService.getAllVisits();
		myVisitList = dgmVisitService.getAllVisits();
		mySecurityAuditConductList = dgmSecurityAuditConductService.getAllVisits();
		myNightConductList = dgmNightConductService.getAllVisits();
		
		model.put("myTrainingConductList", myTrainingConductList);
		model.put("myVisitList",myVisitList);
		model.put("mySecurityAuditConductList", mySecurityAuditConductList);
		model.put("myNightConductList", myNightConductList);
		
		System.out.println("Exiting Marketing Controller");
		return "dgmReportsForm";
	}
}
