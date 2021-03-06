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
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mashitatechnologies.helper.IDataEntity;

import com.mashitatechnologies.serializer.CourseSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize(using = CourseSerializer.class)
@Table(name="courses")
public class Course implements IDataEntity {
	
	private static final long serialVersionUID = -5220518862515051558L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_id", unique = true, nullable = false)
	private Long courseId;
	
	@Column(name = "course_level", nullable = false)
    private String courseLevel;
	
	@Column(name = "course_type", nullable = false)
	private String courseType;
	
	@Column(name = "course_name", nullable = false)
	private String courseName;
	
	//@Column(name = "accreditation_number", nullable = true)
	//private String accreditationNumber;
	
	//@ManyToMany(mappedBy="courses")
	//private Set<Institution> institutions;
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="courses_institutions", joinColumns= {@JoinColumn(name="course_id")},  inverseJoinColumns= {@JoinColumn(name="institution_id")})
	@JsonIgnore
	private Set<Institution> institutions;

	
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	//public String getAccreditationNumber() {
		//return accreditationNumber;
	//}

	//public void setAccreditationNumber(String accreditationNumber) {
		//this.accreditationNumber = accreditationNumber;
	//}
	
	
	public Set getInstitutions() {
		        return institutions;
	}

	public void setInstitutions(Set institutions) {
		      this.institutions = institutions;
		    }


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseType=" + courseType + ", courseName=" + courseName + ", courseLevel=" + courseLevel
				+ ", institutions=" + institutions + "]";
	}
}
