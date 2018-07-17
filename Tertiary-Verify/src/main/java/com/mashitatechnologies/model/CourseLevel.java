package com.mashitatechnologies.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mashitatechnologies.helper.IDataEntity;

@Entity
@Table(name="course_level")
public class CourseLevel implements IDataEntity {
	
	private static final long serialVersionUID = -2L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_level_id", unique = true, nullable = false)
	private Long courseLevelId;
	
	@Column(name = "course_level", nullable = false)
	private String courseLevel;
	
	public Long getCourseLevelId() {
		return courseLevelId;
	}

	public void setCourseLevelId(Long courseLevelId) {
		this.courseLevelId = courseLevelId;
	}

	public String getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}
	
	@Override
	public String toString() {
		return "Course Level [courseLevelId=" + courseLevelId + ", courseLevel=" + courseLevel + "]";
	} 

}
