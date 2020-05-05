package com.mmp.pages;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExelData {

	public static void main(String[] args) throws Exception {
		
		// define the source directory by using file class
			
		   File src = new File("./mmp-data/data.xlsx");
		// create an object of fileinputstream to stream contents 
		   
		  FileInputStream fis = new FileInputStream(src);
		// create a new workbook
		  XSSFWorkbook wb = new XSSFWorkbook(fis);
		//  get the sheet from this workbook
		  XSSFSheet sheet = wb.getSheetAt(0);
		//get the row and column from sheet
		 String data1 = sheet.getRow(2).getCell(0).getStringCellValue();
		  System.out.println(data1);
		  String data2 = sheet.getRow(2).getCell(1).getStringCellValue();
		  System.out.println(data2);
		  
		/*// get the row count
		  int rcount = sheet.getLastRowNum()+1;
		  System.out.println(rcount);
		
		  for(int i=0;i<rcount;i++)
		  {
			 String data3 = sheet.getRow(i).getCell(0).getStringCellValue();
			 String data4 = sheet.getRow(i).getCell(1).getStringCellValue();
			 System.out.println(data3 +" "+data4);
			  
		  }*/
	         wb.close(); 
		}

	}
