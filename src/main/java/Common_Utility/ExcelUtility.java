package Common_Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static Workbook wb;
	public static Sheet sh;

	/**
	 * 
	 * @param path
	 * @throws Throwable
	 */
	public static void openExcel(String path) throws Throwable {
		FileInputStream fis = new FileInputStream(path);	
		wb = WorkbookFactory.create(fis);
	}
	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 */
	public static String fetchDataFromExcel(String sheetName,int rownum,int cellnum) {
		sh=wb.getSheet(sheetName);
		String data=sh.getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;		
	}
	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param columnnum
	 * @param value
	 */
	public void writeDataInExcel(String sheetName,int rownum,int columnnum,String value) {
		sh=wb.getSheet(sheetName);
		sh.getRow(rownum).createCell(columnnum).setCellValue(value);
	}
	/**
	 * 
	 * @param path
	 * @throws Throwable
	 */
	public static void closeExcel(String path) throws Throwable {
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();

	}



}
