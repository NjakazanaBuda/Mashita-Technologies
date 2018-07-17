package com.mashitatechnologies.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

import com.mashitatechnologies.helper.IDataEntity;

@Entity
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
	
	@Column(name = "course_code", nullable = true)
	private String courseCode;
	
	@ManyToMany(mappedBy="courses")
	//private Set institutions = new HashSet();
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

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
	public Set getInstitutions() {
		        return institutions;
	}

	public void setInstitutions(Set institutions) {
		      this.institutions = institutions;
		    }


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseType=" + courseType + ", courseName=" + courseName + ", courseLevel=" + courseLevel
				+ ", courseCode=" + courseCode + ", institutions=" + institutions + "]";
	}
}
