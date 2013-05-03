package org.myplay.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the car_model database table.
 * 
 */
@Entity
@Table(name = "car_model")
public class CarModel extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@GridColumn(text = "车型", seq = 1, hidden = false, searchable = true)
	private String carModel;

	@GridColumn(text = "人数", seq = 1, hidden = false, searchable = false)
	private int carry;

	private int checkTime;

	private int type_;

	public int getType_() {
		return type_;
	}

	public void setType_(int type_) {
		this.type_ = type_;
	}

	public CarModel() {
	}

	public String getCarModel() {
		return this.carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarry() {
		return this.carry;
	}

	public void setCarry(int carry) {
		this.carry = carry;
	}

	public int getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(int checkTime) {
		this.checkTime = checkTime;
	}

}