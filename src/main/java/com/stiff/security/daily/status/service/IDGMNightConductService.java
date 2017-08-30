package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDGMNightConductDAO;
import com.stiff.security.daily.status.model.DGMNightConduct;

public interface IDGMNightConductService
{

	IDGMNightConductDAO getDgmNightConductDAO();

	void setDgmNightConductDAO(IDGMNightConductDAO dgmNightConductDAO);

	List<DGMNightConduct> getVisitsForOfficer(long id);

	List<DGMNightConduct> getAllVisits();

	void addDGMNightConduct(DGMNightConduct m);

}