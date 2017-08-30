package com.stiff.security.daily.status.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.form.LoginForm;
import com.stiff.security.daily.status.model.MarketingFollowup;
import com.stiff.security.daily.status.model.MarketingMeeting;
import com.stiff.security.daily.status.model.MarketingVisit;
import com.stiff.security.daily.status.service.IMarketingFollowupService;
import com.stiff.security.daily.status.service.IMarketingMeetingService;
import com.stiff.security.daily.status.service.IMarketingVisitService;

public interface IAdminMarketingReportController
{

	IMarketingMeetingService getMarketingMeetingService();

	void setMarketingMeetingService(IMarketingMeetingService marketingMeetingService);

	IMarketingVisitService getMarketingVisitService();

	void setMarketingVisitService(IMarketingVisitService marketingVisitService);

	IMarketingFollowupService getMarketingFollowupService();

	void setMarketingFollowupService(IMarketingFollowupService marketingFollowupService);

	List<MarketingMeeting> getMyMeetingList();

	void setMyMeetingList(List<MarketingMeeting> myMeetingList);

	List<MarketingVisit> getMyVisitList();

	void setMyVisitList(List<MarketingVisit> myVisitList);

	List<MarketingFollowup> getMyFollowupList();

	void setMyFollowupList(List<MarketingFollowup> myFollowupList);

	String getdata(LoginForm loginForm, BindingResult result, Map model, HttpSession session);

}