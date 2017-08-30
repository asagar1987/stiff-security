package com.stiff.security.daily.status.controller.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stiff.security.daily.status.controller.ILocationController;
import com.stiff.security.daily.status.form.LocationForm;
import com.stiff.security.daily.status.model.FieldOfficer;
import com.stiff.security.daily.status.model.Site;
import com.stiff.security.daily.status.service.IFieldOfficerService;
import com.stiff.security.daily.status.service.ILocationService;

@Controller
@Component
@RequestMapping("locationForm")

public class LocationController implements ILocationController
{
	
	@Autowired
	private ILocationService locationService;
	@Autowired
	private IFieldOfficerService fieldOfficerService;
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.ILocationController#setLocationService(com.stiff.security.daily.status.service.ILocationService)
	 */
	@Override
	public void setLocationService(ILocationService locationService)
	{
		this.locationService = locationService;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.ILocationController#getdata(com.stiff.security.daily.status.form.LocationForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String getdata(@Valid LocationForm locationForm, BindingResult result, Map model,HttpSession session)
	{
		if(session.getAttribute("loggedInUser")==null)
			return "redirect:loginForm";
		List<Site> list = locationService.getAllLocations();
		List<FieldOfficer> siteOfficerList = fieldOfficerService.getAllOfficers();
		locationForm = new LocationForm();
		model.put("locationForm", locationForm);
		model.put("locationList", list);
		model.put("siteOfficerList", siteOfficerList);
		return "locationForm";

	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.ILocationController#getFieldOfficerService()
	 */
	@Override
	public IFieldOfficerService getFieldOfficerService()
	{
		return fieldOfficerService;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.ILocationController#setFieldOfficerService(com.stiff.security.daily.status.service.IFieldOfficerService)
	 */
	@Override
	public void setFieldOfficerService(IFieldOfficerService fieldOfficerService)
	{
		this.fieldOfficerService = fieldOfficerService;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.ILocationController#getLocationService()
	 */
	@Override
	public ILocationService getLocationService()
	{
		return locationService;
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.controller.impl.ILocationController#processForm(com.stiff.security.daily.status.form.LocationForm, org.springframework.validation.BindingResult, java.util.Map, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LocationForm locationForm, BindingResult result, @SuppressWarnings("rawtypes") Map model, HttpSession session)
	{
		System.out.println("Processing Location Form");
		if (result.hasErrors())
		{
			return getdata(locationForm, result, model,session);
		}
		String locationName = locationForm.getLocationName();
		Site site = new Site(locationName, locationForm.getLocationAddress(), fieldOfficerService.getFieldOfficerById(locationForm.getSiteOfficerId()));
		if(locationName.equals(""))
		{
			result.rejectValue("locationName", "locationBlankException");
			return getdata(locationForm, result, model,session);
		}
		else if(locationService.addLocation(site))
		{
			locationForm.setLocationName("");
			return getdata(locationForm, result, model,session);
		}
		else
		{
			result.rejectValue("locationName", "locationAddException");
			return getdata(locationForm, result, model,session);
		}
		
	}

}
