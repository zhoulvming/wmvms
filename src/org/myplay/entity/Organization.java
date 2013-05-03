package org.myplay.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The persistent class for the organization_ database table.
 * 
 */
@Entity
@Table(name = "organization_")
public class Organization extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigInteger companyId;

	private BigInteger countryId;
	@GridColumn(text = "名称", seq = 3, hidden = false, searchable = true)
	private String name;
	@Lob
	@GridColumn(text = "描述", seq = 3, hidden = false, searchable = false)
	private String comments;
//	private BigInteger parentOrganizationId;
//	@OneToMany(mappedBy="parentOrg",cascade={CascadeType.PERSIST} ,fetch=FetchType.LAZY)  
//	private java.util.List<Organization> childOrgs;// 下级机构,双向关联子对象
//	
//	public java.util.List<Organization> getChildOrgs() {
//		return childOrgs;
//	}
//
//	public void setChildOrgs(java.util.List<Organization> childOrgs) {
//		this.childOrgs = childOrgs;
//	}
//	@ManyToOne  
//	@JoinColumn(name="parentOrganizationId") 
//	private Organization parentOrg;// 上级机构,双向关联父对象
//	@JsonIgnore
//	public Organization getParentOrg() {
//		return parentOrg;
//	}
//	public void setParentOrg(Organization parentOrg) {
//		this.parentOrg = parentOrg;
//	}

	
//	@Transient
//	@GridColumn(text = "上级结构名称", seq = 3, hidden = false, searchable = false)
//	private String parentOrgName="";
//	@JsonIgnore
//	public String getParentOrgName() {
//		return parentOrgName;
////		return parentOrg.getName();
//	}
//
//	public void setParentOrgName(String parentOrgName) {
//		this.parentOrgName = parentOrgName;
//	}
	private byte recursable;
	
	private BigInteger regionId;

	private int statusId;

	@Lob
	private String treePath;
//	 0 地区 1 机构 2 部门
	@Column(name = "type_")
	private String type;

	private String parentOrganizationId;

	public Organization() {
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BigInteger getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(BigInteger companyId) {
		this.companyId = companyId;
	}

	public BigInteger getCountryId() {
		return this.countryId;
	}

	public void setCountryId(BigInteger countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentOrganizationId() {
		return this.parentOrganizationId;
	}

	public void setParentOrganizationId(String parentOrganizationId) {
		this.parentOrganizationId = parentOrganizationId;
	}

	public byte getRecursable() {
		return this.recursable;
	}

	public void setRecursable(byte recursable) {
		this.recursable = recursable;
	}

	public BigInteger getRegionId() {
		return this.regionId;
	}

	public void setRegionId(BigInteger regionId) {
		this.regionId = regionId;
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getTreePath() {
		return this.treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}