package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDGMSecurityAuditConductDAO;
import com.stiff.security.daily.status.model.DGMSecurityAuditConduct;

public interface IDGMSecurityAuditConductService
{

	IDGMSecurityAuditConductDAO getDgmSecurityAuditConductDAO();

	void setDgmSecurityAuditConductDAO(IDGMSecurityAuditConductDAO dgmSecurityAuditConductDAO);

	List<DGMSecurityAuditConduct> getVisitsForOfficer(long id);

	List<DGMSecurityAuditConduct> getAllVisits();

	void addMarketingVisit(DGMSecurityAuditConduct m);

}