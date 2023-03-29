package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class conceder of Generic method to read data from ExcelSheet file
 * @author Naveen
 *
 */
public class ExcelFileUtilitie {
	/**
	 * This method will read data from Excel Sheet
	 * @param Sheetname
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
      
	public String getDataFromExcelSheet(String Sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis=new FileInputStream(IConstentsUtilitie.ExcelFilepathe);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(Sheetname);
	Row rw = sh.getRow(rownum);
	Cell cl = rw.getCell(cellnum);
	String value=cl.getStringCellValue();
	return value;
	}
	
	/**This method will get the total row
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	
	public int getRowCount(String Sheetname) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(IConstentsUtilitie.ExcelFilepathe);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheetname);
		int Rowcount=sh.getLastRowNum();
		wb.close();
		return Rowcount;
	}
	/**This method use write data into Excel Sheet
	 * @param value 
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	public void writeDataIntoExcelSheet(String Sheetname,int rownum , int cellnum, Date value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstentsUtilitie.ExcelFilepathe);
		Workbook wb = WorkbookFactory.create(fis);
		Row rw = wb.getSheet(Sheetname).getRow(rownum);
		rw.createCell(cellnum).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IConstentsUtilitie.ExcelFilepathe);
		wb.write(fos);
		System.out.println(value+"------>data added");
		wb.close();
		
	}
	/**
	 * This method will load data from excel sheet to provider
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetname) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(IConstentsUtilitie.ExcelFilepathe);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int LastRow = sh.getLastRowNum();
		short LastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[LastRow][LastCel];
		
		for(int i=0;i<LastRow;i++)
		{
			for(int j=0;j<LastCel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
