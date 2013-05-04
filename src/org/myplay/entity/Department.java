package org.myplay.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.myplay.entity.BaseEntityBean;

import java.util.Date;


/**
 * The persistent class for the department database table.
 * 
 */
@Entity
public class Department extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int departLevel;

	private int departType;

	private String des;

	private int parentID;
	
//	private Apply apply;
//	
//    @OneToOne(mappedBy="department",cascade={CascadeType.REFRESH,CascadeType.MERGE,CascadeType.REFRESH})  
//	public Apply getApply() {
//		return apply;
//	}
//
//	public void setApply(Apply apply) {
//		this.apply = apply;
//	}


	public Department() {
	}


	public int getDepartLevel() {
		return this.departLevel;
	}

	public void setDepartLevel(int departLevel) {
		this.departLevel = departLevel;
	}

	public int getDepartType() {
		return this.departType;
	}

	public void setDepartType(int departType) {
		this.departType = departType;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getParentID() {
		return this.parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}


}