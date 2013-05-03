package org.myplay.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.myplay.entity.BaseEntityBean;

import java.util.Date;


/**
 * The persistent class for the master_data database table.
 * 
 */
@Entity
@Table(name="master_data")
public class MasterData extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	private int type;

	public MasterData() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}