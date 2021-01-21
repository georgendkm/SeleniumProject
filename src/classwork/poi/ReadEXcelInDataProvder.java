package classwork.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * this one is for reading excel file using dataarray form and dataprovider method. you can call this data provider to any 
 * other class level tests too. for that dataprovier= "testexcel", and the class name= "ReadExcelInDataProvider.class"
 * @author binds
 *
 */

public class ReadEXcelInDataProvder {
	
	@DataProvider(name="testexcel")
	@Test
	public static String[][] readExcelProvider() throws Exception{
		String[][] dataarray = null;
		FileInputStream fin= new FileInputStream("loginExcel.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fin);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFRow row= sheet.getRow(0);
		int rows= sheet.getPhysicalNumberOfRows();
		System.out.println("No.of Rows:"+rows);
		
		for(int r=0; r<rows; r++) {
			 row= sheet.getRow(r);
			 int cells= row.getPhysicalNumberOfCells();
			 System.out.println("No.of cells:"+cells);
			 for(int c=0; c<cells; c++) {
				 XSSFCell cell=row.getCell(c);
				 dataarray[r][c]=cell.getStringCellValue();
			 }
			 
			
		}
		
		workbook.close();
		fin.close();
		return dataarray;
		
	}

}
