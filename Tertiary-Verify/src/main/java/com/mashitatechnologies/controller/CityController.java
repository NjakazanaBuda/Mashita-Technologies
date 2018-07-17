package com.mashitatechnologies.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.Model;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mashitatechnologies.constants.CityURIConstants;
import com.mashitatechnologies.dao.CityDAO;
import com.mashitatechnologies.model.City;
import com.mashitatechnologies.model.Provinces;


@Controller
public class CityController {
	
	private CityDAO cityDAO = new CityDAO();
	
	@RequestMapping(value = CityURIConstants.GET_ALL_CITIES, method = RequestMethod.GET)
	public @ResponseBody List<City> getAllCities() {
		List<City> allCities = new ArrayList<City>();
		try {
			return cityDAO.getAllCities();
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allCities;
	}
	
	@RequestMapping(value = CityURIConstants.CREATE_CITY, method = RequestMethod.POST)
	public @ResponseBody String createCity(@PathVariable("provinceId") Long provinceId, @RequestBody City city) {
		try {
			return cityDAO.createCity(city,provinceId);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = CityURIConstants.UPDATE_CITY, method = RequestMethod.PUT)
	public @ResponseBody boolean updateCity(@RequestBody City city) {
		try {
			return cityDAO.updateCity(city);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@RequestMapping(value = CityURIConstants.REMOVE_CITY, method = RequestMethod.DELETE)
	public @ResponseBody boolean removeInvoiceDAO(@RequestBody City city) {
		try {
			return cityDAO.removeCity(city);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = CityURIConstants.GET_CITIES_BY_PROVINCE_ID, method = RequestMethod.GET)
	public @ResponseBody List<Object[]> getAllCitiesByProvincyId(@PathVariable("provinceId") Long province_id) {
		List<Object[]> allcities = new ArrayList<Object[]>();
		try {
			allcities = cityDAO.getAllCitiesByProvincyId(province_id);
			return cityDAO.getAllCitiesByProvincyId(province_id);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allcities;
	}

}
