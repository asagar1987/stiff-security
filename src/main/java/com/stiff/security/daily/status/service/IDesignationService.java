package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDesignationDAO;
import com.stiff.security.daily.status.model.Designation;

public interface IDesignationService
{

	IDesignationDAO getDesignationDAO();

	void setDesignationDAO(IDesignationDAO designationDAO);

	List<Designation> getAllDesignations();

	boolean addDesignation(String designationName);

	Designation getDesignationById(long designationId);

}