package com.mashitatechnologies.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mashitatechnologies.helper.AbstractDAO;
import com.mashitatechnologies.helper.AbstractDataProvider;
import com.mashitatechnologies.helper.MySQLProvider;
import com.mashitatechnologies.model.Institution;

public class InstitutionDAO extends AbstractDAO  {

	private static final long serialVersionUID = 8092554540965691077L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createInstitution(Institution institution) throws Exception {
		super.create(institution);
		return "Institution created successfully";
	}

	public Institution findInstitutionById(Long id)throws Exception {
		String query = "select o from Company o where o.id =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("id", id);
		return (Institution)super.getUniqueResult(query, parameters);
	}
	
	public Institution findInstitutionByName(String name)throws Exception {
		String query = "select o from Company o where o.id =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("name", name);
		return (Institution)super.getUniqueResult(query, parameters);
	}
	
	public Institution findInstitutionByRegistrationNumber(String regNumber)throws Exception {
		String query = "select o from Company o where o.id =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("regNumber", regNumber);
		return (Institution)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateInstitution(Institution institution) throws Exception  {
		if((findInstitutionById(institution.getInstitutionId())) != null) {
			super.update(institution);
			return true;
		} else {
			throw new Exception("Error: Institution Not found");
		}
	}
	
	public boolean removeInstitution(Institution institution) throws Exception  {
		if((findInstitutionById(institution.getInstitutionId())) != null) {
			super.delete(institution);
			return true;
		} else {
			throw new Exception("Error: Institution Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Institution> getAllInstitution() throws Exception {
		return (List<Institution>)super.getList("select o from Company o ");
	}
}
