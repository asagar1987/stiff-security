package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IFieldOfficerDAO;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.service.IFieldOfficerService;



@Service("fieldOfficerService")
@Component



public class FieldOfficerService implements IFieldOfficerService
{
	@Autowired
	private IFieldOfficerDAO fieldOfficerDAO;

	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IEmployeeService#checkLogin(java.lang.String, java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IFieldOfficerService#checkLogin(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
	public FieldOfficer checkLogin(String userName, String userPassword)
	{
		System.out.println("In Service class...Check Login");
		return fieldOfficerDAO.checkLogin(userName, userPassword);
	}


	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IFieldOfficerService#getFieldOfficerDAO()
	 */
	@Override
	
	public IFieldOfficerDAO getFieldOfficerDAO()
	{
		return fieldOfficerDAO;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IFieldOfficerService#setFieldOfficerDAO(com.stiff.security.daily.status.dao.FieldOfficerDAO)
	 */
	@Override
	public void setFieldOfficerDAO(IFieldOfficerDAO fieldOfficerDAO)
	{
		this.fieldOfficerDAO = fieldOfficerDAO;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IFieldOfficerService#getAllOfficers()
	 */
	@Override
	@Transactional
	public List<FieldOfficer> getAllOfficers()
	{
		return fieldOfficerDAO.getAllOfficers();
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IFieldOfficerService#getFieldOfficerById(long)
	 */
	@Override
	@Transactional
	public FieldOfficer getFieldOfficerById(long siteOfficerId)
	{
		
		return fieldOfficerDAO.getFieldOfficerById(siteOfficerId);
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IFieldOfficerService#addFieldOfficer(com.stiff.security.daily.status.model.FieldOfficer)
	 */
	@Override
	@Transactional
	public long addFieldOfficer(FieldOfficer fo)
	{
		try
		{
			return fieldOfficerDAO.addFieldOfficer(fo);		
		}
		catch(Exception e)
		{
			return -1;
		}
	}



	@Override
	@Transactional
	public void updateFieldOfficer(FieldOfficer fo) {
		// TODO Auto-generated method stub
		fieldOfficerDAO.updateFieldOfficer(fo);
	}



	@Override
	@Transactional
	public void removeFieldOfficer(FieldOfficer f) {
		fieldOfficerDAO.removeOfficer(f);
		
	}



	
}
