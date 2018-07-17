package com.mashitatechnologies.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mashitatechnologies.helper.AbstractDAO;
import com.mashitatechnologies.helper.AbstractDataProvider;
import com.mashitatechnologies.helper.MySQLProvider;
import com.mashitatechnologies.model.CourseLevel;

public class CourseLevelDAO extends AbstractDAO {
	
	private static final long serialVersionUID = -3L;
	
	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createCourseLevel(CourseLevel courselevel) throws Exception {
		super.create(courselevel);
		return "CourseLevel has been added successfully";
	}
	
	public CourseLevel findCourseById(Long course_level_id) throws Exception {
		String query = "select o from CourseLevel o where o.courseLevelId =:course_level_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("course_level_id", course_level_id);
		return (CourseLevel)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateCourseLevel(CourseLevel courselevel) throws Exception  {
		if((findCourseById(courselevel.getCourseLevelId())) != null) {
			super.update(courselevel);
			return true;
		} else {
			throw new Exception("Error: Course Level Not found");
		}
	}
	
	public boolean removeCourseLevel(CourseLevel courselevel) throws Exception  {
		if((findCourseById(courselevel.getCourseLevelId())) != null) {
			super.update(courselevel);
			return true;
		} else {
			throw new Exception("Error: Course Level Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CourseLevel> getAllCourses() throws Exception {
		return (List<CourseLevel>)super.getList("select o from CourseLevel o ");
	}

}
