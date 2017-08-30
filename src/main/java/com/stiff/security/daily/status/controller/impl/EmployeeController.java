package com.stiff.security.daily.status.controller.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stiff.security.daily.status.form.EmployeeForm;
import com.stiff.security.daily.status.model.Designation;
import com.stiff.security.daily.status.model.Employee;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.model.Site;
import com.stiff.security.daily.status.service.IDesignationService;
import com.stiff.security.daily.status.service.IEmployeeService;
import com.stiff.security.daily.status.service.IFieldOfficerService;
import com.stiff.security.daily.status.service.ILocationService;

@Controller
@Component
@RequestMapping("employeeForm")

public class EmployeeController
{
	
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private ILocationService locationService;
	@Autowired
	private IDesignationService designationService;
	@Autowired
	private IFieldOfficerService fieldOfficerService;
	
	
	public IFieldOfficerService getFieldOfficerService()
	{
		return fieldOfficerService;
	}


	public void setFieldOfficerService(IFieldOfficerService fieldOfficerService)
	{
		this.fieldOfficerService = fieldOfficerService;
	}


	public IEmployeeService getEmployeeService()
	{
		return employeeService;
	}


	public void setEmployeeService(IEmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}


	


	public ILocationService getLocationService()
	{
		return locationService;
	}


	public void setLocationService(ILocationService locationService)
	{
		this.locationService = locationService;
	}


	public IDesignationService getDesignationService()
	{
		return designationService;
	}


	public void setDesignationService(IDesignationService designationService)
	{
		this.designationService = designationService;
	}

	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid EmployeeForm employeeForm, BindingResult result, Map model,HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		List<Designation> designationList = designationService.getAllDesignations();
		List<Site> locationList = locationService.getAllLocations();
		List<Employee> employeeList = employeeService.getAllEmployees();
		List<FieldOfficer> officerList = fieldOfficerService.getAllOfficers();
		
		for(FieldOfficer f:officerList)
		{
			Employee e = new Employee();
			e.setEmployeeId(f.getFieldOfficerId());
			e.setEmployeeName(f.getFieldOfficerName());
			e.setDesignation(f.getDesignation());
			
			Iterator i = f.getSite().iterator();
			while(i.hasNext())
			{
				e.setSite((Site)i.next());
			}
			e.setShift(f.getShift());
			employeeList.add(e);
		}
		
		if(model.get("employeeForm")==null)
			employeeForm = new EmployeeForm();
		
