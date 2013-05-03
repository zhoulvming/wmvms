package org.myplay.entity;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Unit entity. @author MyEclipse Persistence Tools
 */
//@Entity
//@Table(name = "ng_unit")
public class Unit implements java.io.Serializable {
	
	// Fields
	
	private String unitCode;
	private String unitName;
	private String convCode;
	private String convRatio;
	
	// Constructors
	
	/** default constructor */
	public Unit() {
	}
	
	/** minimal constructor */
	public Unit(String unitCode) {
		this.unitCode = unitCode;
	}
	
	/** full constructor */
	public Unit(String unitCode, String unitName, String convCode, String convRatio) {
		this.unitCode = unitCode;
		this.unitName = unitName;
		this.convCode = convCode;
		this.convRatio = convRatio;
	}
	
	// Property accessors
	@Id
	@Column(name = "UNIT_CODE", unique = true, nullable = false, length = 36)
	public String getUnitCode() {
		return this.unitCode;
	}
	
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	
	@Column(name = "UNIT_NAME", length = 36)
	public String getUnitName() {
		return this.unitName;
	}
	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	@Column(name = "CONV_CODE", length = 36)
	public String getConvCode() {
		return this.convCode;
	}
	
	public void setConvCode(String convCode) {
		this.convCode = convCode;
	}
	
	@Column(name = "CONV_RATIO", length = 36)
	public String getConvRatio() {
		return this.convRatio;
	}
	
	public void setConvRatio(String convRatio) {
		this.convRatio = convRatio;
	}
	
}