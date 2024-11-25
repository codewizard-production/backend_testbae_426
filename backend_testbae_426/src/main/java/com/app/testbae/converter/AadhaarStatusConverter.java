package com.app.testbae.converter;

import com.app.testbae.enums.AadhaarStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class AadhaarStatusConverter implements AttributeConverter<AadhaarStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AadhaarStatus aadhaarStatus) {
        return aadhaarStatus != null ? aadhaarStatus.ordinal() : null;
    }

    @Override
    public AadhaarStatus convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return AadhaarStatus.getAadhaarStatus(dbData);
    }
}
