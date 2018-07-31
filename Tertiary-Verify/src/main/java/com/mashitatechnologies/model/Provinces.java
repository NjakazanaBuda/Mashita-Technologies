package com.mashitatechnologies.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mashitatechnologies.helper.IDataEntity;
import com.mashitatechnologies.model.Institution;
import com.mashitatechnologies.model.Investigator;
import com.mashitatechnologies.model.ReportInstitution;
import com.mashitatechnologies.serializer.ProvinceSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@JsonSerialize(using = ProvinceSerializer.class)
@Table(name="provinces")
public class Provinces implements IDataEntity,java.io.Serializable {

	private static final long serialVersionUID = -4274393966627597249L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Id
	//@GeneratedValue(
	   // strategy= GenerationType.AUTO, 
	    //generator="native"
	//)
	//@GenericGenerator(
	  //  name = "native", 
	    //strategy = "native"
	//)
	@Column(name = "province_id", unique = true, nullable = false)
	private Long provinceId;
	
	@Column(name = "province_name", nullable = false)
	private String provinceName;
	
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="province_id")
	protected Set<Institution> institutions = new HashSet<Institution>();
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="province_id")
	private Set<Investigator> investigators = new HashSet<Investigator>();
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="province_id")
	private Set<ReportInstitution> reportinstitution = new HashSet<ReportInstitution>();
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="province_id")
	public Set<City> city;
	

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	
	
	public Set<Institution> getInstitutions() {
		return institutions;
	}

	public void setInstitutions(Set<Institution> institutions) {
		this.institutions = institutions;
	}
	
	public Set<Investigator> getInvestigators() {
		return investigators;
	}

	public void setInvestigators(Set<Investigator> investigators) {
		this.investigators = investigators;
	}
	
	public Set<ReportInstitution> getReportInstitution() {
		return reportinstitution;
	}

	public void setReportInstitution(Set<ReportInstitution> reportinstitution) {
		this.reportinstitution = reportinstitution;
	}
	
	public Set<City> getCity() {
		return city;
	}

	public void setCity(Set<City> city) {
		this.city = city;
	}
	
	
	
	@Override
	public String toString() {
		return "Provinces [provinceId=" + provinceId + ", provinceName=" + provinceName + ", institutions=" + institutions 
				+ ", investigators=" + investigators + ", reportinstitution=" + reportinstitution 
				+ ", city=" + city + "]";
		
	}
}
