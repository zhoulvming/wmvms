package org.myplay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClsCountryMapping entity. @author MyEclipse Persistence Tools
 */
//@Entity
//@Table(name = "cls_country_mapping")
public class ComboCountry implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -6609495262661869762L;
	// private String countryNameEn;

	private String name;

	private String code;

	private Short id;

	@Column(name = "COUNTRY_NAME_CN", nullable = false, length = 12)
	public String getName() {
		return name;
	}

	@Column(name = "ISO_CODE", nullable = false, length = 2)
	public String getCode() {
		return code;
	}

	@Id
	@Column(name = "CUSTOMS_CODE", nullable = false)
	public Short getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(Short id) {
		this.id = id;
	}

}