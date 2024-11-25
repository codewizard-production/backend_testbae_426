package com.app.testbae.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

import com.app.testbae.model.Lead;
import com.app.testbae.model.Incentive;
import com.app.testbae.model.SalesExecutive;
import com.app.testbae.model.User;
import com.app.testbae.model.HOUser;
import com.app.testbae.model.IncentiveSEExec;
import com.app.testbae.model.Document;
import com.app.testbae.model.Agent;
import com.app.testbae.enums.AadhaarStatus;
import com.app.testbae.enums.LoanType;
import com.app.testbae.converter.LoanTypeConverter;
import com.app.testbae.converter.AadhaarStatusConverter;

@Entity(name = "SalesExecutiveSELeads")
@Table(schema = "\"testbae\"", name = "\"SalesExecutiveSELeads\"")
@Data
public class SalesExecutiveSELeads{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"ExecId\"")
	private Integer execId;

    
    @Column(name = "\"LeadId\"")
    private Integer leadId;
 
}