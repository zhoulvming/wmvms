package org.myplay.entity;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.TypeReference;


@XmlRootElement
public class JsonResult<T> implements Cloneable {
	public JsonResult() {

		super();

	}

	private T obj;
	private Collection<T> root;
	private List<ColumnBean> columns;
	private List<FieldBean> fields;
	private Map<String, Object> metaData = new LinkedHashMap<String, Object>();
	private boolean success = true;
	private Object message;
	private long total;

	
	
	public String output() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局
		return mapper.writeValueAsString(this);
		
		
	}
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public Map<String, Object> getMetaData() {
		return metaData;
	}

	public void setMetaMap(Map<String, Object> metaData) {
		this.metaData = metaData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.si.entity.IJsonResult#build()
	 */
	public void build() {
		if (columns == null) {
			throw new IllegalStateException("Columns were not initialized.");
		}
		fields = new ArrayList<FieldBean>();

		for (ColumnBean col : columns) {
			FieldBean f = new FieldBean();
			f.setName(col.getDataIndex());
			if (col.getXtype() == ColumnBean.ColumnType.COLUMN_DATE) {
				f.setType(FieldBean.FieldType.TYPE_DATE);
			}
			fields.add(f);

		}
	}

	@SuppressWarnings("unchecked")
	public void buildSelfSeq(Class clazz) {
		// clazz=this.clazz;
		Map<Integer, ColumnBean> tm = new TreeMap<Integer, ColumnBean>();
		columns = new ArrayList<ColumnBean>();
		fields = new ArrayList<FieldBean>();

		List<Field> selfDf = Arrays.asList(clazz.getDeclaredFields());

		for (Field field : selfDf) {
			GridColumn col;
			// check if field has annotation
			if ((col = field.getAnnotation(GridColumn.class)) != null) {
				ColumnBean c = new ColumnBean();
				c.setDataIndex(field.getName());
				c.setText(col.text());
				c.setWidth(col.width());
				c.setXtype(col.xtype());
				c.setFormat(col.format());
				c.setEditor(col.editor());
				c.setHidden(col.hidden());

				tm.put(col.seq(), c);

				FieldBean f = new FieldBean();
				f.setName(field.getName());
				f.setType(col.type());
				f.setDateFormat(col.dateFormat());
				f.setDefaultValue(col.defaultValue());
				if (ColumnBean.ColumnType.COLUMN_DATE.equals(c.getXtype())) {
					f.setType(FieldBean.FieldType.TYPE_DATE);
				}
				fields.add(f);
			}
		}
		for (int i : tm.keySet()) {
			columns.add(tm.get(i));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.si.entity.IJsonResult#build(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public void build(Class clazz) {
		// clazz=this.clazz;
		Map<Integer, ColumnBean> tm = new TreeMap<Integer, ColumnBean>();
		columns = new ArrayList<ColumnBean>();
		fields = new ArrayList<FieldBean>();
		List<Field> df = new ArrayList();
		List<Field> superDf = Arrays.asList(clazz.getSuperclass()
				.getDeclaredFields());
		List<Field> selfDf = Arrays.asList(clazz.getDeclaredFields());
		// superdf.addAll(df);
		df.addAll(selfDf);
		df.addAll(superDf);

		

		// Arrays.asList(df)
		// Field[] fs=new
		// df.addAll(clazz.getSuperclass().getDeclaredFields());
		int index = 0;
		for (Field field : df) {
			GridColumn col;
			// check if field has annotation
			if ((col = field.getAnnotation(GridColumn.class)) != null) {
				ColumnBean c = new ColumnBean();
				c.setDataIndex(field.getName());
				c.setText(col.text());
				c.setWidth(col.width());
				c.setXtype(col.xtype());
				c.setFormat(col.format());
				c.setEditor(col.editor());
				c.setHidden(col.hidden());
				c.setSearchable(col.searchable());
				c.setRenderer(col.renderer());
				// tm.put(col.seq(), c);
				tm.put(index, c);
				index++;
				FieldBean f = new FieldBean();
				f.setName(field.getName());
				f.setType(col.type());
				f.setDateFormat(col.dateFormat());
				f.setDefaultValue(col.defaultValue());
				if (ColumnBean.ColumnType.COLUMN_DATE.equals(c.getXtype())) {
					f.setType(FieldBean.FieldType.TYPE_DATE);
				}
				fields.add(f);
			}
		}
		for (int i : tm.keySet()) {
			columns.add(tm.get(i));
		}
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Collection<T> getRoot() {
		return root;
	}

	public void setRoot(Collection<T> list) {
		this.root = list;
	}

	public List<ColumnBean> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnBean> columns) {
		this.columns = columns;
	}

	public List<FieldBean> getFields() {
		return fields;
	}

	public void setFields(List<FieldBean> fields) {
		this.fields = fields;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public static <T> List<T> formList(String json, Class<T> clazz,
			TypeReference<List<T>> tr) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		if (json == null || json.length() == 0) {
			throw new IllegalArgumentException();
		}
		json = json.trim();
		List<T> us = null;
		if (json.startsWith("[")) {
			// this is a list
			us = mapper.readValue(json, tr);
		} else if (json.startsWith("{")) {
			// this is an object
			us = new ArrayList<T>();
			T u = mapper.readValue(json, clazz);
			us.add(u);
		}
		return us;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void buildSelf(Class clazz) {

		// clazz=this.clazz;
		Map<Integer, ColumnBean> tm = new TreeMap<Integer, ColumnBean>();
		columns = new ArrayList<ColumnBean>();
		fields = new ArrayList<FieldBean>();
		Field[] declaredFields = clazz.getDeclaredFields();
		// List<Field> selfDf = Arrays.asList(clazz.getDeclaredFields());

		int index = 0;
		for (Field field : declaredFields) {
			GridColumn col;
			// check if field has annotation
			if ((col = field.getAnnotation(GridColumn.class)) != null) {
				ColumnBean c = new ColumnBean();
				c.setDataIndex(field.getName());
				c.setText(col.text());
				c.setWidth(col.width());
				c.setXtype(col.xtype());
				c.setFormat(col.format());
				c.setEditor(col.editor());
				c.setHidden(col.hidden());

				// tm.put(col.seq(), c);
				tm.put(index, c);

				index++;

				FieldBean f = new FieldBean();
				f.setName(field.getName());
				f.setType(col.type());
				f.setDateFormat(col.dateFormat());
				f.setDefaultValue(col.defaultValue());
				if (ColumnBean.ColumnType.COLUMN_DATE.equals(c.getXtype())) {
					f.setType(FieldBean.FieldType.TYPE_DATE);
				}
				fields.add(f);
			}
		}
		for (int i : tm.keySet()) {
			columns.add(tm.get(i));
		}

	}

}