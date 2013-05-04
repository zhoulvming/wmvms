package org.myplay.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityTransaction;

import org.myplay.entity.ColumnBean;
import org.myplay.entity.NgImportFileBody;
import org.myplay.entity.NgImportFileHeader;

import com.itgodo.common.ConnHelper;

public class ExcelImportDAO {

	// 删除宽表
	public int deleteTable(String fileId) throws Exception {
		Connection conn = null;
		try {
			conn = ConnHelper.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement ps = conn.prepareStatement("delete from ng_import_file_header where FILE_ID=?");
			ps.setString(1, fileId);
			ps.executeUpdate();

			ps = conn.prepareStatement("delete from ng_import_file_body where file_id=?");
			ps.setString(1, fileId);
			ps.executeUpdate();

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return 0;
	}

	// 保存宽表
	public int saveTable(String fileId, List<Object> headers, List<List<Object>> table) {
		int ret = saveHeader(fileId, headers);
		ret = saveBody(fileId, table, true);
		return ret;

	}

	// 保存宽表
	public int getColIndex(String fileId, String colName) {
		IGenericDAO<NgImportFileHeader, String> dao = new JpaGenericDAO<NgImportFileHeader, String>(NgImportFileHeader.class);
		NgImportFileHeader example = new NgImportFileHeader();
		example.setFileId(fileId);
		example.setColName(colName);
		List<NgImportFileHeader> l = dao.findByExample(example);
		if (l != null && l.size() > 0)
			return l.get(0).getSeq();
		else
			return -1;

	}

	// 保存宽表表头
	public int saveHeader(String fileId, List<Object> headers) {
		IGenericDAO<NgImportFileHeader, String> dao = new JpaGenericDAO<NgImportFileHeader, String>(NgImportFileHeader.class);

		System.out.println(System.currentTimeMillis());
		EntityTransaction et = dao.getEntityManager().getTransaction();
		et.begin();
		try {

			int colIndex = 0;
			int maxColIndex = 0;

			// maxColIndex: 计算有效的列数，避免空Excel造成大量空白数据的问题
			for (Object str : headers) {
				colIndex++;
				String name = ((ColumnBean) str).getText();
				if (name == null || "".equals(name) || "".equals(name.trim()))
					continue;
				maxColIndex = colIndex;
			}

			colIndex = 0;
			for (Object str : headers) {
				colIndex++;
				if (colIndex > maxColIndex)
					break;
				NgImportFileHeader header = new NgImportFileHeader();
				header.setColName(((ColumnBean) str).getText());
				header.setFileId(fileId);
				header.setDataIndex(((ColumnBean) str).getDataIndex());
				header.setSeq(colIndex);
				header.setId(UUID.randomUUID().toString());
				header.setCreateTime(new Timestamp(System.currentTimeMillis()));
				dao.makePersistent(header);
			}
			et.commit();
			System.out.println(System.currentTimeMillis());
			return 0;
		} catch (Exception exp) {
			et.rollback();
			exp.printStackTrace();
		} finally {
			dao.getEntityManager().close();
		}

		return -1;
	}

	// 保存宽表表体
	@Deprecated
	public int saveBody1(String fileId, List<List<Object>> table) {
		IGenericDAO<NgImportFileBody, String> dao = new JpaGenericDAO<NgImportFileBody, String>(NgImportFileBody.class);

		try {
			EntityTransaction et = dao.getEntityManager().getTransaction();
			et.begin();

			int rowSeq = 0;
			System.out.println(System.currentTimeMillis());
			// TODO: 解决性能问题，需要使用原生SQL重写
			for (List<Object> row : table) {
				int length = row.size();
				NgImportFileBody body = new NgImportFileBody();

				body.setV1(length >= 1 ? row.get(0).toString() : null);
				body.setV2(length >= 2 ? row.get(1).toString() : null);
				body.setV3(length >= 3 ? row.get(2).toString() : null);
				body.setV4(length >= 4 ? row.get(3).toString() : null);
				body.setV5(length >= 5 ? row.get(4).toString() : null);
				body.setV6(length >= 6 ? row.get(5).toString() : null);
				body.setV7(length >= 7 ? row.get(6).toString() : null);
				body.setV8(length >= 8 ? row.get(7).toString() : null);
				body.setV9(length >= 9 ? row.get(8).toString() : null);
				body.setV10(length >= 10 ? row.get(9).toString() : null);
				body.setV11(length >= 11 ? row.get(10).toString() : null);
				body.setV12(length >= 12 ? row.get(11).toString() : null);
				body.setV13(length >= 13 ? row.get(12).toString() : null);
				body.setV14(length >= 14 ? row.get(13).toString() : null);
				body.setV15(length >= 15 ? row.get(14).toString() : null);
				body.setV16(length >= 16 ? row.get(15).toString() : null);
				body.setV17(length >= 17 ? row.get(16).toString() : null);
				body.setV18(length >= 18 ? row.get(17).toString() : null);
				body.setV19(length >= 19 ? row.get(18).toString() : null);
				body.setV20(length >= 20 ? row.get(19).toString() : null);
				body.setV21(length >= 21 ? row.get(20).toString() : null);
				body.setV22(length >= 22 ? row.get(21).toString() : null);
				body.setV23(length >= 23 ? row.get(22).toString() : null);
				body.setV24(length >= 24 ? row.get(23).toString() : null);
				body.setV25(length >= 25 ? row.get(24).toString() : null);
				body.setV26(length >= 26 ? row.get(25).toString() : null);
				body.setV27(length >= 27 ? row.get(26).toString() : null);
				body.setV28(length >= 28 ? row.get(27).toString() : null);
				body.setV29(length >= 29 ? row.get(28).toString() : null);
				body.setV30(length >= 30 ? row.get(29).toString() : null);
				body.setV31(length >= 31 ? row.get(30).toString() : null);
				body.setV32(length >= 32 ? row.get(31).toString() : null);
				body.setV33(length >= 33 ? row.get(32).toString() : null);
				body.setV34(length >= 34 ? row.get(33).toString() : null);
				body.setV35(length >= 35 ? row.get(34).toString() : null);
				body.setV36(length >= 36 ? row.get(35).toString() : null);
				body.setV37(length >= 37 ? row.get(36).toString() : null);
				body.setV38(length >= 38 ? row.get(37).toString() : null);
				body.setV39(length >= 39 ? row.get(38).toString() : null);
				body.setV40(length >= 40 ? row.get(39).toString() : null);
				body.setV41(length >= 41 ? row.get(40).toString() : null);
				body.setV42(length >= 42 ? row.get(41).toString() : null);
				body.setV43(length >= 43 ? row.get(42).toString() : null);
				body.setV44(length >= 44 ? row.get(43).toString() : null);
				body.setV45(length >= 45 ? row.get(44).toString() : null);
				body.setV46(length >= 46 ? row.get(45).toString() : null);
				body.setV47(length >= 47 ? row.get(46).toString() : null);
				body.setV48(length >= 48 ? row.get(47).toString() : null);
				body.setV49(length >= 49 ? row.get(48).toString() : null);
				body.setV50(length >= 50 ? row.get(49).toString() : null);
				body.setV51(length >= 51 ? row.get(50).toString() : null);
				body.setV52(length >= 52 ? row.get(51).toString() : null);
				body.setV53(length >= 53 ? row.get(52).toString() : null);
				body.setV54(length >= 54 ? row.get(53).toString() : null);
				body.setV55(length >= 55 ? row.get(54).toString() : null);
				body.setV56(length >= 56 ? row.get(55).toString() : null);
				body.setV57(length >= 57 ? row.get(56).toString() : null);
				body.setV58(length >= 58 ? row.get(57).toString() : null);
				body.setV59(length >= 59 ? row.get(58).toString() : null);
				body.setV60(length >= 60 ? row.get(59).toString() : null);
				body.setV61(length >= 61 ? row.get(60).toString() : null);
				body.setV62(length >= 62 ? row.get(61).toString() : null);
				body.setV63(length >= 63 ? row.get(62).toString() : null);
				body.setV64(length >= 64 ? row.get(63).toString() : null);
				body.setV65(length >= 65 ? row.get(64).toString() : null);
				body.setV66(length >= 66 ? row.get(65).toString() : null);
				body.setV67(length >= 67 ? row.get(66).toString() : null);
				body.setV68(length >= 68 ? row.get(67).toString() : null);
				body.setV69(length >= 69 ? row.get(68).toString() : null);
				body.setV70(length >= 70 ? row.get(69).toString() : null);
				body.setV71(length >= 71 ? row.get(70).toString() : null);
				body.setV72(length >= 72 ? row.get(71).toString() : null);
				body.setV73(length >= 73 ? row.get(72).toString() : null);
				body.setV74(length >= 74 ? row.get(73).toString() : null);
				body.setV75(length >= 75 ? row.get(74).toString() : null);
				body.setV76(length >= 76 ? row.get(75).toString() : null);
				body.setV77(length >= 77 ? row.get(76).toString() : null);
				body.setV78(length >= 78 ? row.get(77).toString() : null);
				body.setV79(length >= 79 ? row.get(78).toString() : null);
				body.setV80(length >= 80 ? row.get(79).toString() : null);

				body.setFileId(fileId);
				body.setSeq(rowSeq++);
				body.setId(UUID.randomUUID().toString());
				body.setCreateTime(new Timestamp(System.currentTimeMillis()));

				dao.makePersistent(body);

			}
			et.commit();
			System.out.println(System.currentTimeMillis());
			return 0;
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			dao.getEntityManager().close();
		}
		return -1;
	}

	// 保存宽表表体（快速模式）
	public int saveBody(String fileId, List<List<Object>> table, boolean isFast) {
		Connection conn = null;
		try {
			conn = ConnHelper.getConnection();
			if (isFast)
				conn.setAutoCommit(false);
			System.out.println(System.currentTimeMillis());
			int rowSeq = 0;
			String sql = "insert into ng_import_file_body values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			for (List<Object> row : table) {
				int length = row.size();
				for (int i = 0; i < 80; i++) {
					if (i < length)
						ps.setString(i + 1, row.get(i) == null ? "" : row.get(i).toString());
					else
						ps.setString(i + 1, null);
				}
				ps.setString(81, fileId);
				ps.setString(82, "");
				ps.setInt(83, rowSeq++);
				ps.setString(84, UUID.randomUUID().toString());
				ps.setTimestamp(85, new Timestamp(System.currentTimeMillis()));

				if (isFast) {
					ps.addBatch();
					if (rowSeq % 100 == 0 || rowSeq == table.size()) {
						ps.executeBatch();
						conn.commit();
					}
				} else
					ps.executeUpdate();
			}
			System.out.println(System.currentTimeMillis());
			return 0;
		} catch (Exception exp) {
			if (isFast) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			exp.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	// 从数据库中读出Excel文件 转化为 内存模式
	public List<List<Object>> getDataTable(String fileId, String formHeadId) {
		List<List<Object>> all = new ArrayList<List<Object>>();
		List<Object> headerRow = new ArrayList<Object>();
		int count = getDataTableColumn(fileId, formHeadId, headerRow);
		all.add(headerRow);
		all.addAll(getDataTableBody(formHeadId, count));

		return all;
	}

	// 得到表头 转化为 内存模式
	// 返回:表头宽度
	public int getDataTableColumn(String fileId, String formHeadId, List<Object> headerRow) {
		Connection conn = null;
		try {
			conn = ConnHelper.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from ng_import_file_header where file_id=? order by SEQ");
			ps.setString(1, fileId);
			// ps.setString(2, formHeadId == null ? "%" : formHeadId);
			ResultSet rs = ps.executeQuery();

			int count = 0;
			// List<Object> list = new ArrayList<Object>();
			while (rs.next()) {
				ColumnBean col = new ColumnBean();
				col.setText(rs.getString("COL_NAME"));
				col.setDataIndex(rs.getString("DATA_INDEX"));
				headerRow.add(col);
				count++;
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	// 得到表体 转化为 内存模式
	public List<List<Object>> getDataTableBody(String formHeadId, int colCount) {
		Connection conn = null;
		try {
			conn = ConnHelper.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from ng_import_file_body where form_head_id=? order by SEQ");
			ps.setString(1, formHeadId);
			ResultSet rs = ps.executeQuery();

			List<List<Object>> table = new ArrayList<List<Object>>();
			List<Object> row = null;
			while (rs.next()) {
				row = new ArrayList<Object>();
				for (int count = 1; count <= colCount; count++) {
					Object cell = rs.getObject(count);
					row.add(cell);
				}
				table.add(row);
			}
			return table;
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

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getDataTableColumn(String fileId, String formHeadId) {
		List<Object> list = new ArrayList<Object>();
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
		getDataTableColumn(fileId, formHeadId, list);
		for (Object o : list) {
			ColumnBean cb = (ColumnBean) o;
			HashMap map = new HashMap<String, Object>();
			map.put("text", cb.getText());
			map.put("xtype", cb.getXtype());
			map.put("width", cb.getWidth());
			map.put("editor", cb.getEditor());
			map.put("dataIndex", cb.getDataIndex());
			ret.add(map);
		}
		System.out.println(ret.size());
		return ret;
	}
}
