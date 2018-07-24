package com.mashitatechnologies.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mashitatechnologies.helper.IDataEntity;
import com.mashitatechnologies.model.Provinces;
import com.mashitatechnologies.model.ReportInstitution;

@Entity
@Table(name="investigators")
public class Investigator implements IDataEntity {

	private static final long serialVersionUID = -8995805217493140586L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "investigator_number", unique = true, nullable = false)
	private Long investigatorNumber;
	
	@Column(name = "investigator_first_name", nullable = false)
	private String investigatorFirstName;
	
	@Column(name = "investigator_middle_name", nullable = false)
	private String investigatorMiddleName;
	
	@Column(name = "investigator_surname_name", nullable = true)
	private String investigatorSurnameName;
	
	@Column(name = "investigator_id_number", nullable = true)
	private Long investigatorIdNumber;
	
	@Column(name = "investigator_gender", nullable = true)
	private String investigatorGender;
	
	@Column(name = "investigator_address_line1", nullable = true)
	private String investigatorAddressLineOne;
	
	@Column(name = "investigator_address_line2", nullable = false)
	private String investigatorAddressLineTwo;
	
	@ManyToOne
	@JoinColumn(name = "province_id", nullable = false)
	@JsonBackReference
	private Provinces provinces;
	
	//please add relationship
	@Column(name = "town_address_line4", nullable = false)
	private Long townAddressLineFour;
	
	@Column(name = "contact_no", nullable = false)
	private Long contactNo;
	
	@Column(name = "alternative_contact_no", nullable = false)
	private Long alternativeContactNo;
	
	@Column(name = "email_address", nullable = false)
	private String emailAddress;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="reported_institution_invesigator", joinColumns={@JoinColumn(name ="investigator_number", referencedColumnName ="investigator_number")},
			inverseJoinColumns={@JoinColumn(name ="reported_institution_id", referencedColumnName ="reported_institution_id")})
	private Set<ReportInstitution> reportedInstitution;
	

	public Long getInvestigatorNumber() {
		return investigatorNumber;
	}

	public void setInvestigatorNumber(Long investigatorNumber) {
		this.investigatorNumber = investigatorNumber;
	}

	public String getInvestigatorFirstName() {
		return investigatorFirstName;
	}

	public void setInvestigatorFirstName(String investigatorFirstName) {
		this.investigatorFirstName = investigatorFirstName;
	}

	public String getInvestigatorMiddleName() {
		return investigatorMiddleName;
	}

	public void setInvestigatorMiddleName(String investigatorMiddleName) {
		this.investigatorMiddleName = investigatorMiddleName;
	}

	public String getInvestigatorSurnameName() {
		return investigatorSurnameName;
	}

	public void setInvestigatorSurnameName(String investigatorSurnameName) {
		this.investigatorSurnameName = investigatorSurnameName;
	}

	public Long getInvestigatorIdNumber() {
		return investigatorIdNumber;
	}

	public void setInvestigatorIdNumber(Long investigatorIdNumber) {
		this.investigatorIdNumber = investigatorIdNumber;
	}

	public String getInvestigatorGender() {
		return investigatorGender;
	}

	public void setInvestigatorGender(String investigatorGender) {
		this.investigatorGender = investigatorGender;
	}

	public String getInvestigatorAddressLineOne() {
		return investigatorAddressLineOne;
	}

	public void setInvestigatorAddressLineOne(String investigatorAddressLineOne) {
		this.investigatorAddressLineOne = investigatorAddressLineOne;
	}

	public String getInvestigatorAddressLineTwo() {
		return investigatorAddressLineTwo;
	}

	public void setInvestigatorAddressLineTwo(String investigatorAddressLineTwo) {
		this.investigatorAddressLineTwo = investigatorAddressLineTwo;
	}
	
	public Provinces getProvinces() {
		return provinces;
	}

	public void setProvinces(Provinces provinces) {
		this.provinces = provinces;
	}
	
	public Long getTownAddressLineFour() {
		return townAddressLineFour;
	}

	public void setTownAddressLineFour(Long townAddressLineFour) {
		this.townAddressLineFour = townAddressLineFour;
	}
	
	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	
	public Long getAlternativeContactNo() {
		return alternativeContactNo;
	}

	public void setAlternativeContactNo(Long alternativeContactNo) {
		this.alternativeContactNo = alternativeContactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public Set<ReportInstitution> getReportedInstitution() {
		return reportedInstitution;
	}
	public void setReportedInstitution(Set<ReportInstitution> reportedInstitution) {
		this.reportedInstitution = reportedInstitution;
	}
	

	@Override
	public String toString() {
		return "Investigators [investigatorNumber=" + investigatorNumber + ", investigatorFirstName=" + investigatorFirstName 
				+ ", investigatorMiddleName=" + investigatorMiddleName + ", investigatorSurnameName=" + investigatorSurnameName 
				+ ", investigatorIdNumber=" + investigatorIdNumber + ", investigatorGender=" + investigatorGender 
				+ ", investigatorAddressLineOne=" + investigatorAddressLineOne + ", investigatorAddressLineTwo=" + investigatorAddressLineTwo 
				+ ", Provinces=" + provinces + ", townAddressLineFour=" + townAddressLineFour + ", contactNo=" + contactNo 
				+ ", alternativeContactNo=" + alternativeContactNo + ", emailAddress=" + emailAddress + ", reportedInstitution=" + reportedInstitution + "]";
	}	
}
