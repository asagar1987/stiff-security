package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.MarketingFollowup;

public interface IMarketingFollowupDAO
{

	void setSessionFactory(SessionFactory sessionFactory);

	void addMarketingFollowup(MarketingFollowup mm) throws Exception;

	List<MarketingFollowup> getMyFollowups(long id);

	List<MarketingFollowup> getAllFollowups();

}