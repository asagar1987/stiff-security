package com.stiff.security.daily.status.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.stiff.security.daily.status.model.Employee;
@Component
public interface IEmployeeDAO
{

	Employee checkLogin(String userName, String userPassword);

	List<Employee> getAllOfficers();

	List<Employee> getAllEmployees();

	void addEmployee(Employee employee) throws Exception;

	Employee getEmployeeById(long id);

	void updateEmployee(Employee fo);

	void removeEmployee(Employee e);

}