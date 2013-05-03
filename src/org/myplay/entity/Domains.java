package org.myplay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.si.core.ui.GridColumn;

/**
 * Domains entity. @author MyEclipse Persistence Tools
 */
//@Entity
//@Table(name = "domains")
//@XmlRootElement
public class Domains implements java.io.Serializable {

	// Fields
	@GridColumn(text = "CODE", seq = 10)
	private String code;
	@GridColumn(text = "NAME", seq = 20)
	private String name;
	@GridColumn(text = "NOTE", seq = 30)
	private String note;

	// Constructors

	/** default constructor */
	public Domains() {
	}

	/** minimal constructor */
	public Domains(String code, String name) {
		this.code = code;
		this.name = name;
	}

	// Property accessors
	@Id
	@Column(name = "CODE", unique = true, nullable = false, length = 100)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NOTE", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}