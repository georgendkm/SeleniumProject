package classwork.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * reading excel from the system
 * 
 * @author binds
 *
 */
public class ReadExcel {

	public static void main(String[] args) throws Exception {
		readExcel();

	}
	

	public static void readExcel() throws Exception {
		
		FileInputStream fin= new FileInputStream("loginExcel.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(fin);
		XSSFSheet sheet= workbook.getSheet("TestData1");
		
		int rowsize= sheet.getPhysicalNumberOfRows();
		System.out.println("No.of Rows:"+rowsize);
		for(int r= 0; r<rowsize; r++ ) {
			XSSFRow row= sheet.getRow(r);
			int cellsize= row.getPhysicalNumberOfCells();
			System.out.println("No. of cells row:" +cellsize);
			for(int c=0; c<cellsize; c++) {
				XSSFCell cell= row.getCell(c);
				System.out.print(cell.getStringCellValue()+"\t\t\t");
			}
			
			System.out.println();
			
		}
		workbook.close();
		fin.close();
		
	}
	
}
