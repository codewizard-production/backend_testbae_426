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

@Entity(name = "Agent")
@Table(name = "\"Agent\"", schema =  "\"testbae\"")
@Data
                        
public class Agent {
	public Agent () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"AgentID\"", nullable = true )
  private Integer agentID;
	  
  @Column(name = "\"Name\"", nullable = true )
  private String name;
  
	  
  @Column(name = "\"ContactNumber\"", nullable = true )
  private String contactNumber;
  
	  
  @Column(name = "\"Address\"", nullable = true )
  private String address;
  
	  
	
	@Column(name = "\"LoanTypes\"")
	@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(schema = "\"testbae\"", name = "\"AgentLoanTypes\"",joinColumns = @JoinColumn(name = "\"AgentID\""))
    @Convert(converter = LoanTypeConverter.class)
    private List<LoanType> loanTypes = new ArrayList<>();
	  
  @Column(name = "\"AadhaarNumber\"", nullable = true )
  private String aadhaarNumber;
  
	  
  @Column(name = "\"AadhaarStatus\"", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = AadhaarStatusConverter.class)
  private AadhaarStatus aadhaarStatus;
  
	  
  @Column(name = "\"IsApproved\"", nullable = true )
  private Boolean isApproved;
  
	  
  @Column(name = "\"Attribute1\"", nullable = true )
  private String attribute1;
  
	  
  @Column(name = "\"Attribute2\"", nullable = true )
  private String attribute2;
  
	  
  @Column(name = "\"CreatedDate\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date createdDate;  
  
  
  
  
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"AgentAgentUser\"", referencedColumnName = "\"UserName\"", insertable = false, updatable = false)
	private User agentUser;
	
	@Column(name = "\"AgentAgentUser\"")
	private String agentAgentUser;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"AgentPhoto\"", referencedColumnName = "\"DocId\"", insertable = false, updatable = false)
	private Document photo;
	
	@Column(name = "\"AgentPhoto\"")
	private Integer agentPhoto;
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"AgentLeads\"",
            joinColumns = @JoinColumn( name="\"AgentID\""),
            inverseJoinColumns = @JoinColumn( name="\"LeadId\""), schema = "\"testbae\"")
private List<Lead> leads = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"AgentKYCDocs\"",
            joinColumns = @JoinColumn( name="\"AgentID\""),
            inverseJoinColumns = @JoinColumn( name="\"DocId\""), schema = "\"testbae\"")
private List<Document> kYCDocs = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Agent [" 
  + "AgentID= " + agentID  + ", " 
  + "Name= " + name  + ", " 
  + "ContactNumber= " + contactNumber  + ", " 
  + "Address= " + address  + ", " 
  + "LoanTypes= " + loanTypes  + ", " 
  + "AadhaarNumber= " + aadhaarNumber  + ", " 
  + "AadhaarStatus= " + aadhaarStatus  + ", " 
  + "IsApproved= " + isApproved  + ", " 
  + "Attribute1= " + attribute1  + ", " 
  + "Attribute2= " + attribute2  + ", " 
  + "CreatedDate= " + createdDate 
 + "]";
	}
	
}