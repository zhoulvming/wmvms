/*
 * Created on 2004-12-10
 */
package org.myplay.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.myplay.entity.ColumnBean;


/**
 * 
 * @author elgs
 * 
 */

public class SQLHelper {

	private static List<List<Object>> getMatrix(ResultSet rs, boolean header) throws SQLException {
		List<List<Object>> ret = new ArrayList<List<Object>>();
		ResultSetMetaData meta = rs.getMetaData();
		int cols = meta.getColumnCount();

		List<Object> headers = new ArrayList<Object>();
		for (int i = 1; i <= cols; ++i) {
			ColumnBean cb = new ColumnBean();
			cb.setDataIndex(String.valueOf(i));
			cb.setText(meta.getColumnLabel(i));
			headers.add(cb);
		}
		if (header) {
			ret.add(headers);
		}
		rs.beforeFirst();

		while (rs.next()) {
			List<Object> data = new ArrayList<Object>();
			for (int j = 0; j < cols; ++j) {
				data.add(rs.getObject(j + 1));
			}
			ret.add(data);
		}
		return ret;
	}

	public static List<List<Object>> getData(Connection conn, String sql, boolean header) throws SQLException {
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = st.executeQuery(sql);
		return getMatrix(rs, header);
	}
}
