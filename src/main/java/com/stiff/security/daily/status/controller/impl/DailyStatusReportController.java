package com.stiff.security.daily.status.controller.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stiff.security.daily.status.controller.IDailyStatusReportController;
import com.stiff.security.daily.status.form.DailyStatusReportForm;
import com.stiff.security.daily.status.model.DailyStatusReport;
import com.stiff.security.daily.status.model.Employee;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.model.OverTime;
import com.stiff.security.daily.status.model.Site;
import com.stiff.security.daily.status.model.VacantPost;
import com.stiff.security.daily.status.service.IDailyStatusReportService;
import com.stiff.security.daily.status.service.IEmployeeService;
import com.stiff.security.daily.status.service.IFieldOfficerService;
import com.stiff.security.daily.status.service.ILocationService;

import javassist.bytecode.Descriptor.Iterator;

@Controller
@Component
@RequestMapping("dailyStatusReportForm")

public class DailyStatusReportController implements IDailyStatusReportController
{
	
	List<Employee> employeeList = new ArrayList<Employee>();
	List<DailyStatusReport> myDailyReportsList;
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#getMyDailyReportsList()
	 */
	@Override
	public List<DailyStatusReport> getMyDailyReportsList()
	{
		return myDailyReportsList;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#setMyDailyReportsList(java.util.List)
	 */
	@Override
	public void setMyDailyReportsList(List<DailyStatusReport> myDailyReportsList)
	{
		this.myDailyReportsList = myDailyReportsList;
	}


	@Autowired
	private ILocationService locationService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IFieldOfficerService fieldOfficerService;
	
	@Autowired
	private IDailyStatusReportService dailyStatusReportService;
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#getEmployeeList()
	 */
	@Override
	public List<Employee> getEmployeeList()
	{
		return employeeList;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#setEmployeeList(java.util.List)
	 */
	@Override
	public void setEmployeeList(List<Employee> employeeList)
	{
		this.employeeList = employeeList;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#getEmployeeService()
	 */
	@Override
	public IEmployeeService getEmployeeService()
	{
		return employeeService;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#setEmployeeService(com.stiff.security.daily.status.service.IEmployeeService)
	 */
	@Override
	public void setEmployeeService(IEmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#getLocationService()
	 */
	@Override
	public ILocationService getLocationService()
	{
		return locationService;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#setLocationService(com.stiff.security.daily.status.service.ILocationService)
	 */
	@Override
	public void setLocationService(ILocationService locationService)
	{
		this.locationService = locationService;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#getdata(com.stiff.security.daily.status.form.DailyStatusReportForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid DailyStatusReportForm dailyStatusReportForm, BindingResult result, Map model, HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		System.out.println("1");
		dailyStatusReportForm = new DailyStatusReportForm();
		System.out.println("1");
		List<Site> siteList= locationService.getAllLocations();
		List<Site> finalSiteList = new ArrayList<Site>();
		
		FieldOfficer fo = (FieldOfficer)session.getAttribute("loggedInUser");
		long id = fo.getFieldOfficerId();
 		//long id=2;
		
		System.out.println("FINDING MY PREVIOUS REPORTS. MY NAME IS : "+fo.getFieldOfficerName());
 		myDailyReportsList = dailyStatusReportService.getReportsForOfficer(id);
 		if(myDailyReportsList!=null)
 			System.out.println("I HAVE FILLED "+myDailyReportsList.size());
 		for(Site s: siteList)
 		{
 			if(s.getFieldOfficer().getFieldOfficerId()==id)
 			{
 				finalSiteList.add(s);
 			}
 		}
		model.put("siteList", finalSiteList);
		model.put("myDailyReportsList",myDailyReportsList);
		System.out.println("1");
		employeeList = employeeService.getAllEmployees();
		System.out.println("1");
		model.put("employeeList",employeeList );
		System.out.println("1");
		model.put("dailyStatusReportForm", dailyStatusReportForm);
		System.out.println("1");
		return "dailyStatusReportForm";

	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#getEmpoyees(java.lang.String)
	 */
	@Override
	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public @ResponseBody
	List<Employee> getEmpoyees(@RequestParam String tagName) 
	{
		System.out.println("Received TagName as "+tagName);
		return getEmployee(tagName);

	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#getReport(int, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(value = "/getReport", method = RequestMethod.GET)
	public String getReport(@RequestParam int reportId, HttpSession session) 
	{
		System.out.println("Received Report Id as "+reportId);
		if(session.getAttribute("linkReport")!=null)
			session.removeAttribute("linkReport");
		session.setAttribute("linkReport", dailyStatusReportService.getReportById(reportId));
		return "finalReport";
	}
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#getReport(int, java.lang.String, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(value = "/downloadLeaveApplicationFile", method = RequestMethod.GET)
	public HttpEntity<byte[]> getReport(@RequestParam int reportId, @RequestParam String name,HttpSession session) 
	{
		System.out.println("Received Report Id as "+reportId);
		
		byte[]	fileContent=null;
		HttpHeaders header = new HttpHeaders();
		    header.setContentType(new MediaType("application", "pdf"));
		    String fileName=name;
		    header.set("Content-Disposition",
		                   "attachment; filename=" + fileName.replace(" ", "_"));
		    DailyStatusReport dsr = dailyStatusReportService.getReportById(reportId);
		    java.util.Iterator<VacantPost> iter = dsr.getVacantPostsApplications().iterator();
		    while(iter.hasNext())
		    {
		    	VacantPost v = iter.next();
		    	if(v.getFileName().equals(name))
		    	{
		    		fileContent=v.getLeaveApplication();
		    	}
		    }
		    header.setContentLength(fileContent.length);

		    return new HttpEntity<byte[]>(fileContent,header);
	}
	
	private List<Employee> getEmployee(String tagName) {

		List<Employee> result = new ArrayList<Employee>();

		
		
		// iterate a list and filter by tagName
		for (Employee tag : employeeList) {
			if (tag.getEmployeeName().contains(tagName)) {
				result.add(tag);
			}
		}

		return result;
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.IDailyStatusReportController#processForm(com.stiff.security.daily.status.form.DailyStatusReportForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid DailyStatusReportForm dailyStatusReportForm, BindingResult result, @SuppressWarnings("rawtypes") Map model, HttpSession session)
	{
		System.out.println("Processing DailyStatusReport Form");
			System.out.println("SITE ID : "+dailyStatusReportForm.getSiteId());
			System.out.println("FILLED BY: "+dailyStatusReportForm.getFilledBy());
			System.out.println("REPORT DATE: "+dailyStatusReportForm.getReportDate());
			System.out.println("SHIFT :"+dailyStatusReportForm.getShift());
			System.out.println("VACANT POSTS: "+dailyStatusReportForm.getVacantPosts());
			System.out.println("OVERTIMES :"+dailyStatusReportForm.getOverTimes());
			
			List<MultipartFile> files = dailyStatusReportForm.getFiles();
			List<String> fileNames = new ArrayList<String>();
			
			DailyStatusReport dsr = new DailyStatusReport();
			dsr.setSite(locationService.getSiteById(dailyStatusReportForm.getSiteId()));
			dsr.setFieldOfficer(fieldOfficerService.getFieldOfficerById(dailyStatusReportForm.getFilledBy()));
			dsr.setFilledDate(new Date());
			dsr.setDateTime(new Date(dailyStatusReportForm.getReportDate()));
			dsr.setVacantPosts(dailyStatusReportForm.getVacantPosts());
			dsr.setShift(dailyStatusReportForm.getShift());
			Set<OverTime> overTimeSet = new HashSet<OverTime>();
			Set<VacantPost> vacantPostSet = new HashSet<VacantPost>();
			if(dailyStatusReportForm.getOverTimes()!="")
			{
				String[] ot = dailyStatusReportForm.getOverTimes().split(",");
				for(String o:ot)
				{
					OverTime x = new OverTime();
					x.setEmployeeName(o);
					x.setDailyStatusReport(dsr);
					overTimeSet.add(x);
				}
			}
			
			
			
			if(null != files && files.size() > 0) 
			{
				dailyStatusReportForm.setApplications(new ArrayList<byte[]>());
				for (MultipartFile multipartFile : files) {

					String fileName = multipartFile.getOriginalFilename();
					fileNames.add(fileName);
					try
					{
						byte[] x= multipartFile.getBytes();
						VacantPost vp = new VacantPost();
						vp.setFileName(fileName);
						vp.setLeaveApplication(x);
						vp.setDailyStatusReport(dsr);
						vacantPostSet.add(vp);
						System.out.println("FILE CONTENTS: "+x);
						
					}
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			
			dsr.setOverTimes(overTimeSet);
			dsr.setVacantPostsApplications(vacantPostSet);
			
			System.out.println("THE FINAL REPORT IS " );
			System.out.println();
			
			
			dailyStatusReportService.addNewReport(dsr);
			//System.out.println(dsr.toString());
		    return getdata(dailyStatusReportForm, result, model, session);
		
	}

}
