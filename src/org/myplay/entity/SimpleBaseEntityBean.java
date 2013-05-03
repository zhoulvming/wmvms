package org.myplay.entity;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SimpleBaseEntityBean {

	@GridColumn(text = "ID", seq = 1, hidden = true)
	@Id
	protected String id;
	@Lob
	protected String description;

	public boolean isNew() {
		return (this.id == null || "".equals(this.id));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@GridColumn(text = "状态", seq = 3, hidden = false,searchable=false,renderer="function(value) { return value=='0'? '有效':'无效'; }")
	private int deleteFlag;

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
