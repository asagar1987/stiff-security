package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IEmployeeDAO;
import com.stiff.security.daily.status.model.Employee;
import com.stiff.security.daily.status.service.IEmployeeService;

@Service("employeeService")
@Component
public class EmployeeService implements IEmployeeService
{
	@Autowired
	private IEmployeeDAO employeeDAO;

	public void setEmployeeDAO(IEmployeeDAO employeeDAO)
	{
		this.employeeDAO = employeeDAO;
	}



	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IEmployeeService#checkLogin(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public Employee checkLogin(String userName, String userPassword)
	{
		System.out.println("In Service class...Check Login");
		return employeeDAO.checkLogin(userName, userPassword);
	}


	@Transactional
	public List<Employee> getAllOfficers()
	{
		return employeeDAO.getAllOfficers();
	}



	@Override
	@Transactional
	public boolean addEmployee(Employee employee)
	{
		try
		{
			employeeDAO.addEmployee(employee);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}



	@Override
	@Transactional
	public List<Employee> getAllEmployees()
	{
		return employeeDAO.getAllEmployees();
	}



	@Override
	@Transactional
	public Employee getEmployeeById(long id) 
	{
		Employee e = employeeDAO.getEmployeeById(id);
		if(e!=null)
			return e;
		else
			return null;
	}



	@Override
	@Transactional
	public boolean updateEmployee(Employee fo) {
		try
		{
			employeeDAO.updateEmployee(fo);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}



	@Override
	@Transactional
	public void removeEmployee(Employee e) {
		employeeDAO.removeEmployee(e);
		
	}
}
