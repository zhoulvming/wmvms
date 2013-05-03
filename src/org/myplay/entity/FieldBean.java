package org.myplay.entity;

public class FieldBean {

	public static class FieldType {
		public static final String TYPE_AUTO = "auto";
		public static final String TYPE_BOOLEAN = "boolean";
		public static final String TYPE_DATE = "date";
		public static final String TYPE_FLOAT = "float";
		public static final String TYPE_INT = "int";
		public static final String TYPE_STRING = "string";
	}

	private String dateFormat;
	private String name;
	private String type;
	private String defaultValue;

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
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

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

}
