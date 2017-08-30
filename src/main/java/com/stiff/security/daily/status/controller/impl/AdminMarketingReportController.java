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

import com.stiff.security.daily.status.controller.IAdminMarketingReportController;
import com.stiff.security.daily.status.form.LoginForm;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.model.MarketingFollowup;
import com.stiff.security.daily.status.model.MarketingMeeting;
import com.stiff.security.daily.status.model.MarketingVisit;
import com.stiff.security.daily.status.service.IMarketingFollowupService;
import com.stiff.security.daily.status.service.IMarketingMeetingService;
import com.stiff.security.daily.status.service.IMarketingVisitService;

@Component
@Controller
@RequestMapping("marketingReportsForm")
public class AdminMarketingReportController implements IAdminMarketingReportController 
{
	
	@Autowired
	private IMarketingMeetingService marketingMeetingService;
	@Autowired
	private IMarketingVisitService marketingVisitService;
	@Autowired
	private IMarketingFollowupService marketingFollowupService;
	
	
	private List<MarketingMeeting> myMeetingList;
	private List<MarketingVisit> myVisitList;
	private List<MarketingFollowup> myFollowupList;
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#getMarketingMeetingService()
	 */
	@Override
	public IMarketingMeetingService getMarketingMeetingService()
	{
		return marketingMeetingService;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#setMarketingMeetingService(com.stiff.security.daily.status.service.IMarketingMeetingService)
	 */
	@Override
	public void setMarketingMeetingService(IMarketingMeetingService marketingMeetingService)
	{
		this.marketingMeetingService = marketingMeetingService;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#getMarketingVisitService()
	 */
	@Override
	public IMarketingVisitService getMarketingVisitService()
	{
		return marketingVisitService;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#setMarketingVisitService(com.stiff.security.daily.status.service.IMarketingVisitService)
	 */
	@Override
	public void setMarketingVisitService(IMarketingVisitService marketingVisitService)
	{
		this.marketingVisitService = marketingVisitService;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#getMarketingFollowupService()
	 */
	@Override
	public IMarketingFollowupService getMarketingFollowupService()
	{
		return marketingFollowupService;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#setMarketingFollowupService(com.stiff.security.daily.status.service.IMarketingFollowupService)
	 */
	@Override
	public void setMarketingFollowupService(IMarketingFollowupService marketingFollowupService)
	{
		this.marketingFollowupService = marketingFollowupService;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#getMyMeetingList()
	 */
	@Override
	public List<MarketingMeeting> getMyMeetingList()
	{
		return myMeetingList;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#setMyMeetingList(java.util.List)
	 */
	@Override
	public void setMyMeetingList(List<MarketingMeeting> myMeetingList)
	{
		this.myMeetingList = myMeetingList;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#getMyVisitList()
	 */
	@Override
	public List<MarketingVisit> getMyVisitList()
	{
		return myVisitList;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#setMyVisitList(java.util.List)
	 */
	@Override
	public void setMyVisitList(List<MarketingVisit> myVisitList)
	{
		this.myVisitList = myVisitList;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#getMyFollowupList()
	 */
	@Override
	public List<MarketingFollowup> getMyFollowupList()
	{
		return myFollowupList;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#setMyFollowupList(java.util.List)
	 */
	@Override
	public void setMyFollowupList(List<MarketingFollowup> myFollowupList)
	{
		this.myFollowupList = myFollowupList;
	}

	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IAdminMarketingReportController#getdata(com.stiff.security.daily.status.form.LoginForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
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
		myMeetingList = marketingMeetingService.getAllMeetings();
		myVisitList = marketingVisitService.getAllVisits();
		myFollowupList = marketingFollowupService.getAllFollowups();
		
		model.put("myMeetingList", myMeetingList);
		model.put("myVisitList",myVisitList);
		model.put("myFollowupList", myFollowupList);
		System.out.println("Exiting Marketing Controller");
		return "marketingReportsForm";
	}
}
