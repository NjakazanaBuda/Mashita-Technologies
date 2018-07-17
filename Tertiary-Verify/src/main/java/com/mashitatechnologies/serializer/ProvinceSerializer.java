package com.mashitatechnologies.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mashitatechnologies.model.Provinces;


public class ProvinceSerializer extends JsonSerializer<Provinces> {
	@Override
    public void serialize(Provinces province, JsonGenerator jsonGen,
            SerializerProvider serProv) throws IOException,
            JsonProcessingException {
		
        jsonGen.writeStartObject();
        jsonGen.writeNumberField("provinceId", province.getProvinceId());
        jsonGen.writeStringField("provinceName", province.getProvinceName());
        jsonGen.writeStringField("provinceAbbriation", province.getProvinceAbbriation());
        jsonGen.writeEndObject();

    }
}

