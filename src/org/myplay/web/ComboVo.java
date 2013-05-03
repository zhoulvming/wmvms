package org.myplay.web;

public class ComboVo {
	public ComboVo() {
		super();
	}
	String id;
	String text;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ComboVo(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

}
