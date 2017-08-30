package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.HRForm;

public interface IHRFormDAO
{

	void setSessionFactory(SessionFactory sessionFactory);

	void addHRForm(HRForm mm) throws Exception;

	List<HRForm> getMyVisits(long id);

	List<HRForm> getAllVisits();

	HRForm getReportById(int reportId);

}