package com.mashitatechnologies.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.web.client.RestTemplate;

import com.mashitatechnologies.constants.UserURIConstants;
import com.mashitatechnologies.dao.CityDAO;
import com.mashitatechnologies.model.City;
import com.mashitatechnologies.model.Provinces;

public class CityControllerTest {

	public static final String SERVER_URI = "http://localhost:8080/mashitatechnologies";
	
	public static void main(String args[]) {
		
		System.out.println("*****");
		testCreateCity();
		System.out.println("*****");
		testGetAllCities();
		System.out.println("*****");
		testGetCityByProvincyId();

	}

	private static void testCreateCity() {
		
		CityDAO dao = new CityDAO();
		City city1 = new City();
		City city2 = new City();
		
		City city11 = new City();
		City city22 = new City();
		Provinces province1 = new Provinces();
		Provinces province2 = new Provinces();
		Provinces province3 = new Provinces();
		Provinces province4 = new Provinces();
		
		city1.setCityName("Pretoria");
		city1.setCityAbbriation("PTA");
		city1.setCityCode(0001);
		province1.setProvinceId(1L);
		city1.setProvinces(province1);
		
		city2.setCityName("Johannesburg");
		city2.setCityAbbriation("JHB");
		city2.setCityCode(0002);
		province2.setProvinceId(1L);
		city2.setProvinces(province2);
		
		city11.setCityName("Nelspruit");
		city11.setCityAbbriation("NLP");
		city11.setCityCode(0003);
		province3.setProvinceId(2L);
		city11.setProvinces(province3);
		
		city22.setCityName("Witbank");
		city22.setCityAbbriation("WTB");
		city22.setCityCode(0004);
		province4.setProvinceId(2L);
		city22.setProvinces(province4);
		
		try {
			System.out.println(dao.createCity(city1,1L));
			System.out.println(dao.createCity(city2,1L));
			System.out.println(dao.createCity(city11,1L));
			System.out.println(dao.createCity(city22,1L));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void testGetAllCities() {
		CityDAO dao = new CityDAO();
		try {
			List<City> allCities = dao.getAllCities();
			for(City city: allCities) {
				System.out.println("City Name " + city.getCityName());
				System.out.println("City Abbrevations " + city.getCityAbbriation());
				System.out.println("City Code " + city.getCityCode());
				System.out.println("City Province Id " + city.getProvinces().getProvinceId());
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void testGetCityByProvincyId() {
		CityDAO dao = new CityDAO();
		try {
			List<Object[]> allCities = dao.getAllCitiesByProvincyId(2L);
			for(int i=0;i<allCities.size();i++)
			{
				//Object[] data = allCities.get(i);
				Object[] data = (Object[]) allCities.get(i);
				City city = (City)data[0];
				Provinces province = (Provinces)data[1];
			//for(City city: allCities) {
				System.out.println("City Name " + city.getCityName());
				System.out.println("City Abbrevations " + city.getCityAbbriation());
				System.out.println("City Code " + city.getCityCode());
				System.out.println("City Province Id " + province.getProvinceId());
				System.out.println("City Province Name " + province.getProvinceName());
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
