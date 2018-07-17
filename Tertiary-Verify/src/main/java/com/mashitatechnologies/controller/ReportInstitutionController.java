package com.mashitatechnologies.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mashitatechnologies.constants.ReportInstitutionURIConstants;
import com.mashitatechnologies.dao.ReportInstitutionDAO;
import com.mashitatechnologies.model.ReportInstitution;

/**
 * Handles requests for the User service.
 */
@Controller
public class ReportInstitutionController {
	
	private ReportInstitutionDAO reportInstitutionDAO = new ReportInstitutionDAO();
	
	@RequestMapping(value = ReportInstitutionURIConstants.GET_ALL_REPORTED_INSTITUTION, method = RequestMethod.GET)
	public @ResponseBody List<ReportInstitution> getAllReportedInstitution() 
	{
		List<ReportInstitution> allReportedInstitution = new ArrayList<ReportInstitution>();
		try {
				allReportedInstitution = reportInstitutionDAO.getAllReportedInstitution();
				return allReportedInstitution;
			} catch (Exception err) 
			{
			err.printStackTrace();
			}
		return allReportedInstitution;
	}
	
	@RequestMapping(value = ReportInstitutionURIConstants.REPORT_INSTITUTION, method = RequestMethod.POST)
	public @ResponseBody String reportInstitution(@RequestBody ReportInstitution reportinstitution) 
	{
		try {
				return reportInstitutionDAO.reportInstitution(reportinstitution);
			} catch (Exception e) 
			{
				e.printStackTrace();
				return e.getMessage();
			}
	}
	
	@RequestMapping(value = ReportInstitutionURIConstants.UPDATE_REPORTED_INSTITUTION, method = RequestMethod.PUT)
	public @ResponseBody boolean updateReportedInstitution(@RequestBody ReportInstitution reportedinstitution) 
	{
		try {
				return reportInstitutionDAO.updateReportedInstitution(reportedinstitution);
			} catch (Exception e) 
			{
				e.printStackTrace();
				return false;
			}
	}
	

	@RequestMapping(value = ReportInstitutionURIConstants.REMOVE_REPORTED_INSTITUTION, method = RequestMethod.DELETE)
	public @ResponseBody boolean removeReportedInstitution(@RequestBody ReportInstitution reportedinstitution) 
	{
		try {
				return reportInstitutionDAO.removeReportedInstitution(reportedinstitution);
			} catch (Exception e) 
			{
				e.printStackTrace();
				return false;
			}
	}
	
	@RequestMapping(value = ReportInstitutionURIConstants.GET_ALL_REPORTED_INSTITUTION_BY_INVESTIGATOR_ID, method = RequestMethod.GET)
	public @ResponseBody List<ReportInstitution> getAllReportedInstitutionByInvestigatorID(@PathVariable("investigatorId") Long investigator_id) 
	{
		List<ReportInstitution> allReportedInstitution = new ArrayList<ReportInstitution>();
		try {
				allReportedInstitution = reportInstitutionDAO.getAllReportedInstitutionByInvestigatorId(investigator_id);
				return allReportedInstitution;
			} catch (Exception err) 
			{
				err.printStackTrace();
			}
		return allReportedInstitution;
	}
	
}