		model.put("employeeForm", employeeForm);
		model.put("designationList", designationList);
		model.put("locationList", locationList);
		model.put("employeesList",employeeList);
		return "employeeForm";

	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@RequestParam String act,
			@Valid EmployeeForm employeeForm, BindingResult result, @SuppressWarnings("rawtypes") Map model,HttpSession session)
	{
		System.out.println("Processing Designation Form");
		System.out.println("ACT IS : "+act);
		
		if (result.hasErrors())
		{
			return getdata(employeeForm, result, model,session);
		}
		String employeeName = employeeForm.getEmployeeName();
		if(employeeName.equals(""))
		{
			result.rejectValue("employeeName", "employeeNameBlankException");
			return getdata(employeeForm, result, model,session);
		}
		else if(!(employeeName.equals("")))
		{
			Designation d = designationService.getDesignationById(employeeForm.getDesignationId());
			String designation = d.getDesignationName();
			System.out.println(d.toString());
			if(designation.equalsIgnoreCase("Field Officer") || designation.equalsIgnoreCase("Marketing Officer") || designation.equalsIgnoreCase("DGM") || designation.equalsIgnoreCase("Deputy General Manager") || designation.equalsIgnoreCase("General Manager") || designation.equalsIgnoreCase("Telecaller") || designation.equalsIgnoreCase("Marketing/Telecallers") || designation.equalsIgnoreCase("HR Manager") || designation.equalsIgnoreCase("Administrator"))
			{
				FieldOfficer fo ;
				
				if(act.equalsIgnoreCase("add"))
					fo = new FieldOfficer();
				else
					fo = fieldOfficerService.getFieldOfficerById(employeeForm.getEmployeeId());
				fo.setFieldOfficerName(employeeName);
				fo.setDesignation(d);
				fo.setUsername(employeeForm.getUsername());
				fo.setPassword(employeeForm.getPassword());
				fo.setShift(employeeForm.getShift());
				if(act.equalsIgnoreCase("add"))
				{	long added=fieldOfficerService.addFieldOfficer(fo);
					if(added>0)
					{
						fo = fieldOfficerService.getFieldOfficerById(added);
						Site s = locationService.getSiteById(employeeForm.getSiteId());
						s.setFieldOfficer(fo);
						locationService.updateSite(s);
					}
					else
					{
						result.rejectValue("employeeName", "employeeAddException");
						return getdata(employeeForm, result, model,session);
					}
				}
				else
					fieldOfficerService.updateFieldOfficer(fo);
				
			}
			else
			{
				System.out.println("Processing Else");
				
				Employee fo ;
				
				if(act.equalsIgnoreCase("add"))
					fo = new Employee();
				else
					fo = employeeService.getEmployeeById(employeeForm.getEmployeeId());
				
				
				fo.setEmployeeName(employeeName);
				fo.setDesignation(d);
				fo.setUsername(employeeForm.getUsername());
				fo.setPassword(employeeForm.getPassword());
				fo.setSite(locationService.getSiteById(employeeForm.getSiteId()));
				fo.setShift(employeeForm.getShift());
				
				if(act.equalsIgnoreCase("add"))
				{
					boolean added=employeeService.addEmployee(fo);
					if(!added)
					{
						result.rejectValue("employeeName", "employeeAddException");
						return getdata(employeeForm, result, model,session);
					}
				}
				else
					employeeService.updateEmployee(fo);
					
			}
			model.put("employeeForm",null);
			return getdata(employeeForm, result, model,session);
		}
		else
		{
			model.put("employeeForm",null);
			result.rejectValue("employeeName", "designationAddException");
			return getdata(employeeForm, result, model,session);
		}
		
	}

	@RequestMapping(value = "/removeEmployee", method = RequestMethod.GET)
	public String removeEmployee(@RequestParam long id,
			@RequestParam String designation,
			@Valid EmployeeForm employeeForm, 
			BindingResult result, 
			Map model,
			HttpSession session) 
	{
		System.out.println("Received Employee Id as "+id);
		System.out.println("Received Designation Name as "+designation);
		if(designation.equalsIgnoreCase("Field Officer") || designation.equalsIgnoreCase("Marketing Officer") || designation.equalsIgnoreCase("DGM") || designation.equalsIgnoreCase("Deputy General Manager") || designation.equalsIgnoreCase("General Manager") || designation.equalsIgnoreCase("Telecaller") || designation.equalsIgnoreCase("Marketing/Telecallers") || designation.equalsIgnoreCase("HR Manager") || designation.equalsIgnoreCase("Administrator"))
		{
			FieldOfficer f = fieldOfficerService.getFieldOfficerById(id);
			if(f!=null)
			{
				fieldOfficerService.removeFieldOfficer(f);
			}
		}
		else
		{
			Employee e = employeeService.getEmployeeById(id);
			
			if(e!=null)
			{
				employeeService.removeEmployee(e);
			}
		
		}
		
		return getdata(employeeForm, result, model,session);
	}
	
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public String editEmployee(@RequestParam long id,
			@RequestParam String designation, 
			@Valid EmployeeForm employeeForm, 
			BindingResult result, 
			Map model,
			HttpSession session) 
	{
		System.out.println("Received Employee Id as "+id);
		if(designation.equalsIgnoreCase("Field Officer") || designation.equalsIgnoreCase("Marketing Officer") || designation.equalsIgnoreCase("DGM") || designation.equalsIgnoreCase("Deputy General Manager") || designation.equalsIgnoreCase("General Manager") || designation.equalsIgnoreCase("Telecaller") || designation.equalsIgnoreCase("Marketing/Telecallers") || designation.equalsIgnoreCase("HR Manager") || designation.equalsIgnoreCase("Administrator"))
		{
			FieldOfficer f = fieldOfficerService.getFieldOfficerById(id);
			System.out.println(f.toString());
			if(f!=null)
			{
				employeeForm.setEmployeeId(id);
				employeeForm.setEmployeeName(f.getFieldOfficerName());
				employeeForm.setUsername(f.getUsername());
				employeeForm.setPassword(f.getPassword());
				employeeForm.setShift(f.getShift());
				employeeForm.setDesignationId(f.getDesignation().getDesignationId());
				
			}
		}
		else
		{	
			    Employee e = employeeService.getEmployeeById(id);
			    System.out.println(e.toString());
				if(e!=null)
				{
				    employeeForm.setEmployeeId(id);
					employeeForm.setEmployeeName(e.getEmployeeName());
					employeeForm.setUsername(e.getUsername());
					employeeForm.setPassword(e.getPassword());
					employeeForm.setShift(e.getShift());
					employeeForm.setSiteId(e.getSite().getSiteId());
					employeeForm.setDesignationId(e.getDesignation().getDesignationId());
				}
			
		}
		model.put("employeeForm", employeeForm);
		return getdata(employeeForm, result, model,session);
	}
}
