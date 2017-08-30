package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IMarketingMeetingDAO;
import com.stiff.security.daily.status.model.MarketingMeeting;

public interface IMarketingMeetingService
{

	IMarketingMeetingDAO getMarketingMeetingDAO();

	void setMarketingMeetingDAO(IMarketingMeetingDAO marketingMeetingDAO);

	List<MarketingMeeting> getMeetingsForOfficer(long id);

	List<MarketingMeeting> getAllMeetings();

	void addMarketingMeeting(MarketingMeeting m);

}