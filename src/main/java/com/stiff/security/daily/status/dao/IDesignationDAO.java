package com.stiff.security.daily.status.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.stiff.security.daily.status.model.Designation;

public interface IDesignationDAO
{

	void setSessionFactory(SessionFactory sessionFactory);

	List<Designation> listAllDesignations();

	void addDesignation(String designationName) throws Exception;

	Designation getDesignationById(long designationId);

}