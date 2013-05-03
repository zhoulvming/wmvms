package org.myplay.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The persistent class for the role_ database table.
 * 
 */
@Entity
@Table(name = "role_")
public class Role extends SimpleBaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<User>();

	private BigInteger classNameId;

	private BigInteger classPK;

	private BigInteger companyId;
	@GridColumn(text = "名称", seq = 4, hidden = false, searchable = true)
	private String name;

	private String subtype;

	@Lob
	private String title;

	@Column(name = "type_")
	private int type;

	public Role() {
	}

	public BigInteger getClassNameId() {
		return this.classNameId;
	}

	public void setClassNameId(BigInteger classNameId) {
		this.classNameId = classNameId;
	}

	public BigInteger getClassPK() {
		return this.classPK;
	}

	public void setClassPK(BigInteger classPK) {
		this.classPK = classPK;
	}

	public BigInteger getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(BigInteger companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtype() {
		return this.subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}