package com.app.testbae.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
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
import com.app.testbae.converter.DurationConverter;
import com.app.testbae.converter.UUIDToByteConverter;
import com.app.testbae.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "Lead")
@Table(name = "\"Lead\"", schema =  "\"testbae\"")
@Data
                        
public class Lead {
	public Lead () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"LeadId\"", nullable = true )
  private Integer leadId;
	  
  @Column(name = "\"ContactNumber\"", nullable = true )
  private String contactNumber;
  
	  
  @Column(name = "\"Name\"", nullable = true )
  private String name;
  
	  
  @Column(name = "\"Address\"", nullable = true )
  private String address;
  
	  
  @Column(name = "\"LoanType\"", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = LoanTypeConverter.class)
  private LoanType loanType;
  
	  
  @Column(name = "\"Attribute1\"", nullable = true )
  private String attribute1;
  
	  
  @Column(name = "\"Attribute2\"", nullable = true )
  private String attribute2;
  
	  
  @Column(name = "\"CreatedDate\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date createdDate;  
  
	  
  @Column(name = "\"ConversionStatus\"", nullable = true )
  private Boolean conversionStatus;
  
	  
  @Column(name = "\"SalesAmount\"", nullable = true )
  private Double salesAmount;
  
  
  
  
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"LeadGeneratedBy\"", referencedColumnName = "\"AgentID\"", insertable = false, updatable = false)
	private Agent generatedBy;
	
	@Column(name = "\"LeadGeneratedBy\"")
	private Integer leadGeneratedBy;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"LeadAssignedExecutive\"", referencedColumnName = "\"ExecId\"", insertable = false, updatable = false)
	private SalesExecutive assignedExecutive;
	
	@Column(name = "\"LeadAssignedExecutive\"")
	private Integer leadAssignedExecutive;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"LeadAgentIncentive\"", referencedColumnName = "\"IncentiveId\"", insertable = false, updatable = false)
	private Incentive agentIncentive;
	
	@Column(name = "\"LeadAgentIncentive\"")
	private Integer leadAgentIncentive;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"LeadSEExecIncentive\"", referencedColumnName = "\"IncentiveSEId\"", insertable = false, updatable = false)
	private IncentiveSEExec sEExecIncentive;
	
	@Column(name = "\"LeadSEExecIncentive\"")
	private Integer leadSEExecIncentive;
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Lead [" 
  + "LeadId= " + leadId  + ", " 
  + "ContactNumber= " + contactNumber  + ", " 
  + "Name= " + name  + ", " 
  + "Address= " + address  + ", " 
  + "LoanType= " + loanType  + ", " 
  + "Attribute1= " + attribute1  + ", " 
  + "Attribute2= " + attribute2  + ", " 
  + "CreatedDate= " + createdDate  + ", " 
  + "ConversionStatus= " + conversionStatus  + ", " 
  + "SalesAmount= " + salesAmount 
 + "]";
	}
	
}