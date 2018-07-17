package com.mashitatechnologies.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mashitatechnologies.constants.ProvincesURIConstants;
import com.mashitatechnologies.dao.ProvincesDAO;
import com.mashitatechnologies.model.Provinces;


/**
 * Handles requests for the User service.
 */
@Controller
public class ProvincesController {
	
	private ProvincesDAO provinceDAO = new ProvincesDAO();
	
	@RequestMapping(value = ProvincesURIConstants.GET_ALL_PROVINCES, method = RequestMethod.GET)
	public @ResponseBody List<Provinces> getAllProvinces() {
		List<Provinces> allProvinces = new ArrayList<Provinces>();
		try {
			return provinceDAO.getAllProvinces();
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allProvinces;
	}
	
	@RequestMapping(value = ProvincesURIConstants.CREATE_PROVINCE, method = RequestMethod.POST)
	public @ResponseBody String createProvince(@RequestBody Provinces province) {
		try {
			return provinceDAO.createProvince(province);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = ProvincesURIConstants.UPDATE_PROVINCE, method = RequestMethod.PUT)
	public @ResponseBody boolean updateProvince(@RequestBody Provinces province) {
		try {
			return provinceDAO.updateProvinceDetails(province);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@RequestMapping(value = ProvincesURIConstants.REMOVE_PROVINCE, method = RequestMethod.DELETE)
	public @ResponseBody boolean removeInvoiceDAO(@RequestBody Provinces province) {
		try {
			return provinceDAO.removeProvince(province);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = ProvincesURIConstants.GET_PROVINCE_BY_PROVINCE_ID, method = RequestMethod.GET)
	public @ResponseBody List<Provinces> getProvinceByProvinceId(@PathVariable("provinceId") Long province_id) {
		List<Provinces> allprovinces = new ArrayList<Provinces>();
		try {
			return provinceDAO.getProvinceByProvinceId(province_id);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allprovinces;
	}
	
}
