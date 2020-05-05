package com.mmp.pages;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	 XSSFWorkbook wb;
	 XSLFSheet sheet;
	public ExcelUtil(String excelpath) {
		try
			{
				File src = new File("./mmp-data/data.xlsx");
	            FileInputStream fis = new FileInputStream(src);
	            wb = new XSSFWorkbook(fis);
	          // Object sheet = wb.getSheetAt(0);
	        }   
		catch (Exception e)
			{
				System.out.println("file not found" + e.getMessage());
			}

		    }
	public int getRowcount(int sheetnum)
		 {
			int count = wb.getSheetAt(sheetnum).getLastRowNum();
			return count;
		 }
		
		public String getCellData(int sheetnum,int row, int col)
		{
			String data = wb.getSheetAt(sheetnum).getRow(row).getCell(col).getStringCellValue();
			return data;
		}
	}



