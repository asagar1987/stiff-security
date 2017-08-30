package com.stiff.security.daily.status.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.stiff.security.daily.status.dao.IEmployeeDAO;
import com.stiff.security.daily.status.model.Employee;
import com.stiff.security.daily.status.model.FieldOfficer;

@Component
@Repository("employeeDAO")
public class EmployeeDAO implements IEmployeeDAO
{
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession()
	{
		return sessionFactory.openSession();
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.dao.IEmployeeDAO#checkLogin(java.lang.String, java.lang.String)
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	public Employee checkLogin(String userName, String userPassword)
	{
		System.out.println("In Check login");
		Session session = sessionFactory.getCurrentSession();
		Employee userFound = null;
		
		String SQL_QUERY = " from Employee as o where o.username=? and o.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, userName);
		query.setParameter(1, userPassword);
		List<Employee> list = query.list();

		if ((list != null) && (list.size() > 0))
		{
			userFound = list.get(0);
		}

		
		return userFound;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllOfficers()
	{
		System.out.println("Getting List of Officers");
		Session session = sessionFactory.getCurrentSession();
		// Query using Hibernate Query Language
		String SQL_QUERY = " from Employee where designationid=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, 1);
	
		List<Employee> list = query.list();
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees()
	{
		System.out.println("Getting List of Employees");
		Session session = sessionFactory.getCurrentSession();
		// Query using Hibernate Query Language
		String SQL_QUERY = " from Employee";
		Query query = session.createQuery(SQL_QUERY);
		
		List<Employee> list = query.list();
		return list;
	}

	@Override
	public void addEmployee(Employee employee) throws Exception
	{
		System.out.println("Adding new Employee by name "+employee.toString());
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
		
		
	}

	@Override
	public Employee getEmployeeById(long id) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		Employee fo =  (Employee)session.get(Employee.class, id);
		
		return fo;
	}

	@Override
	public void updateEmployee(Employee fo) {
		System.out.println("Updating new Employee by name "+fo.toString());
		Session session = sessionFactory.getCurrentSession();
		session.update(fo);
		
		
	}

	@Override
	public void removeEmployee(Employee e) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.delete(e);
		
	}
}
