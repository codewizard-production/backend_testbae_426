package com.app.testbae.converter;

import com.app.testbae.enums.LoanType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class LoanTypeConverter implements AttributeConverter<LoanType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(LoanType loanType) {
        return loanType != null ? loanType.ordinal() : null;
    }

    @Override
    public LoanType convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return LoanType.getLoanType(dbData);
    }
}
