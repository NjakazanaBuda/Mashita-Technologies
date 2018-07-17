package com.mashitatechnologies.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mashitatechnologies.helper.IDataEntity;
import com.mashitatechnologies.model.Provinces;

@Entity
@Table(name="reported_institutions")
public class ReportInstitution implements IDataEntity {

	private static final long serialVersionUID = -8995805217493140586L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reported_institution_id", unique = true, nullable = false)
	private Long reportedInstitutionId;
	
	@Column(name = "reported_type", nullable = false)
	private String reportedType;
	
	@Column(name = "institution_name", nullable = false)
	private String institutionName;
	
	@Column(name = "courseName", nullable = true)
	private String courseName;
	
	@Column(name = "reported_date", nullable = false)
	private String reportedDate;
	
	@Column(name = "institution_address_line1", nullable = false)
	private String institutionAddressLineOne;
	
	@Column(name = "institution_address_line2", nullable = false)
	private String institutionAddressLineTwo;
	
	@Column(name = "institution_address_line3", nullable = false)
	private String institutionAddressLineThree;
	
	@ManyToOne
	@JoinColumn(name = "province_id", nullable = false)
	@JsonBackReference
	private Provinces provinces;

	@Column(name = "city_town", nullable = false)
	private String cityTown;
	
	@Column(name = "suburb_area", nullable = false)
	private String suburbArea;
	
	@Column(name = "address_code", nullable = false)
	private String addressCode;
	
	@Column(name = "pin_location", nullable = false)
	private String pinLocation;
	
	@OneToOne(cascade=CascadeType.ALL)  
	@JoinTable(name="reported_institution", joinColumns={@JoinColumn(name ="reported_institution_id", referencedColumnName ="reported_institution_id")},
	          inverseJoinColumns={@JoinColumn(name ="investigator_number", referencedColumnName ="investigator_number")})
	private Investigator investigator;
	
	
	
	public Long getReportedInstitutionId() {
		return reportedInstitutionId;
	}

	public void setReportedInstitutionId(Long reportedInstitutionId) {
		this.reportedInstitutionId = reportedInstitutionId;
	}

	public String getReportedType() {
		return reportedType;
	}

	public void setReportedType(String reportedType) {
		this.reportedType = reportedType;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}

	public String getInstitutionAddressLineOne() {
		return institutionAddressLineOne;
	}

	public void setTotal(String institutionAddressLineOne) {
		this.institutionAddressLineOne = institutionAddressLineOne;
	}

	public String getInstitutionAddressLineTwo() {
		return institutionAddressLineTwo;
	}

	public void setInstitutionAddressLineTwo(String institutionAddressLineTwo) {
		this.institutionAddressLineTwo = institutionAddressLineTwo;
	}
	
	public String getInstitutionAddressLineThree() {
		return institutionAddressLineThree;
	}

	public void setInstitutionAddressLineThree(String institutionAddressLineThree) {
		this.institutionAddressLineThree = institutionAddressLineThree;
	}
	
	
	public Provinces getProvinces() {
		return provinces;
	}

	public void setProvinces(Provinces provinces) {
		this.provinces = provinces;
	}
	
	public String getCityTown() {
		return cityTown;
	}

	public void setCityTown(String cityTown) {
		this.cityTown = cityTown;
	}
	
	public String getSuburbArea() {
		return suburbArea;
	}

	public void setSuburbArea(String suburbArea) {
		this.suburbArea = suburbArea;
	}
	
	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	
	public String getPinLocation() {
		return pinLocation;
	}

	public void setPinLocation(String pinLocation) {
		this.pinLocation = pinLocation;
	}
	
	public Investigator getInvestigator() {
		return investigator;
	}
	public void setInvestigator(Investigator investigator) {
		this.investigator = investigator;
	}

	@Override
	public String toString() {
		return "ReportedInstitutions [reportedInstitutionId=" + reportedInstitutionId + ", reportedType=" + reportedType + ", institutionName=" + institutionName 
				+ ", courseName=" + courseName + ", reportedDate=" + reportedDate + ", institutionAddressLineOne=" + institutionAddressLineOne 
				+ ", institutionAddressLineTwo=" + institutionAddressLineTwo + ", institutionAddressLineThree=" + institutionAddressLineThree 
				+ ", provinces=" + provinces + ", cityTown=" + cityTown + ", suburbArea=" + suburbArea 
				+ ", addressCode=" + addressCode + ", pinLocation=" + pinLocation + ", investigator=" + investigator + "]";
	}

}
