package com.mashitatechnologies.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mashitatechnologies.helper.AbstractDAO;
import com.mashitatechnologies.helper.AbstractDataProvider;
import com.mashitatechnologies.helper.MySQLProvider;
import com.mashitatechnologies.model.Investigator;

public class InvestigatorDAO extends AbstractDAO {

	private static final long serialVersionUID = -5109296593680166844L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createInvestigator(Investigator investigator) throws Exception {
		super.create(investigator);
		return "Investigator added successfully";
	}

	public Investigator findInvestigatorById(Long id) throws Exception {
		String query = "select o from Investigator o where o.id =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("id", id);
		return (Investigator)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateInvestigator(Investigator investigator) throws Exception  {
		if((findInvestigatorById(investigator.getInvestigatorNumber())) != null) {
			super.update(investigator);
			return true;
		} else {
			throw new Exception("Error: Investigator Details Not found");
		}
	}
	
	public boolean removeInvestigator(Investigator investigator) throws Exception  {
		if((findInvestigatorById(investigator.getInvestigatorNumber())) != null) {
			super.delete(investigator);
			return true;
		} else {
			throw new Exception("Error: Quation Details Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Investigator> getAllInvestigators() throws Exception {
		return (List<Investigator>)super.getList("select o from Investigator o ");
	}
	
	@SuppressWarnings("unchecked")
	public List<Investigator> getAllInvestigatorByReportedInstitutionInvestigatorID(Long reported_institution_id) throws Exception {
		String query = "select o from SalesInvoiceDetails o where o.id =:reported_institution_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("reported_institution_id", reported_institution_id);
		return (List<Investigator>)super.getList(query, parameters);
	}
}
