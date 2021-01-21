package classwork.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFile {

	public static void main(String[] args) throws Exception {
		
		
		String [][] data= {	{"username", "password"},
							{"jupiter", "jupiter30"},
							{"mercury", "mercury31"},
							{"saturn", "satrun22"},
							{"mars", "musk"}
						};
				
				
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("TestData1");
		
		for(int i=0; i<data.length; i++) {
			XSSFRow row= sheet.createRow(i);
			for(int j=0; j< data[i].length; j++) {
				XSSFCell cell= row.createCell(j);
				cell.setCellValue(data[i][j]);
			}
			
		}
		
		FileOutputStream fout = new FileOutputStream("loginExcel.xlsx");
		workbook.write(fout);
		fout.close();
		workbook.close();
		System.out.println("Excel File created");

	}

}
