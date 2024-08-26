package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.BaseClass;



public class ReadExcel extends BaseClass{
	
	public static String[][] getData (String excelFileData) throws IOException {
		
		XSSFWorkbook workBook=new XSSFWorkbook("./TestData/"+excelFileData+".xlsx");
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
	    int colCount = sheet.getRow(0).getLastCellNum();

	    String[][] data = new String[rowCount][colCount];
	    DataFormatter dataFormatter = new DataFormatter();

	    for (int i = 1; i <= rowCount; i++) {
	        XSSFRow eachRow = sheet.getRow(i);

	        for (int j = 0; j < colCount; j++) {
	            XSSFCell eachCell = eachRow.getCell(j);

	            // Null check added to avoid NullPointerException
	            if (eachCell != null) {
	                if (eachCell.getCellType() == CellType.NUMERIC) {
	                    data[i - 1][j] = dataFormatter.formatCellValue(eachCell);
	                } else if (eachCell.getCellType() == CellType.BOOLEAN) {
	                    data[i - 1][j] = dataFormatter.formatCellValue(eachCell);
	                } else {
	                    data[i - 1][j] = eachCell.getStringCellValue();
	                }
	            } else {
	                // Handle the case when eachCell is null, e.g., set a default value or log a message
	                data[i - 1][j] = "Cell is null";
	            }

	            System.out.print(data[i - 1][j]);
	            System.out.print(" || ");
	        }
	        System.out.println();
	    }

	    workBook.close();
	    return data;
	}
}