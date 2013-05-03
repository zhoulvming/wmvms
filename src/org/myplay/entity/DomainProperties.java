package org.myplay.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DomainProperties entity. @author MyEclipse Persistence Tools
 */
//@Entity
//@Table(name = "domain_properties")
//@XmlRootElement
public class DomainProperties implements java.io.Serializable {

	// Fields

	private String id;
	private String code;
	private String value;
	private String name;
	private String note;
	private Integer seq;
	private String domainCode;
	private String extValue1;
	private String extValue2;
	private String extValue3;
	private String extValue4;
	private String extValue5;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public DomainProperties() {
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "CODE", nullable = false, length = 100)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "VALUE", nullable = false, length = 200)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "NAME", nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NOTE", nullable = false, length = 1000)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "SEQ", nullable = false)
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name = "DOMAIN_CODE", nullable = false, length = 100)
	public String getDomainCode() {
		return this.domainCode;
	}

	public void setDomainCode(String domainCode) {
		this.domainCode = domainCode;
	}

	@Column(name = "EXT_VALUE1", nullable = false, length = 200)
	public String getExtValue1() {
		return this.extValue1;
	}

	public void setExtValue1(String extValue1) {
		this.extValue1 = extValue1;
	}

	@Column(name = "EXT_VALUE2", nullable = false, length = 200)
	public String getExtValue2() {
		return this.extValue2;
	}

	public void setExtValue2(String extValue2) {
		this.extValue2 = extValue2;
	}

	@Column(name = "EXT_VALUE3", nullable = false, length = 200)
	public String getExtValue3() {
		return this.extValue3;
	}

	public void setExtValue3(String extValue3) {
		this.extValue3 = extValue3;
	}

	@Column(name = "EXT_VALUE4", nullable = false)
	public String getExtValue4() {
		return this.extValue4;
	}

	public void setExtValue4(String extValue4) {
		this.extValue4 = extValue4;
	}

	@Column(name = "EXT_VALUE5", nullable = false)
	public String getExtValue5() {
		return this.extValue5;
	}

	public void setExtValue5(String extValue5) {
		this.extValue5 = extValue5;
	}
	
	@Column(name = "UPDATE_TIME", length = 0)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}
	
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}