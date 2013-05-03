package org.myplay.test;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;

public class TestPOI {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		InputStream inp = new FileInputStream("/Users/elgs/Desktop/test.xls");

		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);

		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

		for (Row row : sheet) {
			System.out.println();
			for (Cell cell : row) {
				CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
				System.out.print(" *" + cellRef.formatAsString());
				System.out.print("-");

				CellValue cellValue = evaluator.evaluate(cell);

				if (cellValue != null) {
					switch (cellValue.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cellValue.getBooleanValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cellValue.getNumberValue());
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cellValue.getStringValue());
						break;
					case Cell.CELL_TYPE_BLANK:
						break;
					case Cell.CELL_TYPE_ERROR:
						break;

					// CELL_TYPE_FORMULA will never happen
					case Cell.CELL_TYPE_FORMULA:
						break;
					}
				}
			}
		}
	}

}
