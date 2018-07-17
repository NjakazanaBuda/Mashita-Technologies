package com.mashitatechnologies.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mashitatechnologies.constants.InstitutionURIConstants;
import com.mashitatechnologies.dao.InstitutionDAO;
import com.mashitatechnologies.model.Institution;

/**
 * Handles requests for the User service.
 */
@Controller
public class InstitutionController {
	
	private InstitutionDAO institutionDAO = new InstitutionDAO();
	
	@RequestMapping(value = InstitutionURIConstants.GET_ALL_INSTITUTIONS, method = RequestMethod.GET)
	public @ResponseBody List<Institution> getAllInstitution() {
		List<Institution> allInstitutions = new ArrayList<Institution>();
		try {
			allInstitutions = institutionDAO.getAllInstitution();
			return allInstitutions;
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allInstitutions;
	}
	
	@RequestMapping(value = InstitutionURIConstants.CREATE_INSTITUTION, method = RequestMethod.POST)
	public @ResponseBody String createComapny(@RequestBody Institution institution) {
		try {
			return institutionDAO.createInstitution(institution);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = InstitutionURIConstants.REMOVE_INSTITUTION, method = RequestMethod.DELETE)
	public @ResponseBody Boolean removeCompany(@RequestBody Institution institution) {
		try {
			return institutionDAO.removeInstitution(institution);
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	
	@RequestMapping(value = InstitutionURIConstants.UPDATE_INSTITUTION, method = RequestMethod.PUT)
	public @ResponseBody Boolean removeComapny(@RequestBody Institution institution) {
		try {
			return institutionDAO.updateInstitution(institution);
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
}
