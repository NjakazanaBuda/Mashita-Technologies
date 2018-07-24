package com.mashitatechnologies.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mashitatechnologies.helper.IDataEntity;
import com.mashitatechnologies.model.Provinces;


@Entity
@Table(name="institutions")
public class Institution implements IDataEntity,java.io.Serializable {

	private static final long serialVersionUID = -3437213505204650224L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "institution_id", unique = true, nullable = false)
	private Long institutionId;
	
	@Column(name = "institution_type_id", nullable = false)
	private Long institutionType;
	
	@Column(name = "institution_name", nullable = false)
	private String institutionName;
	
	@Column(name = "insttitution_address_line1", nullable = false)
	private String insttitutionAddressLineOne;
	
	@Column(name = "insttitution_address_line2", nullable = false)
	private String insttitutionAddressLineTwo;
	
	@ManyToOne
	@JoinColumn(name = "province_id", nullable = true)
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
	
	@Column(name = "accreditation_number", nullable = false)
	private String accreditationNumber;
	
	@Column(name = "accreditation_start_date", nullable = true)
	private String accreditationStartDate;
	
	@Column(name = "accreditation_end_date", nullable = true)
	private String accreditationEndDate;
	
	@Column(name = "isactive", nullable = true)
	private String isactive;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="courses_institutions", joinColumns= {@JoinColumn(name="institution_id")},  inverseJoinColumns= {@JoinColumn(name="course_id")})
	private Set<Course> courses;
	
	public Long getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	public Long getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(Long institutionType) {
		this.institutionType = institutionType;
	}
	
	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}


	public String getInsttitutionAddressLineOne() {
		return insttitutionAddressLineOne;
	}

	public void setInsttitutionAddressLineOne(String insttitutionAddressLineOne) {
		this.insttitutionAddressLineOne = insttitutionAddressLineOne;
	}
	
	public String getInsttitutionAddressLineTwo() {
		return insttitutionAddressLineTwo;
	}

	public void setInsttitutionAddressLineTwo(String insttitutionAddressLineTwo) {
		this.insttitutionAddressLineTwo = insttitutionAddressLineTwo;
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
	
	public String getAccreditationNumber() {
		return accreditationNumber;
	}

	public void setAccreditationNumber(String accreditationNumber) {
		this.accreditationNumber = accreditationNumber;
	}

	public String getAccreditationStartDate() {
		return accreditationStartDate;
	}

	public void setAccreditationStartDate(String accreditationStartDate) {
		this.accreditationStartDate = accreditationStartDate;
	}
	
	public String getAccreditationEndDate() {
		return accreditationEndDate;
	}

	public void setAccreditationEndDate(String accreditationEndDate) {
		this.accreditationEndDate = accreditationEndDate;
	}
	
	
	public String getIsActive() {
		return isactive;
	}

	public void setIsActive(String isactive) {
		this.isactive = isactive;
	}

	
	public Provinces getProvinces() {
		return provinces;
	}

	public void setProvinces(Provinces provinces) {
		this.provinces = provinces;
	}
	
	public Set getCourses() {
		   return courses;
		    }
	public void setCourses(Set courses) {
		this.courses = courses;
		    }

	@Override
	public String toString() {
		return "Institutions [institutionId=" + institutionId + ", institutionType=" + institutionType + ", insttitutionAddressLineOne=" + insttitutionAddressLineOne
				+ ", insttitutionAddressLineTwo=" + insttitutionAddressLineTwo + ", contactNo=" + contactNo + ", alternativeContactNo=" + alternativeContactNo
				+ ", emailAddress=" + emailAddress + ", accreditationNumber=" + accreditationNumber + ", accreditationStartDate="
				+ accreditationStartDate + ", accreditationEndDate=" + accreditationEndDate + ", Provinces=" + provinces + ", townAddressLineFour="
				+ townAddressLineFour + ", institutionName=" + institutionName + ", courses=" + courses + ", isactive=" + isactive + "]";
	} 
	
}
