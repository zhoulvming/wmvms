package org.myplay.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PasswordCard entity.
 * 
 * @author MyEclipse Persistence Tools
 */
//@Entity
//@Table(name = "password_card", catalog = "km_mobile", uniqueConstraints = {})
public class PasswordCard implements java.io.Serializable {

	// Fields

	private Long id;
	private String code;
	private String content;
	private Date createDate;
	private Date printDate;
	private Date openDate;
	private String openerId;
	private String userId;
	private Integer status;

	// Constructors

	/** default constructor */
	public PasswordCard() {
	}



	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = true)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "CONTENT", unique = false, nullable = false, insertable = true, updatable = true, length = 192)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PRINT_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 0)
	public Date getPrintDate() {
		return this.printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OPEN_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public Date getOpenDate() {
		return this.openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	@Column(name = "OPENER_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 36)
	public String getOpenerId() {
		return this.openerId;
	}

	public void setOpenerId(String openerId) {
		this.openerId = openerId;
	}

	@Column(name = "USER_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "STATUS", unique = false, nullable = false, insertable = true, updatable = true)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}