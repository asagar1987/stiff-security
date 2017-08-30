package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDGMTrainingConductDAO;
import com.stiff.security.daily.status.model.DGMTrainingConduct;

public interface IDGMTrainingConductService
{

	IDGMTrainingConductDAO getDgmTrainingConductDAO();

	void setDgmTrainingConductDAO(IDGMTrainingConductDAO dgmTrainingConductDAO);

	List<DGMTrainingConduct> getVisitsForOfficer(long id);

	List<DGMTrainingConduct> getAllVisits();

	void addMarketingVisit(DGMTrainingConduct m);

}