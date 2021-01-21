package classwork.poi;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadAutoData {

	@DataProvider(name="autodata")
	@Test
	public static String[][] readExcelProvider() throws Exception{
		String[][] dataarray;
		//String[][] signinarray;
		
		FileInputStream fin= new FileInputStream("automationdata.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fin);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFRow row= sheet.getRow(0);
		int rows= sheet.getPhysicalNumberOfRows();
		int cells= row.getPhysicalNumberOfCells();
		dataarray = new String[rows][cells];
		System.out.println("No.of Rows:"+rows);
		
		
		for(int r=0; r<rows; r++) {
			 row= sheet.getRow(r);
			
			 System.out.println("No.of cells:"+cells);
			 for(int c=0; c<cells; c++) {
				 XSSFCell cell=row.getCell(c);
				 dataarray[r][c]=cell.getStringCellValue();
			 }
			 
			 return dataarray;
		}
		
/*		int signin=sheet.getPhysicalNumberOfRows();
		System.out.println("No.of Rows:"+search);
		for(int r=0; r<signin; r++) {
			 row= sheet.getRow(r);
			 int cells= row.getPhysicalNumberOfCells();
			 System.out.println("No.of cells:"+cells);
			 for(int c=0; c<cells; c++) {
				 XSSFCell cell=row.getCell(c);
				 siginarray[r][c]=cell.getStringCellValue();
			 }
			
			return siginarray;
		}
		*/
		
		workbook.close();
		fin.close();
		return dataarray;
		
		
	}



}
