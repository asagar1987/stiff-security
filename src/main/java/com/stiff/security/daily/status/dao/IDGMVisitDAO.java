package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.DGMVisit;

public interface IDGMVisitDAO
{

	void setSessionFactory(SessionFactory sessionFactory);

	void addDGMVisit(DGMVisit mm) throws Exception;

	List<DGMVisit> getMyVisits(long id);

	List<DGMVisit> getAllVisits();

}