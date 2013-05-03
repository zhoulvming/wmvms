package org.myplay.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itgodo.commons.conn.ConnectionFactory;

public class NgSearch {

	public static boolean debug = false;

	public static String findValue(String key)
	{
		if (debug)
			ConnectionFactory.getInstance().setConfig("D:\\Projects\\Wanli\\develop\\wanli\\src\\META-INF\\db.xml");
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection("dataSource");
			PreparedStatement ps = conn.prepareStatement("select * from ng_product_en_cn where key=?");
			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
			String value = "";
			if (rs.next()) {
				value = rs.getString("VALUE1");
			} else {
				value = null;
			}
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static String translate(String en) {
		if (debug)
			ConnectionFactory.getInstance().setConfig("D:\\Projects\\Wanli\\develop\\wanli\\src\\META-INF\\db.xml");
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection("dataSource");
			String sql1 = "select * from cls_en_cn where EN=?";
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setString(1, en);
			ResultSet rs = ps.executeQuery();
			String prodName = "";
			if (rs.next()) {
				prodName = rs.getString("CN1");
			} else {
				prodName = en;
			}
			rs.close();
			ps.close();
			System.out.println(prodName);
			return prodName;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String search(String v1, String v2, String v3) {
		if (debug)
			ConnectionFactory.getInstance().setConfig("D:\\Projects\\Wanli\\develop\\wanli\\src\\META-INF\\db.xml");
		Connection conn = null;

		try {
			conn = ConnectionFactory.getInstance().getConnection("dataSource");

			// 查找中文品名
			String sql1 = "select * from ng_cls_data where SRC_VALUE1 like ? and SRC_VALUE3 like ?";
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setString(1, v1);
			ps.setString(2, v2);
			ResultSet rs = ps.executeQuery();
			String prodName = "";
			if (rs.next()) {
				prodName = rs.getString("DEST_VALUE1");
			}
			rs.close();
			ps.close();

			// 查找材质
			String sql2 = "select * from ng_cls_mapping where NAME_CN like ?";
			ps = conn.prepareStatement(sql2);
			ps.setString(1, prodName);
			rs = ps.executeQuery();
			String material = "";
			String prodName2 = "";
			String hsCode = "";
			if (rs.next()) {
				material = rs.getString("KEY1_VALUE");
				prodName2 = rs.getString("KEY2_VALUE");
				hsCode = rs.getString("HS_CODE");
			}
			rs.close();
			ps.close();

			System.out.println(material);
			System.out.println(prodName2);
			System.out.println(hsCode);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public static void main(String[] args) {
		//search("Luggage", "100%POLYAMIDE", "");
		//List<String> list = StringUtilEx.splitWordsCn("30%ELASTANE50%MERINOWOOL20%COTTON");
		List<String> list = StringUtilEx.splitWordsCn("50%PVC41%COTTON9%POLYURETHANE");
		List<String> retList = new ArrayList<String>();
		for(String o : list)
			retList.add(translate(o));
		(new MaterialCalc()).sortMaterial(retList);
	}
}
