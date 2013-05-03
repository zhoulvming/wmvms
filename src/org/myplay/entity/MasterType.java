package org.myplay.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.myplay.entity.BaseEntityBean;

import java.util.Date;


/**
 * The persistent class for the master_type database table.
 * 
 */
@Entity
@Table(name="master_type")
public class MasterType extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;


	private String name;


	public MasterType() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



}