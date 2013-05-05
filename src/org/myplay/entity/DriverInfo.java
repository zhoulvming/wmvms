package org.myplay.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.myplay.entity.BaseEntityBean;

import java.util.Date;


/**
 * The persistent class for the driver_info database table.
 * 
 */
@Entity
@Table(name="driver_info")
public class DriverInfo extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer assignPlaceID;

	private Integer attrID;

	private Integer belongsID;

	private Integer checkCardDate;

	private Integer contractTime;

	private String demmision;

	private Integer depaetmentID;

	private Integer educationTypeID;

	private String familyAddr;

	private Integer getCardDate;

	private String IDNum;

	private Integer isChecked;

	private Integer isImportant;

	private Integer isMarriage;

	private Integer isValid;

	private Integer kilometers;

	private String maincard;

	private String motoType;

	@GridColumn(text = "姓名", seq = 1, hidden = false, searchable=true)
	private String name;
	
	@GridColumn(text = "年龄", seq = 2, hidden = false, searchable=true)
	private Integer age;	

	private String papers;

	private String phoneNum;

	private Integer recordID;

	private String remark;

	private String secondCard;

	private Integer starLevel;

	private String stations;

	@GridColumn(text = "是否兼职", seq = 1, hidden = false, searchable=true)
	private Integer typeID;

	private Integer status;
	
	@Transient
	@GridColumn(text = "状态", seq = 2, hidden = false,searchable=true)
	private String driverStatus;
	public String getDriverStatus() {
		String retValue = "";
		if (this.status == 0) {
			retValue = "无单";
		} else if(this.status == 1) {
			retValue = "派车单执行中";
		} else if(this.status == 2) {
			retValue = "不可用";
		}
		return retValue;
	}
	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}	
	
	private String unValidDes;

	private Integer unValidTime;

	private Integer validdate;

	private String vehicleType;

	private Integer workRelation;

	public DriverInfo() {
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAssignPlaceID() {
		return this.assignPlaceID;
	}

	public void setAssignPlaceID(Integer assignPlaceID) {
		this.assignPlaceID = assignPlaceID;
	}

	public Integer getAttrID() {
		return this.attrID;
	}

	public void setAttrID(Integer attrID) {
		this.attrID = attrID;
	}

	public Integer getBelongsID() {
		return this.belongsID;
	}

	public void setBelongsID(Integer belongsID) {
		this.belongsID = belongsID;
	}

	public Integer getCheckCardDate() {
		return this.checkCardDate;
	}

	public void setCheckCardDate(Integer checkCardDate) {
		this.checkCardDate = checkCardDate;
	}

	public Integer getContractTime() {
		return this.contractTime;
	}

	public void setContractTime(Integer contractTime) {
		this.contractTime = contractTime;
	}

	public String getDemmision() {
		return this.demmision;
	}

	public void setDemmision(String demmision) {
		this.demmision = demmision;
	}

	public Integer getDepaetmentID() {
		return this.depaetmentID;
	}

	public void setDepaetmentID(Integer depaetmentID) {
		this.depaetmentID = depaetmentID;
	}

	public Integer getEducationTypeID() {
		return this.educationTypeID;
	}

	public void setEducationTypeID(Integer educationTypeID) {
		this.educationTypeID = educationTypeID;
	}

	public String getFamilyAddr() {
		return this.familyAddr;
	}

	public void setFamilyAddr(String familyAddr) {
		this.familyAddr = familyAddr;
	}

	public Integer getGetCardDate() {
		return this.getCardDate;
	}

	public void setGetCardDate(Integer getCardDate) {
		this.getCardDate = getCardDate;
	}

	public String getIDNum() {
		return this.IDNum;
	}

	public void setIDNum(String IDNum) {
		this.IDNum = IDNum;
	}

	public Integer getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(Integer isChecked) {
		this.isChecked = isChecked;
	}

	public Integer getIsImportant() {
		return this.isImportant;
	}

	public void setIsImportant(Integer isImportant) {
		this.isImportant = isImportant;
	}

	public Integer getIsMarriage() {
		return this.isMarriage;
	}

	public void setIsMarriage(Integer isMarriage) {
		this.isMarriage = isMarriage;
	}

	public Integer getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public Integer getKilometers() {
		return this.kilometers;
	}

	public void setKilometers(Integer kilometers) {
		this.kilometers = kilometers;
	}

	public String getMaincard() {
		return this.maincard;
	}

	public void setMaincard(String maincard) {
		this.maincard = maincard;
	}

	public String getMotoType() {
		return this.motoType;
	}

	public void setMotoType(String motoType) {
		this.motoType = motoType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPapers() {
		return this.papers;
	}

	public void setPapers(String papers) {
		this.papers = papers;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getRecordID() {
		return this.recordID;
	}

	public void setRecordID(Integer recordID) {
		this.recordID = recordID;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSecondCard() {
		return this.secondCard;
	}

	public void setSecondCard(String secondCard) {
		this.secondCard = secondCard;
	}

	public Integer getStarLevel() {
		return this.starLevel;
	}

	public void setStarLevel(Integer starLevel) {
		this.starLevel = starLevel;
	}

	public String getStations() {
		return this.stations;
	}

	public void setStations(String stations) {
		this.stations = stations;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTypeID() {
		return this.typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}

	public String getUnValidDes() {
		return this.unValidDes;
	}

	public void setUnValidDes(String unValidDes) {
		this.unValidDes = unValidDes;
	}

	public Integer getUnValidTime() {
		return this.unValidTime;
	}

	public void setUnValidTime(Integer unValidTime) {
		this.unValidTime = unValidTime;
	}

	public Integer getValiddate() {
		return this.validdate;
	}

	public void setValiddate(Integer validdate) {
		this.validdate = validdate;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Integer getWorkRelation() {
		return this.workRelation;
	}

	public void setWorkRelation(Integer workRelation) {
		this.workRelation = workRelation;
	}

}