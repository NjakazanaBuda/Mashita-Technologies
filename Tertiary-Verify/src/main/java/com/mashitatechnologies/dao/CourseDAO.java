package com.mashitatechnologies.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mashitatechnologies.helper.AbstractDAO;
import com.mashitatechnologies.helper.AbstractDataProvider;
import com.mashitatechnologies.helper.MySQLProvider;
import com.mashitatechnologies.model.Course;

public class CourseDAO extends AbstractDAO {

	private static final long serialVersionUID = -4488515122156815696L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createCourse(Course course) throws Exception {
		super.create(course);
		return "Course has been added successfully";
	}

	public Course findCourseById(Long course_id) throws Exception {
		String query = "select o from Course o where o.courseId =:course_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("course_id", course_id);
		return (Course)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateCourse(Course course) throws Exception  {
		if((findCourseById(course.getCourseId())) != null) {
			super.update(course);
			return true;
		} else {
			throw new Exception("Error: Course Not found");
		}
	}
	
	public boolean removeCourse(Course course) throws Exception  {
		if((findCourseById(course.getCourseId())) != null) {
			super.delete(course);
			return true;
		} else {
			throw new Exception("Error: Course Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> getAllCourses() throws Exception {
		return (List<Course>)super.getList("select o from Course o ");
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> getAllCoursesByCourseId(Long course_id) throws Exception {
		String query = "select o from Course o where o.courseId =:course_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("course_id", course_id);
		return (List<Course>)super.getList(query, parameters);
	}
}
