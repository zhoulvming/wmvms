package org.myplay.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.myplay.entity.BaseEntityBean;

import java.util.Date;


/**
 * The persistent class for the car_info database table.
 * 
 */
@Entity
@Table(name="car_info")
public class CarInfo extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int assetsTypeID;

	private String assignPlaceID;

	private int carBrandID;

	@GridColumn(text = "车牌号", seq = 1, hidden = false,searchable=true)
	private String carNum;

	@GridColumn(text = "载重", seq = 3, hidden = false,searchable=true)
	private float carry;

	//车型表关联
    @OneToOne(optional=false,cascade={CascadeType.ALL})  
    @JoinColumn(name="ModelID")
    private CarModel carModel;
	public CarModel getCarModel() {
		return carModel;
	}
	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}   	

	@Transient
	@GridColumn(text = "车型", seq = 2, hidden = false,searchable=true)	
	private String carTypeName;
	public String getCarTypeName() {
		return carModel.getCarModel();
	}
	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}
	
	@GridColumn(text = "载人数", seq = 4, hidden = false,searchable=true)
	private int personCarry;
	
	@Transient
	@GridColumn(text = "状态", seq = 2, hidden = false,searchable=true)
	private String carStatus;
	public String getCarStatus() {
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
	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}	

	private int checkTime;

	private String departmentID;

	private int deviceID;

	private int driverID;

	private int endtime;

	private float gasCostPerMile;

	private float gasTankContains;

	private int gasTypeID;

	private int groupID;

	private int isChecked;

	private int isvalid;

	private int kilometers;

	private int maintainPerTimes;

	private String owner;

	private String papers;

	private String parkPlace;



	private String phoneNum;

	private String remark;

	private int repairNum;

	private float simNum;

	private int starttime;

	@OrderBy
	private int status;

	private String modelID;

	private int tyreDate;

	private String tyreType;

	private String unValidDes;

	private int unValidTime;

	private int workCharacter;

	public CarInfo() {
	}

	public int getAssetsTypeID() {
		return this.assetsTypeID;
	}

	public void setAssetsTypeID(int assetsTypeID) {
		this.assetsTypeID = assetsTypeID;
	}

	public String getAssignPlaceID() {
		return this.assignPlaceID;
	}

	public void setAssignPlaceID(String assignPlaceID) {
		this.assignPlaceID = assignPlaceID;
	}

	public int getCarBrandID() {
		return this.carBrandID;
	}

	public void setCarBrandID(int carBrandID) {
		this.carBrandID = carBrandID;
	}

	public String getCarNum() {
		return this.carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public float getCarry() {
		return this.carry;
	}

	public void setCarry(float carry) {
		this.carry = carry;
	}

	public int getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(int checkTime) {
		this.checkTime = checkTime;
	}

	public String getDepartmentID() {
		return this.departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public int getDeviceID() {
		return this.deviceID;
	}

	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}

	public int getDriverID() {
		return this.driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public int getEndtime() {
		return this.endtime;
	}

	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}

	public float getGasCostPerMile() {
		return this.gasCostPerMile;
	}

	public void setGasCostPerMile(float gasCostPerMile) {
		this.gasCostPerMile = gasCostPerMile;
	}

	public float getGasTankContains() {
		return this.gasTankContains;
	}

	public void setGasTankContains(float gasTankContains) {
		this.gasTankContains = gasTankContains;
	}

	public int getGasTypeID() {
		return this.gasTypeID;
	}

	public void setGasTypeID(int gasTypeID) {
		this.gasTypeID = gasTypeID;
	}

	public int getGroupID() {
		return this.groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
	}

	public int getIsvalid() {
		return this.isvalid;
	}

	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}

	public int getKilometers() {
		return this.kilometers;
	}

	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}

	public int getMaintainPerTimes() {
		return this.maintainPerTimes;
	}

	public void setMaintainPerTimes(int maintainPerTimes) {
		this.maintainPerTimes = maintainPerTimes;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPapers() {
		return this.papers;
	}

	public void setPapers(String papers) {
		this.papers = papers;
	}

	public String getParkPlace() {
		return this.parkPlace;
	}

	public void setParkPlace(String parkPlace) {
		this.parkPlace = parkPlace;
	}

	public int getPersonCarry() {
		return this.personCarry;
	}

	public void setPersonCarry(int personCarry) {
		this.personCarry = personCarry;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getRepairNum() {
		return this.repairNum;
	}

	public void setRepairNum(int repairNum) {
		this.repairNum = repairNum;
	}

	public float getSimNum() {
		return this.simNum;
	}

	public void setSimNum(float simNum) {
		this.simNum = simNum;
	}

	public int getStarttime() {
		return this.starttime;
	}

	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getModelID() {
		return this.modelID;
	}

	public void setModelID(String modelID) {
		this.modelID = modelID;
	}

	public int getTyreDate() {
		return this.tyreDate;
	}

	public void setTyreDate(int tyreDate) {
		this.tyreDate = tyreDate;
	}

	public String getTyreType() {
		return this.tyreType;
	}

	public void setTyreType(String tyreType) {
		this.tyreType = tyreType;
	}

	public String getUnValidDes() {
		return this.unValidDes;
	}

	public void setUnValidDes(String unValidDes) {
		this.unValidDes = unValidDes;
	}

	public int getUnValidTime() {
		return this.unValidTime;
	}

	public void setUnValidTime(int unValidTime) {
		this.unValidTime = unValidTime;
	}

	public int getWorkCharacter() {
		return this.workCharacter;
	}

	public void setWorkCharacter(int workCharacter) {
		this.workCharacter = workCharacter;
	}

}