package org.myplay.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the department_struc database table.
 * 
 */
@Entity
@Table(name="department_struc")
public class DepartmentStruc extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String applyDepartID;

	private String dispatchDepartID;

	public DepartmentStruc() {
	}

	public String getApplyDepartID() {
		return this.applyDepartID;
	}

	public void setApplyDepartID(String applyDepartID) {
		this.applyDepartID = applyDepartID;
	}

	public String getDispatchDepartID() {
		return this.dispatchDepartID;
	}

	public void setDispatchDepartID(String dispatchDepartID) {
		this.dispatchDepartID = dispatchDepartID;
	}

}