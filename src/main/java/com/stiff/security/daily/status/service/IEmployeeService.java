package com.stiff.security.daily.status.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.stiff.security.daily.status.model.Employee;

@Component
public interface IEmployeeService
{

	Employee checkLogin(String userName, String userPassword);

	List<Employee> getAllOfficers();

	boolean addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	boolean updateEmployee(Employee fo);

	void removeEmployee(Employee e);

}