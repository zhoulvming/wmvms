package org.myplay.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@SuppressWarnings("unchecked")
public class ExcelUtils {
	private static Log log = LogFactory.getLog(ExcelUtils.class);
	private String sheetName = "查询结果";

	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell cell;
	private HSSFFont font;
	private HSSFCellStyle cellStyle;
	private FileOutputStream fileOut;

	public ExcelUtils() {
		wb = new HSSFWorkbook();
	}

	public ExcelUtils(String[] cols) {
		wb = new HSSFWorkbook();
		this.createSheet(cols, false);
	}

	public byte[] export(List<Object[]> list) {
		for (Object[] o : list) {
			this.outputExcel(o);
		}

		return this.getWb().getBytes();
	}

	public ByteArrayOutputStream export2Stream(String sheetName, String[] cols, List<Object[]> list) {
		this.sheetName = sheetName;
		wb = new HSSFWorkbook();
		this.createSheet(cols, false);

		ByteArrayOutputStream out = null;
		try {
			out = new ByteArrayOutputStream();
			if (list != null) {
				for (Object[] o : list) {
					this.outputExcel(o);
				}
			}
			this.getWb().write(out);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.toString());
			}
		}

		return out;
	}

	/**
	 * @author mawt
	 * @Description:生成下载文件路径
	 * @date Feb 11, 2009
	 * @return
	 */
	public static String downLoadDir() {
		String path = "/";

		return path;
	}

	/**
	 * @author mawt
	 * @Description:<br>
	 * @date Feb 11, 2009
	 * @param excelName
	 *            生成的文件名称
	 * @param list
	 *            每一行的数据
	 * @param firstRowValue
	 *            列名
	 * @param value
	 *            false时表示导入图片
	 * @param path
	 *            图片地址
	 */
	public void outputExcel(Object[] oa) {
		try {
			// this.createSheet(firstRowValue, twoData);
			this.setValueToRow(oa);
		} catch (Exception ex) {
			log.error(ex);
		}
	}

	/**
	 * @author mawt
	 * @Description:<br>
	 * @date Feb 11, 2009
	 * @param excelName
	 *            生成的文件名称
	 * @param list
	 *            每一行的数据
	 * @param value
	 *            false时表示导入图片
	 * @param path
	 *            图片地址
	 */
	// public void outputExcel(String excelName, List list, boolean twoData) {
	// try {
	// this.setValueToRow(excelName, list, twoData);
	// } catch (Exception e) {
	// log.error(e);
	// }
	// }
	/**
	 * @author mawt
	 * @Description:<br>
	 * @date Feb 11, 2009
	 * @param excelName
	 *            生成的文件名称
	 * @param list
	 *            每一行的数据
	 * @param value
	 *            false时表示导入图片
	 * @param path
	 *            图片地址
	 */
	private void setValueToRow(Object[] oa) {

		try {
			// log.info("sheet.getLastRowNum()" + sheet.getLastRowNum());
			int lastRow = sheet.getLastRowNum();
			row = sheet.createRow(lastRow + 1);
			this.createCell(row, oa);

		} catch (Exception ex) {
			log.error("生成报表有误:" + ex);
		} finally {
			try {
				fileOut.flush();
				fileOut.close();
			} catch (Exception e) {
				// log.info("ExcelUtil.setValueToRow()");
			}
		}
	}

	/**
	 * @author mawt
	 * @Description:添加图片到Excel中
	 * @date Feb 11, 2009
	 * @param path
	 *            图片地址
	 */
	public void addImageInSheet(String path) {
		if (path.length() > 1) {
			try {
				HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
				int nowRow = sheet.getLastRowNum();
				HSSFClientAnchor anchor2 = new HSSFClientAnchor(0, 0, 0, 0, (short) 0, (nowRow + 2), (short) 8,
						(nowRow + 30));
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				BufferedImage bufferImg = ImageIO.read(new File("C:/1234337826859.jpg"));
				// BufferedImage bufferImg = ImageIO.read(new
				// File("C:/1234337826859.jpg"));
				ImageIO.write(bufferImg, "jpg", output);
				patriarch.createPicture(anchor2, wb.addPicture(output.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
			} catch (Exception e) {
				log.error(e);
			}
		}
	}

	/**
	 * @author mawt
	 * @Description:添加列名
	 * @date Feb 11, 2009
	 * @param firstRowValue
	 *            列名
	 */
	@SuppressWarnings("deprecation")
	public void createSheet(String[] firstRowValue, boolean twoData) {
		try {
			if (twoData) {
				sheet = wb.getSheetAt(0);
				row = sheet.createRow(sheet.getLastRowNum() + 2);
			} else {
				sheet = wb.createSheet(this.sheetName);
				row = sheet.createRow(0);
			}
			font = wb.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			cellStyle = wb.createCellStyle();
			cellStyle.setFont(font);
			for (int i = 0; i < firstRowValue.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(cellStyle);
				// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell.setCellValue(firstRowValue[i]);
			}
		} catch (Exception ex) {
			log.error(ex);
		}
	}

	/**
	 * @author mawt
	 * @Description:添加数据
	 * @date Feb 11, 2009
	 * @param row
	 *            行
	 * @param obj
	 *            数据
	 */
	@SuppressWarnings("deprecation")
	private void createCell(HSSFRow row, Object[] obj) {
		try {
			for (int i = 0; i < obj.length; i++) {
				cell = row.createCell(i);
				// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell.setCellValue(obj[i] == null ? "" : obj[i].toString());
			}
		} catch (Exception ex) {
			log.error(ex);
		}
	}

	public HSSFWorkbook getWb() {
		return wb;
	}

	public void setWb(HSSFWorkbook wb) {
		this.wb = wb;
	}

}
