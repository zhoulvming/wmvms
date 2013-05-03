package org.myplay.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.myplay.entity.BaseEntityBean;

import java.util.Date;


/**
 * The persistent class for the usual_place database table.
 * 
 */
@Entity
@Table(name="usual_place")
public class UsualPlace extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String des;

	public UsualPlace() {
	}


	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}