package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.DGMNightConduct;

public interface IDGMNightConductDAO
{

	void setSessionFactory(SessionFactory sessionFactory);

	void addNightConductDAO(DGMNightConduct mm) throws Exception;

	List<DGMNightConduct> getMyVisits(long id);

	List<DGMNightConduct> getAllVisits();

}