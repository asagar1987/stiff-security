package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IMarketingVisitDAO;
import com.stiff.security.daily.status.model.MarketingVisit;

public interface IMarketingVisitService
{

	IMarketingVisitDAO getMarketingVisitDAO();

	void setMarketingVisitDAO(IMarketingVisitDAO marketingVisitDAO);

	List<MarketingVisit> getVisitsForOfficer(long id);

	List<MarketingVisit> getAllVisits();

	void addMarketingVisit(MarketingVisit m);

}