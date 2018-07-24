package com.mashitatechnologies.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mashitatechnologies.model.City;

public class CitySerializer extends JsonSerializer<City>{
	
	public CitySerializer() {
        this(null);
    }
   
    public CitySerializer(Class<City> c) {
        super();
    }
    
    @Override
    public void serialize(
      City city, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
    	
    	

  
       jgen.writeStartObject();
        jgen.writeNumberField("cityId", city.getCityId());
       jgen.writeStringField("cityName", city.getCityName());
       jgen.writeNumberField("cityProvince", city.getProvinces().getProvinceId());
        jgen.writeEndObject();
    }

}
