package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDateintoExcelSheet {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Contects");
		Row rw=sh.getRow(2);
		Cell cl=rw.createCell(5);
		cl.setCellValue("King");
		FileOutputStream fos=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
		wb.write(fos);
		System.out.println("Data added");
		
		
		
		
	}

}
