package org.myplay.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.myplay.entity.BaseEntityBean;

import java.util.Date;


/**
 * The persistent class for the apply database table.
 * 
 */
@Entity
public class Apply extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String addition;

	private int applierID;

	private int applyType;

	private int appstatus;

	private int apptype;

	private String assignedCarID;

	private int assignedDriverID;

	private int buildtime;

	private int carTypeID;

	private int changeable;

	private float contactMobile;

	private String departMentID;
	
	private int couserID;

	private int dealpersonID;

	private int dealType;

	private int delayToTime;
	
	private String destination;

	//用车单位表关联
    @OneToOne(optional=false,cascade={CascadeType.ALL})  
    @JoinColumn(name="DepartMentID")
    private Organization org;
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	
	//车型表关联
    @OneToOne(optional=false,cascade={CascadeType.ALL})  
    @JoinColumn(name="CarTypeID")
    private CarModel carModel;
	public CarModel getCarModel() {
		return carModel;
	}
	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}
	
	@Transient
	private String carTypeName;
	public String getCarTypeName() {
		return carModel.getCarModel();
	}
	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}	
	
	@GridColumn(text = "申请单号", seq = 1, hidden = false,searchable=true)
	private String serialID;
	
	@Transient
	@GridColumn(text = "用车单位", seq = 2, hidden = false,searchable=true)
	private String departmentName;
	public String getDepartmentName() {
		return org.getName();
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@GridColumn(text = "用车事由", seq = 4, hidden = false,searchable=true)
	private int applykind;
	
	@GridColumn(text = "用车人", seq = 5, hidden = false,searchable=true)
	private String contactPerson;
	
	@GridColumn(text = "上车时间", seq = 6, hidden = false,searchable=true)
	private String starttime;

	//@GridColumn(text = "状态", seq = 7, hidden = false,searchable=true)
	private int status;
	
	@Transient
	@GridColumn(text = "状态", seq = 7, hidden = false,searchable=true)
	private String applyStatus;
	public String getApplyStatus() {
		String retVal = "";
		if (this.status == 0) {
			retVal = "未调度";
		} else if (this.status == 1) {
			retVal = "已调度";
		} else if (this.status == 2) {
			retVal = "已调度/无法满足";
		} else if (this.status == 3) {
			retVal = "调度中/锁定";
		} else if (this.status == 4) {
			retVal = "已撤销";
		}
		return retVal;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}	
	
	@Transient
	@GridColumn(text = "申请人", seq = 7, hidden = false,searchable=true)
	private String applyUserId; 

	private int destType;

	private String endtime;

	private int isAlreadyDel;

	private int isDelayed;

	private int isDocument;

	private int isLock;

	//@GridColumn(text = "是否出省", seq = 8, hidden = false,searchable=true)
	private int isOutProvince;
	
	@Transient
	@GridColumn(text = "是否出省", seq = 8, hidden = false,searchable=true)
	private String isOutProvinceVal;
	public String getIsOutProvinceVal() {
		return this.isOutProvince==0?"否":"是";
	}
	public void setIsOutProvinceVal(String isOutProvinceVal) {
		this.isOutProvinceVal = isOutProvinceVal;
	}

	private int isover;

	private int isReturn;

	private int isUnion;

	private int isValid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date locktime;

	private int modifierID;

	private int modifytime;

	private String passAddr;

	private int realpeoplenum;

	private String reason;

	private String startAddre;


	private int taskID;

	private int usualAddrID;

	public Apply() {
	}

	public String getAddition() {
		return this.addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}

	public int getApplierID() {
		return this.applierID;
	}

	public void setApplierID(int applierID) {
		this.applierID = applierID;
	}

	public int getApplykind() {
		return this.applykind;
	}

	public void setApplykind(int applykind) {
		this.applykind = applykind;
	}

	public int getApplyType() {
		return this.applyType;
	}

	public void setApplyType(int applyType) {
		this.applyType = applyType;
	}

	public int getAppstatus() {
		return this.appstatus;
	}

	public void setAppstatus(int appstatus) {
		this.appstatus = appstatus;
	}

	public int getApptype() {
		return this.apptype;
	}

	public void setApptype(int apptype) {
		this.apptype = apptype;
	}

	public String getAssignedCarID() {
		return this.assignedCarID;
	}

	public void setAssignedCarID(String assignedCarID) {
		this.assignedCarID = assignedCarID;
	}

	public int getAssignedDriverID() {
		return this.assignedDriverID;
	}

	public void setAssignedDriverID(int assignedDriverID) {
		this.assignedDriverID = assignedDriverID;
	}

	public int getBuildtime() {
		return this.buildtime;
	}

	public void setBuildtime(int buildtime) {
		this.buildtime = buildtime;
	}

	public int getCarTypeID() {
		return this.carTypeID;
	}

	public void setCarTypeID(int carTypeID) {
		this.carTypeID = carTypeID;
	}

	public int getChangeable() {
		return this.changeable;
	}

	public void setChangeable(int changeable) {
		this.changeable = changeable;
	}

	public float getContactMobile() {
		return this.contactMobile;
	}

	public void setContactMobile(float contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public int getCouserID() {
		return this.couserID;
	}

	public void setCouserID(int couserID) {
		this.couserID = couserID;
	}

	public int getDealpersonID() {
		return this.dealpersonID;
	}

	public void setDealpersonID(int dealpersonID) {
		this.dealpersonID = dealpersonID;
	}

	public int getDealType() {
		return this.dealType;
	}

	public void setDealType(int dealType) {
		this.dealType = dealType;
	}

	public int getDelayToTime() {
		return this.delayToTime;
	}

	public void setDelayToTime(int delayToTime) {
		this.delayToTime = delayToTime;
	}
	
	public String getDepartMentID() {
		return this.departMentID;
	}

	public void setDepartMentID(String departMentID) {
		this.departMentID = departMentID;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDestType() {
		return this.destType;
	}

	public void setDestType(int destType) {
		this.destType = destType;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public int getIsAlreadyDel() {
		return this.isAlreadyDel;
	}

	public void setIsAlreadyDel(int isAlreadyDel) {
		this.isAlreadyDel = isAlreadyDel;
	}

	public int getIsDelayed() {
		return this.isDelayed;
	}

	public void setIsDelayed(int isDelayed) {
		this.isDelayed = isDelayed;
	}

	public int getIsDocument() {
		return this.isDocument;
	}

	public void setIsDocument(int isDocument) {
		this.isDocument = isDocument;
	}

	public int getIsLock() {
		return this.isLock;
	}

	public void setIsLock(int isLock) {
		this.isLock = isLock;
	}

	public int getIsOutProvince() {
		return this.isOutProvince;
	}

	public void setIsOutProvince(int isOutProvince) {
		this.isOutProvince = isOutProvince;
	}

	public int getIsover() {
		return this.isover;
	}

	public void setIsover(int isover) {
		this.isover = isover;
	}

	public int getIsReturn() {
		return this.isReturn;
	}

	public void setIsReturn(int isReturn) {
		this.isReturn = isReturn;
	}

	public int getIsUnion() {
		return this.isUnion;
	}

	public void setIsUnion(int isUnion) {
		this.isUnion = isUnion;
	}

	public int getIsValid() {
		return this.isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	public Date getLocktime() {
		return this.locktime;
	}

	public void setLocktime(Date locktime) {
		this.locktime = locktime;
	}

	public int getModifierID() {
		return this.modifierID;
	}

	public void setModifierID(int modifierID) {
		this.modifierID = modifierID;
	}

	public int getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(int modifytime) {
		this.modifytime = modifytime;
	}

	public String getPassAddr() {
		return this.passAddr;
	}

	public void setPassAddr(String passAddr) {
		this.passAddr = passAddr;
	}

	public int getRealpeoplenum() {
		return this.realpeoplenum;
	}

	public void setRealpeoplenum(int realpeoplenum) {
		this.realpeoplenum = realpeoplenum;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSerialID() {
		return this.serialID;
	}

	public void setSerialID(String serialID) {
		this.serialID = serialID;
	}

	public String getStartAddre() {
		return this.startAddre;
	}

	public void setStartAddre(String startAddre) {
		this.startAddre = startAddre;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTaskID() {
		return this.taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public int getUsualAddrID() {
		return this.usualAddrID;
	}

	public void setUsualAddrID(int usualAddrID) {
		this.usualAddrID = usualAddrID;
	}
	
	public String getApplyUserId() {
		return super.getCreatorCode();
	}
	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}

}