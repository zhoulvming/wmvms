package org.myplay.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author elgs
 * 
 */
@XmlRootElement
public class ColumnBean {

	public static class ColumnType {
		public static final String COLUMN_ACTION = "actioncolumn";
		public static final String COLUMN_GRID = "gridcolumn";
		public static final String COLUMN_NUMBER = "numbercolumn";
		public static final String COLUMN_DATE = "datecolumn";
		public static final String COLUMN_BOOLEAN = "booleancolumn";
	}

	public static class ColumnEditor {
		public static final String EDITOR_TEXTFIELD = "textfield";
		public static final String EDITOR_TEXTAREA = "textarea";
		public static final String EDITOR_TIMEFIELD = "timefield";
		public static final String EDITOR_DATEFIELD = "datefield";
		public static final String EDITOR_NUMBERFIELD = "numberfield";
		public static final String EDITOR_CHECKBOX = "checkbox";
		public static final String EDITOR_COMBO = "combo";
	}

	private String xtype = ColumnBean.ColumnType.COLUMN_GRID;
	private int width = 80;
	private String dataIndex;
	private String text;
	private String format;
	private String editor = ColumnBean.ColumnEditor.EDITOR_TEXTFIELD;
	private boolean hidden = false;
	private boolean searchable;
	
	private String renderer;

	public String getRenderer() {
		return renderer;
	}

	public void setRenderer(String renderer) {
		this.renderer = renderer;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getXtype() {
		return xtype;
	}

	public void setXtype(String xtype) {
		this.xtype = xtype;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getDataIndex() {
		return dataIndex;
	}

	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
