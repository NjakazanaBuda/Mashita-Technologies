package com.mashitatechnologies.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mashitatechnologies.constants.CourseURIConstants;
import com.mashitatechnologies.dao.CourseDAO;
import com.mashitatechnologies.model.Course;

/**
 * Handles requests for the User service.
 */
@Controller
public class CourseController {
	
	private CourseDAO courseDAO = new CourseDAO();
	
	@RequestMapping(value = CourseURIConstants.GET_ALL_COURSES, method = RequestMethod.GET)
	public @ResponseBody List<Course> getAllCourses() {
		List<Course> allCourses = new ArrayList<Course>();
		try {
			allCourses = courseDAO.getAllCourses();
			return allCourses;
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allCourses;
	}
	
	@RequestMapping(value = CourseURIConstants.CREATE_COURSE, method = RequestMethod.POST)
	public @ResponseBody String createCourse(@RequestBody Course course) {
		try {
			return courseDAO.createCourse(course);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = CourseURIConstants.UPDATE_COURSE, method = RequestMethod.PUT)
	public @ResponseBody boolean updateCourse(@RequestBody Course course) {
		try {
			return courseDAO.updateCourse(course);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@RequestMapping(value = CourseURIConstants.REMOVE_COURSE, method = RequestMethod.DELETE)
	public @ResponseBody boolean removeCourse(@RequestBody Course course) {
		try {
			return courseDAO.removeCourse(course);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = CourseURIConstants.GET_ALL_COURSES_BY_COURSE_ID, method = RequestMethod.GET)
	public @ResponseBody List<Course> getAllContactsByInstitutionID(@PathVariable("courseId") Long course_id) {
		List<Course> allCourses = new ArrayList<Course>();
		try {
			allCourses = courseDAO.getAllCoursesByCourseId(course_id);
			return allCourses;
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allCourses;
	}
	
}
