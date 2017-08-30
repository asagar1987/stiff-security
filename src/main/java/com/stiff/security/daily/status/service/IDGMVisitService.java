package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDGMVisitDAO;
import com.stiff.security.daily.status.model.DGMVisit;

public interface IDGMVisitService
{

	List<DGMVisit> getVisitsForOfficer(long id);

	List<DGMVisit> getAllVisits();

	void addMarketingVisit(DGMVisit m);

	IDGMVisitDAO getDgmVisitDAO();

	void setDgmVisitDAO(IDGMVisitDAO dgmVisitDAO);

}