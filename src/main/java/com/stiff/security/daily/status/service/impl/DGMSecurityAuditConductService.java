package com.stiff.security.daily.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiff.security.daily.status.dao.IDGMSecurityAuditConductDAO;
import com.stiff.security.daily.status.dao.IMarketingVisitDAO;
import com.stiff.security.daily.status.model.DGMSecurityAuditConduct;
import com.stiff.security.daily.status.service.IDGMSecurityAuditConductService;

@Service("dgmSecurityAuditConductService")
@Component
public class DGMSecurityAuditConductService implements IDGMSecurityAuditConductService 
{
	@Autowired
	private IDGMSecurityAuditConductDAO dgmSecurityAuditConductDAO;

	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMSecurityAuditConductService#getDgmSecurityAuditConductDAO()
	 */
	@Override
	public IDGMSecurityAuditConductDAO getDgmSecurityAuditConductDAO()
	{
		return dgmSecurityAuditConductDAO;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMSecurityAuditConductService#setDgmSecurityAuditConductDAO(com.stiff.security.daily.status.dao.IDGMSecurityAuditConductDAO)
	 */
	@Override
	public void setDgmSecurityAuditConductDAO(IDGMSecurityAuditConductDAO dgmSecurityAuditConductDAO)
	{
		this.dgmSecurityAuditConductDAO = dgmSecurityAuditConductDAO;
	}


	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMSecurityAuditConductService#getVisitsForOfficer(long)
	 */
	@Override
	@Transactional
	public List<DGMSecurityAuditConduct> getVisitsForOfficer(long id)
	{
		try
		{
			return dgmSecurityAuditConductDAO.getMyVisits(id);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMSecurityAuditConductService#getAllVisits()
	 */
	@Override
	@Transactional
	public List<DGMSecurityAuditConduct> getAllVisits()
	{
		try
		{
			return dgmSecurityAuditConductDAO.getAllVisits();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.stiff.security.daily.status.service.IDGMSecurityAuditConductService#addMarketingVisit(com.stiff.security.daily.status.model.DGMSecurityAuditConduct)
	 */
	@Override
	@Transactional
	public void addMarketingVisit(DGMSecurityAuditConduct m)
	{
		try
		{
			dgmSecurityAuditConductDAO.addDGMSecurityAuditConduct(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
