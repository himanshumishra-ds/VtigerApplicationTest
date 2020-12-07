package com.VTiger.genricLibraries;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib implements IAutoConst {
	
	public String getKeyValue(String path , String key ) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream(path);
		
		Properties prop = new Properties();
		prop.load(fis);
		String browsername = prop.getProperty(key, "chrome");
		return browsername;
							
	}
	
public String  getCelldata(String path, String sheet, int row , int cell) throws Throwable
{
	
	FileInputStream fis = new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(fis);
	String cellData = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
	return cellData;

}
    
	
	
}
