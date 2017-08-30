package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IMarketingFollowupDAO;
import com.stiff.security.daily.status.model.MarketingFollowup;

public interface IMarketingFollowupService
{

	IMarketingFollowupDAO getMarketingFollowupDAO();

	void setMarketingFollowupDAO(IMarketingFollowupDAO marketingFollowupDAO);

	List<MarketingFollowup> getFollowupsForOfficer(long id);

	List<MarketingFollowup> getAllFollowups();

	void addMarketingFollowup(MarketingFollowup m);

}