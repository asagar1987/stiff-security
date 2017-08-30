package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.FieldOfficer;

public interface IFieldOfficerDAO
{

	void setSessionFactory(SessionFactory sessionFactory);

	FieldOfficer checkLogin(String userName, String userPassword);

	List<FieldOfficer> getAllOfficers();

	FieldOfficer getFieldOfficerById(long siteOfficerId);

	long addFieldOfficer(FieldOfficer fo);

	void updateFieldOfficer(FieldOfficer fo);

	void removeOfficer(FieldOfficer f);

}