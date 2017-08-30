package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDesignationDAO;
import com.stiff.security.daily.status.model.Designation;
import com.stiff.security.daily.status.service.IDesignationService;

@Service("designationService")
@Component
public class DesignationService implements IDesignationService
{

	@Autowired
	private IDesignationDAO designationDAO;
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDesignationService#getDesignationDAO()
	 */
	@Override
	public IDesignationDAO getDesignationDAO()
	{
		return designationDAO;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDesignationService#setDesignationDAO(com.stiff.security.daily.status.dao.DesignationDAO)
	 */
	@Override
	public void setDesignationDAO(IDesignationDAO designationDAO)
	{
		this.designationDAO = designationDAO;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDesignationService#getAllDesignations()
	 */
	@Override
	@Transactional
	public List<Designation> getAllDesignations()
	{
		return designationDAO.listAllDesignations();
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDesignationService#addDesignation(java.lang.String)
	 */
	@Override
	@Transactional
	public boolean addDesignation(String designationName)
	{
		try
		{
			designationDAO.addDesignation(designationName);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDesignationService#getDesignationById(long)
	 */
	@Override
	@Transactional
	public Designation getDesignationById(long designationId)
	{
		return designationDAO.getDesignationById(designationId);
	}
}
