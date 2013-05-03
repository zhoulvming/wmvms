package org.myplay.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NgImportFileHeader entity. @author MyEclipse Persistence Tools
 */
//@Entity
//@Table(name = "ng_import_file_header")
public class NgImportFileHeader implements java.io.Serializable {

	// Fields    

	private String id;
	private String fileId;
	private String colName;
	private String dataIndex;
	private Integer seq;
	private Timestamp createTime;
	private String userId;

	// Constructors

	/** default constructor */
	public NgImportFileHeader() {
	}

	/** minimal constructor */
	public NgImportFileHeader(String id) {
		this.id = id;
	}

	/** full constructor */
	public NgImportFileHeader(String id, String fileId, String colName, String dataIndex, Integer seq,
			Timestamp createTime, String userId) {
		this.id = id;
		this.fileId = fileId;
		this.colName = colName;
		this.dataIndex = dataIndex;
		this.seq = seq;
		this.createTime = createTime;
		this.userId = userId;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "FILE_ID", length = 36)
	public String getFileId() {
		return this.fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Column(name = "COL_NAME", length = 300)
	public String getColName() {
		return this.colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	@Column(name = "DATA_INDEX", length = 20)
	public String getDataIndex() {
		return this.dataIndex;
	}

	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
	}

	@Column(name = "SEQ")
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name = "CREATE_TIME", length = 0)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "USER_ID", length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}