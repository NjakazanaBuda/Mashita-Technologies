package com.mashitatechnologies.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mashitatechnologies.helper.AbstractDAO;
import com.mashitatechnologies.helper.AbstractDataProvider;
import com.mashitatechnologies.helper.MySQLProvider;
import com.mashitatechnologies.model.CourseType;

public class CourseTypeDAO extends AbstractDAO{
	
	private static final long serialVersionUID = -6L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createCourseType(CourseType courseType) throws Exception {
		super.create(courseType);
		return "CourseType has been added successfully";
	}

	public CourseType findCourseTypeById(Long course_type_id) throws Exception {
		String query = "from CourseType as ctp where ctp.courseId =:course_type_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("course_type_id", course_type_id);
		return (CourseType)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateCourseType(CourseType courseType) throws Exception  {
		if((findCourseTypeById(courseType.getCourseTypeId())) != null) {
			super.update(courseType);
			return true;
		} else {
			throw new Exception("Error: CourseType Not found");
		}
	}
	
	public boolean removeCourseType(CourseType courseType) throws Exception  {
		if((findCourseTypeById(courseType.getCourseTypeId())) != null) {
			super.delete(courseType);
			return true;
		} else {
			throw new Exception("Error: CourseType Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CourseType> getAllCoursesTypes() throws Exception {
		return (List<CourseType>)super.getList("from CourseType");
	}
	
	@SuppressWarnings("unchecked")
	public List<CourseType> getAllCoursesTypeByCourseTypeId(Long course_type_id) throws Exception {
		String query = "from CourseType as ctp where ctp.courseId =:course_type_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("course_type_id", course_type_id);
		return (List<CourseType>)super.getList(query, parameters);
	}

}
