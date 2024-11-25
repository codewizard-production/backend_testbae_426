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

@Entity(name = "Incentive")
@Table(name = "\"Incentive\"", schema =  "\"testbae\"")
@Data
                        
public class Incentive {
	public Incentive () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"IncentiveId\"", nullable = true )
  private Integer incentiveId;
	  
  @Column(name = "\"Amount\"", nullable = true )
  private Double amount;
  
	  
  @Column(name = "\"CreatedDate\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date createdDate;  
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Incentive [" 
  + "IncentiveId= " + incentiveId  + ", " 
  + "Amount= " + amount  + ", " 
  + "CreatedDate= " + createdDate 
 + "]";
	}
	
}