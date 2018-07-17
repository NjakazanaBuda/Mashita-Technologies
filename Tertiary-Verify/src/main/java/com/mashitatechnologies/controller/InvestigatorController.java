package com.mashitatechnologies.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mashitatechnologies.constants.InvestigatorURIConstants;
import com.mashitatechnologies.dao.InvestigatorDAO;
import com.mashitatechnologies.model.Investigator;

/**
 * Handles requests for the User service.
 */
@Controller
public class InvestigatorController {
	
	private InvestigatorDAO investigatorDAO = new InvestigatorDAO();
	
	@RequestMapping(value = InvestigatorURIConstants.GET_ALL_INVESTIGATORS, method = RequestMethod.GET)
	public @ResponseBody List<Investigator> getAllInvestigators() 
	{
		List<Investigator> allInvestigators = new ArrayList<Investigator>();
		try {
				allInvestigators = investigatorDAO.getAllInvestigators();
				return allInvestigators;
			 } catch (Exception err) 
			 {
				 err.printStackTrace();
			 }
		return allInvestigators;
	}
	
	@RequestMapping(value = InvestigatorURIConstants.CREATE_INVESTIGATOR, method = RequestMethod.POST)
	public @ResponseBody String createInvestigator(@RequestBody Investigator investigator) 
	{
		try {
				return investigatorDAO.createInvestigator(investigator);
			} catch (Exception e) 
			{
				e.printStackTrace();
				return e.getMessage();
			}
	}
	
	@RequestMapping(value = InvestigatorURIConstants.UPDATE_INVESTIGATOR, method = RequestMethod.PUT)
	public @ResponseBody boolean updateInvoice(@RequestBody Investigator investigator)
	{
		try {
				return investigatorDAO.updateInvestigator(investigator);
			} catch (Exception e) 
			{
				e.printStackTrace();
				return false;
			}
	}
	

	@RequestMapping(value = InvestigatorURIConstants.REMOVE_INVESTIGATOR, method = RequestMethod.DELETE)
	public @ResponseBody boolean removeInvoiceDAO(@RequestBody Investigator investigator) 
	{
		try {
				return investigatorDAO.removeInvestigator(investigator);
			} catch (Exception e) 
			{
				e.printStackTrace();
				return false;
			}
	}
	
	@RequestMapping(value = InvestigatorURIConstants.GET_ALL_INVESTIGATORS_BY_REPORTED_INSTITUTION_ID, method = RequestMethod.GET)
	public @ResponseBody List<Investigator> getAllInvestigatorByReportedInstitutionInvestigatorID(@PathVariable("InvestigatorID") Long investigator_id) 
	{
		List<Investigator> allInvoices = new ArrayList<Investigator>();
		try {
			return investigatorDAO.getAllInvestigatorByReportedInstitutionInvestigatorID(investigator_id);
			
			} catch (Exception err) 
			{
				err.printStackTrace();
			}
		return allInvoices;
	}
	
}
