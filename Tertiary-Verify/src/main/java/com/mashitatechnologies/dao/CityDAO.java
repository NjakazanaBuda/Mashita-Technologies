package com.mashitatechnologies.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mashitatechnologies.helper.AbstractDAO;
import com.mashitatechnologies.helper.AbstractDataProvider;
import com.mashitatechnologies.helper.MySQLProvider;
import com.mashitatechnologies.model.City;
import com.mashitatechnologies.model.Provinces;


public class CityDAO extends AbstractDAO{
	
	private static final long serialVersionUID = -4L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createCity(City city, Long provinceId) throws Exception {
		Provinces provinces = new Provinces();
		String message;
		List<Object[]> pro = findProvinceById(provinceId);
		System.out.println("Province before if === "+pro);
		System.out.println("ProvinceId === "+provinceId);
		
		//if(provinceId.equals(pro)) 
		if(pro.size() > 0)
		{ 
			System.out.println("Province === "+pro);
			provinces.setProvinceId(provinceId);
			System.out.println("Province === "+ provinces.toString());
			city.setProvinces(provinces);
			System.out.println("Province === "+ city.toString());
			super.create(city);
			System.out.println("Province === "+ city.toString());
			message = "City has been added successfully" ;
		}
		else
		{   System.out.println("Province else === "+pro);
			message = "Province don't exist" ;
		}
		
		return message;
	}
	
	public City findCityById(Long city_id) throws Exception {
		String query = "select o from City o where o.cityId =:city_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("city_id", city_id);
		return (City)super.getUniqueResult(query, parameters);
	}
	
	//public Provinces findProvinceById(Long province_id) throws Exception {
	
		//String query = "select o.provinceId from Provinces o where o.provinceId =:province_id";
		//Map<String,Object>parameters = new Hashtable<String,Object>();
		//parameters.put("province_id", province_id);
		//return (Provinces)super.getUniqueResult(query, parameters);
	//}
	
	public List<Object[]> findProvinceById(Long province_id) throws Exception {
		String query = "select o.provinceId from Provinces o where o.provinceId =:province_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("province_id", province_id);
		return (List<Object[]>)super.getList(query, parameters);
	}
	
	public boolean updateCity(City city) throws Exception  {
		if((findCityById(city.getCityId())) != null) {
			super.update(city);
			return true;
		} else {
			throw new Exception("Error: City Not found");
		}
	}
	
	public boolean removeCity(City city) throws Exception  {
		if((findCityById(city.getCityId())) != null) {
			super.delete(city);
			return true;
		} else {
			throw new Exception("Error: City Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<City> getAllCities() throws Exception {
		return (List<City>)super.getList("from City");
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getAllCitiesByProvincyId(Long province_id) throws Exception {
		//Querying one to many. One Province many cities.
		String query = "from City as c INNER JOIN c.provinces as p where p.provinceId = :province_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("province_id", province_id);
		return (List<Object[]>)super.getList(query, parameters);
	}

}
