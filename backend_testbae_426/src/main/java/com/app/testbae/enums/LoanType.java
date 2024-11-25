package com.app.testbae.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum LoanType{
	    TWO_WHEELER_LOAN,
	    GOLD_LOAN,
	    PERSONAL_LOAN,
	    BUSINESS_LOAN; 
    public int value(LoanType loanType) {
        return loanType.ordinal();
    }
    public static LoanType getLoanType(int ordinal) {
        for(LoanType loanType : LoanType.values())
                if(loanType.ordinal() == ordinal)
                        return loanType;
        return null;
    }
}


