package org.myplay.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.myplay.entity.BaseEntityBean;

import java.util.Date;


/**
 * The persistent class for the assign database table.
 * 
 */
@Entity
public class Assign extends BaseEntityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String abnormalReason;

	private int abnormalType;

	private String applyID;

	private int assignDealType;

	private int assignerID;

	private int assignPlaceID;

	private String carID;

	private String checkContents;

	private int checkStatus;

	private String combinedID;

	private int currentState;

	private String driverID;

	private int driverIDEx;

	private float endCarCharge;

	private float endCarDistance;

	private float endCarOverTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endCarTime;

	private String endtime; 

	private float endUserDistance;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endUserTime;

	private int isCombined;

	private int isConfirm;

	private int isDisp;

	private int isDocument;

	private int isFinished;

	private int isGroupAssign;

	private int isPrinted;

	private int isSingle;

	private int modifierID;

	private int modifytime;

	private String observeContens;

	private int observerID;

	private String serialID;

	private float startCarDistance;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startCarTime;

	private String starttime;

	private float startUserDistance;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startUserTime;

	private int status;

	private int taskID;

	private int userStatus;

	public Assign() {
	}

	public String getAbnormalReason() {
		return this.abnormalReason;
	}

	public void setAbnormalReason(String abnormalReason) {
		this.abnormalReason = abnormalReason;
	}

	public int getAbnormalType() {
		return this.abnormalType;
	}

	public void setAbnormalType(int abnormalType) {
		this.abnormalType = abnormalType;
	}

	public String getApplyID() {
		return this.applyID;
	}

	public void setApplyID(String applyID) {
		this.applyID = applyID;
	}

	public int getAssignDealType() {
		return this.assignDealType;
	}

	public void setAssignDealType(int assignDealType) {
		this.assignDealType = assignDealType;
	}

	public int getAssignerID() {
		return this.assignerID;
	}

	public void setAssignerID(int assignerID) {
		this.assignerID = assignerID;
	}

	public int getAssignPlaceID() {
		return this.assignPlaceID;
	}

	public void setAssignPlaceID(int assignPlaceID) {
		this.assignPlaceID = assignPlaceID;
	}

	public String getCarID() {
		return this.carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getCheckContents() {
		return this.checkContents;
	}

	public void setCheckContents(String checkContents) {
		this.checkContents = checkContents;
	}

	public int getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(int checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getCombinedID() {
		return this.combinedID;
	}

	public void setCombinedID(String combinedID) {
		this.combinedID = combinedID;
	}


	public int getCurrentState() {
		return this.currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	public String getDriverID() {
		return this.driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	public int getDriverIDEx() {
		return this.driverIDEx;
	}

	public void setDriverIDEx(int driverIDEx) {
		this.driverIDEx = driverIDEx;
	}

	public float getEndCarCharge() {
		return this.endCarCharge;
	}

	public void setEndCarCharge(float endCarCharge) {
		this.endCarCharge = endCarCharge;
	}

	public float getEndCarDistance() {
		return this.endCarDistance;
	}

	public void setEndCarDistance(float endCarDistance) {
		this.endCarDistance = endCarDistance;
	}

	public float getEndCarOverTime() {
		return this.endCarOverTime;
	}

	public void setEndCarOverTime(float endCarOverTime) {
		this.endCarOverTime = endCarOverTime;
	}

	public Date getEndCarTime() {
		return this.endCarTime;
	}

	public void setEndCarTime(Date endCarTime) {
		this.endCarTime = endCarTime;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public float getEndUserDistance() {
		return this.endUserDistance;
	}

	public void setEndUserDistance(float endUserDistance) {
		this.endUserDistance = endUserDistance;
	}

	public Date getEndUserTime() {
		return this.endUserTime;
	}

	public void setEndUserTime(Date endUserTime) {
		this.endUserTime = endUserTime;
	}

	public int getIsCombined() {
		return this.isCombined;
	}

	public void setIsCombined(int isCombined) {
		this.isCombined = isCombined;
	}

	public int getIsConfirm() {
		return this.isConfirm;
	}

	public void setIsConfirm(int isConfirm) {
		this.isConfirm = isConfirm;
	}

	public int getIsDisp() {
		return this.isDisp;
	}

	public void setIsDisp(int isDisp) {
		this.isDisp = isDisp;
	}

	public int getIsDocument() {
		return this.isDocument;
	}

	public void setIsDocument(int isDocument) {
		this.isDocument = isDocument;
	}

	public int getIsFinished() {
		return this.isFinished;
	}

	public void setIsFinished(int isFinished) {
		this.isFinished = isFinished;
	}

	public int getIsGroupAssign() {
		return this.isGroupAssign;
	}

	public void setIsGroupAssign(int isGroupAssign) {
		this.isGroupAssign = isGroupAssign;
	}

	public int getIsPrinted() {
		return this.isPrinted;
	}

	public void setIsPrinted(int isPrinted) {
		this.isPrinted = isPrinted;
	}

	public int getIsSingle() {
		return this.isSingle;
	}

	public void setIsSingle(int isSingle) {
		this.isSingle = isSingle;
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

	public String getObserveContens() {
		return this.observeContens;
	}

	public void setObserveContens(String observeContens) {
		this.observeContens = observeContens;
	}

	public int getObserverID() {
		return this.observerID;
	}

	public void setObserverID(int observerID) {
		this.observerID = observerID;
	}

	public String getSerialID() {
		return this.serialID;
	}

	public void setSerialID(String serialID) {
		this.serialID = serialID;
	}

	public float getStartCarDistance() {
		return this.startCarDistance;
	}

	public void setStartCarDistance(float startCarDistance) {
		this.startCarDistance = startCarDistance;
	}

	public Date getStartCarTime() {
		return this.startCarTime;
	}

	public void setStartCarTime(Date startCarTime) {
		this.startCarTime = startCarTime;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public float getStartUserDistance() {
		return this.startUserDistance;
	}

	public void setStartUserDistance(float startUserDistance) {
		this.startUserDistance = startUserDistance;
	}

	public Date getStartUserTime() {
		return this.startUserTime;
	}

	public void setStartUserTime(Date startUserTime) {
		this.startUserTime = startUserTime;
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


	public int getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

}