package com.mashitatechnologies.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mashitatechnologies.model.Institution;

public class InstitutionSerializer extends JsonSerializer<Institution>{
	
	public static final SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-mm-dd");
	
	@Override
    public void serialize(Institution institution, JsonGenerator jsonGen,
            SerializerProvider serProv) throws IOException,
            JsonProcessingException {
		if (institution == null)
		{
				jsonGen.writeNull();
		}else
		{
        jsonGen.writeStartObject();
        jsonGen.writeNumberField("institutionId", institution.getInstitutionId());
        jsonGen.writeStringField("institutionType", institution.getInstitutionType());
        jsonGen.writeStringField("institutionName", institution.getInstitutionName());
        jsonGen.writeStringField("insttitutionAddressLineOne", institution.getInsttitutionAddressLineOne());
        jsonGen.writeStringField("insttitutionAddressLineTwo", institution.getInsttitutionAddressLineTwo());
        jsonGen.writeStringField("townAddressLineFour", institution.getTownAddressLineFour());
        jsonGen.writeNumberField("contactNo", institution.getContactNo());
        jsonGen.writeNumberField("alternativeContactNo", institution.getAlternativeContactNo());
        jsonGen.writeStringField("emailAddress", institution.getEmailAddress());
        jsonGen.writeStringField("accreditationNumber", institution.getAccreditationNumber());
        jsonGen.writeStringField("accreditationStartDate", dateformatter.format(institution.getAccreditationStartDate()));
        jsonGen.writeStringField("accreditationEndDate", dateformatter.format(institution.getAccreditationEndDate()));
        jsonGen.writeStringField("isActive", institution.getIsActive());
        jsonGen.writeEndObject();
		}

    }

}
