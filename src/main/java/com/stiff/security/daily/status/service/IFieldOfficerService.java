package com.stiff.security.daily.status.service;

import java.util.List;


import com.stiff.security.daily.status.dao.IFieldOfficerDAO;
import com.stiff.security.daily.status.model.FieldOfficer;

public interface IFieldOfficerService
{

	FieldOfficer checkLogin(String userName, String userPassword);

	IFieldOfficerDAO getFieldOfficerDAO();

	void setFieldOfficerDAO(IFieldOfficerDAO fieldOfficerDAO);

	List<FieldOfficer> getAllOfficers();

	FieldOfficer getFieldOfficerById(long siteOfficerId);

	long addFieldOfficer(FieldOfficer fo);

	

	void updateFieldOfficer(FieldOfficer fo);

	void removeFieldOfficer(FieldOfficer f);

}