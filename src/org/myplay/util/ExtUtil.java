package org.myplay.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.myplay.entity.ColumnBean;
import org.myplay.entity.DomainProperties;
import org.myplay.entity.JsonResult;


@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class ExtUtil {
	static Logger log = Logger.getLogger(ExtUtil.class);

	static String SQL_T = "_T_";
	static String SQL_F = "_F_";
	static String SQL_V = "_V_";
	static String SQL_S = ",";
	// static String SQL_Q = "'";Is_confirm parent_node

	static String SQL_REPLACE = "REPLACE INTO cls_pre_classes (_F_,Is_confirm,parent_node)VALUES(_V_,true,'-');";

	public static String update(Map<Integer, String> column, List<Map<Integer, Object>> values, Connection conn) throws SQLException {
		/**
		 * column <excel columnindex,db column name> <br>
		 * values<Map<excel columnindex,vaalue> >
		 */
		int i = 1;

		StringBuffer sqlBuffer = new StringBuffer(0);
		String temp = null;
		List<Integer> indexs = new ArrayList<Integer>(0);
		StringBuffer errors = new StringBuffer(0);

		indexs.addAll(column.keySet());
		Collections.sort(indexs);
		Map<Integer, Integer> tm = new HashMap<Integer, Integer>(0);

		for (Integer index : indexs) {
			sqlBuffer.append(column.get(index)).append(",");
			tm.put(i, index);
			i++;
		}
		sqlBuffer.append("GUID");

		// log.info(sqlBuffer);
		// log.info(tm.keySet().size());
		temp = SQL_REPLACE.replaceAll(SQL_F, sqlBuffer.toString());

		if (indexs.get(0) != 0)
			Collections.sort(indexs);
		Statement st;

		st = conn.createStatement();
		i = 1;
		errors.append("'");
		String tmp = "";
		try {
			for (Map<Integer, Object> m : values) {
				sqlBuffer.delete(0, sqlBuffer.length());
				for (Integer index : indexs) {
					tmp = (null == m.get(index) ? "" : m.get(index).toString());
					if (tmp.contains("'")) {
						log.info(tmp.contains("'") + tmp);
						tmp = tmp.replace("'", "''");

					}
					sqlBuffer.append("'").append(tmp).append("',");
				}

				sqlBuffer.append("'").append(UUID.randomUUID()).append("'");
				st.addBatch(temp.replace(SQL_V, sqlBuffer).replace("null", ""));

				st.executeBatch();
				st.clearBatch();

				i++;
			}
			errors.append("'");
		} catch (Exception e) {
			log.info(temp.replace(SQL_V, sqlBuffer).replace("null", ""));
			// log.error(e);
			errors.append(i + 1).append(",");
		} finally {
			if (st != null)
				st.close();
		}

		log.info(errors);
		return errors.toString();

	}

	/**
	 * 
	 * @param cells
	 *            put table columns
	 * @param table
	 *            tableName
	 * @param conn
	 *            connection
	 * @return
	 * @throws Exception
	 */
	public static Set<String> dbColumns(Set<String> cells, String tableName, Connection conn) throws Exception {
		if (null == conn) {
			return cells;
		}
		DatabaseMetaData dmd = conn.getMetaData();
		java.sql.ResultSet rs = dmd.getColumns(null, "%", tableName, "%");
		while (rs.next()) {
			cells.add(rs.getString("COLUMN_NAME").trim().toUpperCase());
		}
		if (rs != null)
			rs.close();
		return cells;
	}

	/**
	 * 
	 * 获取 excel 中的一个sheet
	 * 
	 * @param index
	 *            start with 0
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static Sheet sheet(int index, String path) throws InvalidFormatException, IOException {
		File xlsf = new File(path);
		if (!xlsf.exists())
			return null;
		InputStream is = new FileInputStream(xlsf);
		Workbook wb = WorkbookFactory.create(is);

		if (wb.getNumberOfSheets() < 1)
			return null;

		return wb.getSheetAt(index);

	}

	/**
	 * 
	 * 获取 excel 中的一个sheet
	 * 
	 * @param index
	 *            start with 0
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static Sheet sheet(int index, InputStream inputStream) throws InvalidFormatException, IOException {
		Workbook wb = WorkbookFactory.create(inputStream);

		if (wb.getNumberOfSheets() < 1)
			return null;

		return wb.getSheetAt(index);
	}

	public static void filterColumns(Row row, Map<Integer, String> map, Set<String> set) {
		// TODO Auto-generated method stub
		String cellValue = null;
		int k = 0, i = 0;
		k = row.getLastCellNum();
		for (i = 0; i < k; i++) {
			cellValue = (null == row.getCell(i) ? "" : row.getCell(i).toString().trim());
			cellValue = cellValue.toUpperCase().trim();
			if (!set.contains(cellValue))
				continue;
			map.put(i, cellValue);
			if (k - i == 1)
				continue;
		}

		// log.info("filterColumns \r\n\t" + sqlBuffer);
	}

	public static void fillColumns(Set<Integer> indexs, Iterator<Row> iters, List<Map<Integer, Object>> values) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#");
		Object value = null;
		Row row = null;
		int k = 0;
		Map<Integer, Object> map = null;
		while (iters.hasNext()) {
			map = new HashMap<Integer, Object>(0);
			row = iters.next();
			if (null == row)
				continue;
			for (Cell cell : row) {
				k = cell.getColumnIndex();
				if (!indexs.contains(k))
					continue;
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					value = cell.getBooleanCellValue();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					// 先看是否是日期格式
					if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
						value = cell.getDateCellValue();
					} else {
						value = df.format(cell.getNumericCellValue());
					}
					break;
				case Cell.CELL_TYPE_FORMULA:
					// 读取公式
					// System.out.print(cell.getCellFormula() + " ");
					value = cell.getCellFormula();
					break;
				case Cell.CELL_TYPE_STRING:
					// 读取String
					// System.out.print(cell.getRichStringCellValue().toString()
					// + " ");
					value = cell.getRichStringCellValue();
					break;
				default:
					value = "";
				}

				map.put(k, null == value ? "" : value);
			}
			if (map.values().size() == 0)
				continue;
			values.add(map);

		}

	}

	public static int getColumnIndex(List<ColumnBean> cols, String colName) {
		log.debug(colName);
		for (int cnt = 0; cnt < cols.size(); cnt++) {
			if (colName.equals(cols.get(cnt).getText()))
				return cnt;
		}
		return -1;
	}

	public static int getDataIndex(List<ColumnBean> cols, String colName) {
		for (int cnt = 0; cnt < cols.size(); cnt++) {
			if (colName.equals(cols.get(cnt).getDataIndex()))
				return cnt;
		}
		return -1;
	}

	// 内存分页
	public static JsonResult<List<Object>> capturePage(JsonResult<List<Object>> jr, int start, int limit) throws Exception {
		JsonResult<List<Object>> ret = (JsonResult<List<Object>>) jr.clone();
		List<List<Object>> root = (List)jr.getRoot();
		int rootSize = root.size();
		ret.setTotal(rootSize);

		Collection<List<Object>> newRoot = new ArrayList<List<Object>>();
		for (int i = 0; i < limit; ++i) {
			int index = start + i;
			if (index > rootSize - 1) {
				break;
			}
			
			List<Object> lo = root.get(index);
			newRoot.add(lo);
		}
		ret.setRoot(newRoot);
		return ret;
	}

	// 一行数据+一个表头 =>Map
	public static Map<String, Object> getMapFromList(List<Map<String, Object>> columns, List<Object> row) {
		Map<String, Object> rowMap = new LinkedHashMap<String, Object>();
		for (int i = 0; i < columns.size(); ++i) {
			String key = (String) columns.get(i).get("text");
			Object value = row.get(i);
			rowMap.put(StringUtilEx.safeReplace(key, true), value);
		}
		return rowMap;
	}

	public static Map<String, Object> getMapByColumns(List<ColumnBean> retColumns, List<Object> calculatedRow) {
		Map<String, Object> rowMap = new LinkedHashMap<String, Object>();
		int counter = 0;
		for (ColumnBean col : retColumns) {
			String key = col.getText();
			Object value = calculatedRow.get(counter);

			rowMap.put(StringUtilEx.safeReplace(key, true), value);
			counter++;
		}
		return rowMap;
	}

	public static List<Object> getListFromMap(Map map) {
		List<Object> list = new ArrayList<Object>();
		for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {
			list.add(iterator.next());
		}
		return list;
	}

	// generate columns by domain properties
	// name == 0: visible = false; name == 1: visible = true;
	public static List<ColumnBean> genColumns(Map<String, DomainProperties> compiledMap) {
		List<ColumnBean> retColumns = new ArrayList<ColumnBean>();
		for (String dest : compiledMap.keySet()) {
			ColumnBean c = new ColumnBean();
			c.setDataIndex(dest);
			c.setText(dest);
			c.setHidden("0".equals(compiledMap.get(dest).getName()));
			retColumns.add(c);
		}
		return retColumns;
	}

	/**
	 * 
	 * @param obj
	 * @param annotation
	 *            是否使用注解中的字段（数据库字段）
	 * @param strings
	 *            实体对象中不需要取值的属性
	 * @return 实体如下<br>
	 *         {HS_CODE='8536500000', OWNER_CODE='1105940402',
	 *         ORIGIN_COUNTRY='意大利', TRADE_CODE='1105940402'}<br>
	 *         {originCountry='意大利', ownerCode='1105940402',
	 *         tradeCode='1105940402', hsCode='8536500000'}
	 * @throws Exception
	 */
	public static Map<String, Object> obj2map(Object obj, boolean annotation, String... strings) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>(0);
		Class<? extends Object> userClass = obj.getClass();
		Field[] fields = userClass.getDeclaredFields();
		String fildname = null;
		Method metd = null;
		StringBuffer buffer = new StringBuffer();
		Object value = null;
		Map<String, String> mpc = new HashMap<String, String>(0);
		mpc.putAll(annotation(obj.getClass()));
		for (Field field : fields) {
			fildname = field.getName();
			if (Arrays.asList(strings).contains(fildname))
				continue;
			metd = userClass.getMethod("get" + StringUtilEx.charChange(fildname, true, 1), new Class[] {});
			value = metd.invoke(obj, new Object[] {});
			if (null == value)
				continue;
			if ("".equals(value))
				continue;
			if (field.getType().getName().equals(Date.class.getName())) {
				buffer.delete(0, buffer.length());
				buffer.append("'");
				buffer.append(DateUtil.formatDate((java.util.Date) value, "yyyy-MM-dd hh:mm:ss"));
				buffer.append("'");
			}
			if (field.getType().getName().equals(String.class.getName())) {
				buffer.delete(0, buffer.length());
				buffer.append("'");
				buffer.append(value);
				buffer.append("'");
			}
			if (annotation) {
				fildname = fildname.trim().toLowerCase();
				map.put(mpc.get(fildname), buffer.toString());
				// log.info(fildname + "\t" + mpc.get(fildname) + "\t" +
				// buffer.toString());
			} else {
				map.put(fildname, buffer.toString());
			}
			buffer.delete(0, buffer.length());
		}
		mpc.clear();
		return map;
	}

	/**
	 * 
	 * @param cls
	 *            实体对象
	 * @return 实体对象中属性对应数据库字段 <br>
	 *         eg: map like pono=PO_NO
	 */
	public static Map<String, String> annotation(Class<?> cls) {
		Method[] ms = cls.getMethods();
		Map<String, String> map = new HashMap<String, String>(0);
		String tmp = null;
		for (Method m : ms) {
			if (!m.isAnnotationPresent(Column.class))
				continue;
			tmp = m.getName();
			if (null == tmp)
				continue;
			if (!tmp.startsWith("get"))
				continue;
			tmp = tmp.trim().toLowerCase().substring(3);
			map.put(tmp, m.getAnnotation(Column.class).name());
		}

		return map;

	}

}
