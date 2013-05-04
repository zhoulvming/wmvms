package org.myplay.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.myplay.entity.BaseEntityBean;

import java.util.Date;


/**
 * The persistent class for the task_type database table.
 * 
 */
@Entity
@Table(name="task_type")
public class TaskType extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;


	private String reason;
	
	private String parentID;


	public TaskType() {
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	

}