package com.app.testbae.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum AadhaarStatus{
	    SUCCESS,
	    FAILED,
	    SELF_KYC,
	    PENDING; 
    public int value(AadhaarStatus aadhaarStatus) {
        return aadhaarStatus.ordinal();
    }
    public static AadhaarStatus getAadhaarStatus(int ordinal) {
        for(AadhaarStatus aadhaarStatus : AadhaarStatus.values())
                if(aadhaarStatus.ordinal() == ordinal)
                        return aadhaarStatus;
        return null;
    }
}


