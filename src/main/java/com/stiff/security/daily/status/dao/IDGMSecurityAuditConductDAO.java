package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.DGMSecurityAuditConduct;

public interface IDGMSecurityAuditConductDAO
{

	void setSessionFactory(SessionFactory sessionFactory);

	void addDGMSecurityAuditConduct(DGMSecurityAuditConduct mm) throws Exception;

	List<DGMSecurityAuditConduct> getMyVisits(long id);

	List<DGMSecurityAuditConduct> getAllVisits();

}