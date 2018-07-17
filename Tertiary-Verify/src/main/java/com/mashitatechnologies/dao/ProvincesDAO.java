package com.mashitatechnologies.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mashitatechnologies.helper.AbstractDAO;
import com.mashitatechnologies.helper.AbstractDataProvider;
import com.mashitatechnologies.helper.MySQLProvider;
import com.mashitatechnologies.model.Provinces;

public class ProvincesDAO extends AbstractDAO {

	private static final long serialVersionUID = -5109296593680166844L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createProvince(Provinces provinces) throws Exception {
		super.create(provinces);
		return "Province has been added successfully";
	}

	public Provinces findProvinceById(Long province_id) throws Exception {
		String query = "select o from Provinces o where o.provinceId =:province_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("province_id", province_id);
		return (Provinces)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateProvinceDetails(Provinces provinceDetails) throws Exception  {
		if((findProvinceById(provinceDetails.getProvinceId())) != null) {
			super.update(provinceDetails);
			return true;
		} else {
			throw new Exception("Error: Province Details Not found");
		}
	}
	
	public boolean removeProvince(Provinces provinceDetails) throws Exception  {
		if((findProvinceById(provinceDetails.getProvinceId())) != null) {
			super.delete(provinceDetails);
			return true;
		} else {
			throw new Exception("Error: Province Details Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Provinces> getAllProvinces() throws Exception {
		return (List<Provinces>)super.getList("from Provinces");
	}
	
	@SuppressWarnings("unchecked")
	public List<Provinces> getProvinceByProvinceId(Long province_id) throws Exception {
		String query = "select o from Provinces o where o.provinceId =:province_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("province_id", province_id);
		return (List<Provinces>)super.getList(query, parameters);
	}
}
