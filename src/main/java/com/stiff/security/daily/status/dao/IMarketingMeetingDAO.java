package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.MarketingMeeting;

public interface IMarketingMeetingDAO
{

	void setSessionFactory(SessionFactory sessionFactory);

	

	List<MarketingMeeting> getMyMeetings(long id);

	List<MarketingMeeting> getAllMeetings();

	void addMarketingMeeting(MarketingMeeting mm) throws Exception;

}