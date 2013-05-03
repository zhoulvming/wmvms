package org.myplay.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.si.core.ui.GridColumn;

//@Entity
//@Table(name = "channel_configuration")
//@XmlRootElement
public class TimeServiceBean {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	@GridColumn(text = "名称", seq = 10, width = 160)
	private String name;

	@Column(name = "type")
	@GridColumn(text = "类型", seq = 20)
	private String type;

	@Column(name = "jobId")
	private String jobId;

	@Column(name = "startTime")
	@GridColumn(text = "开始时间", seq = 30, format = "Y-m-d H:i:s", xtype = ColumnBean.ColumnType.COLUMN_DATE, width = 120)
	private Date startTime;

	@Column(name = "endTime")
	@GridColumn(text = "结束时间", seq = 40, format = "Y-m-d H:i:s", xtype = ColumnBean.ColumnType.COLUMN_DATE, width = 120)
	private Date endTime;

	@Column(name = "_interval")
	@GridColumn(text = "间隔", xtype = ColumnBean.ColumnType.COLUMN_NUMBER, type = FieldBean.FieldType.TYPE_INT, seq = 50)
	private Integer interval;

	@Column(name = "_count")
	@GridColumn(text = "次数", xtype = ColumnBean.ColumnType.COLUMN_NUMBER, type = FieldBean.FieldType.TYPE_INT, seq = 60)
	private Integer count;

	@Column(name = "cronExpress")
	@GridColumn(text = "CRON表达式", seq = 70)
	private String cronExpress;

	@Column(name = "autoStart")
	@GridColumn(text = "启动方式", seq = 80)
	private String autoStart;

	@Column(name = "jobName")
	@GridColumn(text = "任务名称", seq = 90, width = 200)
	private String jobName;

	@Column(name = "className")
	@GridColumn(text = "任务类型", seq = 100, width = 200)
	private String className;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getCronExpress() {
		return cronExpress;
	}

	public void setCronExpress(String cronExpress) {
		this.cronExpress = cronExpress;
	}

	public String getAutoStart() {
		return autoStart;
	}

	public void setAutoStart(String autoStart) {
		this.autoStart = autoStart;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
