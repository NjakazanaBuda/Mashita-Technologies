package com.mashitatechnologies.dao;


import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mashitatechnologies.helper.AbstractDAO;
import com.mashitatechnologies.helper.AbstractDataProvider;
import com.mashitatechnologies.helper.MySQLProvider;
import com.mashitatechnologies.model.CourseType;
import com.mashitatechnologies.model.InstitutionType;

public class InstitutionTypeDAO extends AbstractDAO {
	
	private static final long serialVersionUID = -7L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createInstitutionType(InstitutionType institutionType) throws Exception {
		super.create(institutionType);
		return "Institution Type has been added successfully";
	}

	public InstitutionType findInstitutionTypeById(Long institution_type_id) throws Exception {
		String query = "from InstitutionType as itp where itp.institutionTypeId =:institution_type_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("institution_type_id", institution_type_id);
		return (InstitutionType)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateInstitutionType(InstitutionType institutionType) throws Exception  {
		if((findInstitutionTypeById(institutionType.getInstitutionTypeId())) != null) {
			super.update(institutionType);
			return true;
		} else {
			throw new Exception("Error: Institution Type Not found");
		}
	}
	
	public boolean removeInstitutionType(InstitutionType institutionType) throws Exception  {
		if((findInstitutionTypeById(institutionType.getInstitutionTypeId())) != null) {
			super.delete(institutionType);
			return true;
		} else {
			throw new Exception("Error: Institution Type Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<InstitutionType> getAllInstitutionsTypes() throws Exception {
		return (List<InstitutionType>)super.getList("from InstitutionType");
	}
	
	@SuppressWarnings("unchecked")
	public List<InstitutionType> getAllInstitutionTypeByInstitutionTypeId(Long institution_type_id) throws Exception {
		String query = "from InstitutionType as itp where itp.institutionTypeId =:institution_type_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("institution_type_id", institution_type_id);
		return (List<InstitutionType>)super.getList(query, parameters);
	}

}
