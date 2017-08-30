package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.DGMTrainingConduct;

public interface IDGMTrainingConductDAO
{

	void setSessionFactory(SessionFactory sessionFactory);

	void addTrainingConduct(DGMTrainingConduct mm) throws Exception;

	List<DGMTrainingConduct> getMyVisits(long id);

	List<DGMTrainingConduct> getAllVisits();

}