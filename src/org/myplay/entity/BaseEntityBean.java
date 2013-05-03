package org.myplay.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseEntityBean {

	@GridColumn(text = "ID", seq = 1, hidden = true)
	@Id
	protected String id;
	public boolean isNew() {
		return (this.id == null||"".equals(this.id));
	}

	public String getId() {
		return id;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorCode() {
		return creatorCode;
	}

	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	}

	public String getUpdatorId() {
		return updatorId;
	}

	public void setUpdatorId(String updatorId) {
		this.updatorId = updatorId;
	}

	public String getUpdatorCode() {
		return updatorCode;
	}

	public void setUpdatorCode(String updatorCode) {
		this.updatorCode = updatorCode;
	}

	public void setId(String id) {
		this.id = id;
	}

//	@Column(name = "CREATOR_ID", nullable = false)
	private String creatorId;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

//	@Column(name = "CREATOR_CODE", nullable = false)
	private String creatorCode;
//	@Column(name = "CREATE_TIME", nullable = false)
	private Date createTime;
//	@Column(name = "UPDATOR_ID", nullable = false)
	private String updatorId;
//	@Column(name = "UPDATOR_CODE", nullable = false)
	private String updatorCode;

	// @GridColumn(text = "更新时间", seq = 7, hidden = false)
//	@Column(name = "UPDATE_TIME", nullable = false)
	private Date updateTime;
//	@Column(name = "DELETE_FLAG", nullable = false)
//	@GridColumn(text = "状态", seq = 3, hidden = false,searchable=true,renderer="function(value,metaData,record,row,col,store,gridView){return value==0?'有效':'无效';}")
	private int deleteFlag;

}
