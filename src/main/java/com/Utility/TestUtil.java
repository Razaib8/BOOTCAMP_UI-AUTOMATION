package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Base.Base;
import com.google.common.io.Files;

public class TestUtil extends Base {
	
	public static String path = "C:\\Users\\rafri\\eclipse-workspace\\AmazonTesting\\Data\\AmazonRegData.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static FileInputStream file;
	public static String SheetName = "AmazonRegData";
	
	public TestUtil() throws IOException {
		super();
	}

	public void takeScreenShot(String Filename) throws IOException{
		
		// Convert webdriver to TakeScreenshot
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// Copy the file to a location and use try catch block to handle exception
		Files.copy(screenShot, new File("C:\\Users\\rafri\\eclipse-workspace\\AmazonTesting\\ScreenShots\\" +Filename+
						".jpeg"));
	}

	
	
	public static Object [][] getAmazonRegData(String SheetName) {
		try {
			file = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		sheet = book.getSheet(SheetName);
		
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
		System.out.println(sheet.getLastRowNum()+ "Row's  ============ " +sheet.getRow(0).getLastCellNum()+ "Columns");
		for(int r = 0; r<sheet.getLastRowNum(); r++) {
			for(int c = 0; c<sheet.getRow(0).getLastCellNum(); c++) {
				data[r][c] = sheet.getRow(r+1).getCell(c).toString();
				System.out.println(data[r][c]+ " \t");
			}
			System.out.println("\n");
		}
		return data;
	}
}
