package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.MarketingVisit;

public interface IMarketingVisitDAO
{

	void setSessionFactory(SessionFactory sessionFactory);

	void addMarketingVisit(MarketingVisit mm) throws Exception;

	List<MarketingVisit> getMyVisits(long id);


	List<MarketingVisit> getAllVisits();

}