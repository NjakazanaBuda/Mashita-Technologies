package com.mashitatechnologies.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mashitatechnologies.helper.AbstractDAO;
import com.mashitatechnologies.helper.AbstractDataProvider;
import com.mashitatechnologies.helper.MySQLProvider;
import com.mashitatechnologies.model.Investigator;
import com.mashitatechnologies.model.ReportInstitution;

public class ReportInstitutionDAO extends AbstractDAO {

	private static final long serialVersionUID = -5109296593680166844L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String reportInstitution(ReportInstitution report) throws Exception {
		super.create(report);
		return "Institutuion reported successfully";
	}

	public ReportInstitution findReportInstitutionById(Long id) throws Exception {
		String query = "select o from ReportInstitution o where o.provinceId =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("id", id);
		return (ReportInstitution)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateReportedInstitution(ReportInstitution report) throws Exception  {
		if((findReportInstitutionById(report.getReportedInstitutionId())) != null) {
			super.update(report);
			return true;
		} else {
			throw new Exception("Error: Reported Institution Not found");
		}
	}
	
	public boolean removeReportedInstitution(ReportInstitution report) throws Exception  {
		if((findReportInstitutionById(report.getReportedInstitutionId())) != null) {
			super.delete(report);
			return true;
		} else {
			throw new Exception("Error: Reported Institution Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ReportInstitution> getAllReportedInstitution() throws Exception {
		return (List<ReportInstitution>)super.getList("select o from ReportInstitution o ");
	}
	
	@SuppressWarnings("unchecked")
	public List<ReportInstitution> getAllReportedInstitutionByInvestigatorId(Long reported_institution_id) throws Exception {
		String query = "select o from ReportInstitution o where o.id =:reported_institution_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("reported_institution_id", reported_institution_id);
		return (List<ReportInstitution>)super.getList(query, parameters);
	}
}
