package com.mashitatechnologies.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mashitatechnologies.model.Course;


public class CourseSerializer extends JsonSerializer<Course>{
	@Override
    public void serialize(Course course, JsonGenerator jsonGen,
            SerializerProvider serProv) throws IOException,
            JsonProcessingException {
		jsonGen.writeStartObject();
		jsonGen.writeNumberField("courseId", course.getCourseId());
        jsonGen.writeStringField("courseLevel", course.getCourseLevel());
        jsonGen.writeStringField("courseType", course.getCourseType());
        jsonGen.writeStringField("courseName", course.getCourseName());
		jsonGen.writeEndObject();
		
	}

}
