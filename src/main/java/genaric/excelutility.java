package genaric;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelutility{
	/**
	 * declaring workbook as private and give as gable variable
	 */
	private Workbook workbook;
public void excellimit(String excelpath) {	
	/**
	 * creating file taken as gable variable 
	 */
	FileInputStream fil=null;
	try {
	fil =new FileInputStream(excelpath);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		/**
		 * Wrokbook creating as workbookfactory into above taken fileinoutstream to add into file
		 */
		workbook = WorkbookFactory.create(fil);
	}catch(EncryptedDocumentException |IOException e) {
		e.printStackTrace();
	}
	
	
}
public String getdatafromexcel(String sheetname,int rownum,int cellnum) {
	/**
	 * hear we carting excelsheet data add sheetname ,rownum,cellnum
	 * and take datafoematter useing workbook taken sheet,row,cell
	 * and retuening the data
	 */
	DataFormatter df=new DataFormatter();
	String data=df.formatCellValue(workbook.getSheet(sheetname).getRow(rownum).getCell(cellnum));
	return data;
	
}
public Map<String, String>  getdatafromExcel(String sheetname){
	/**
	 * hear we taken as map adding rownum h
	 */
	DataFormatter df=new DataFormatter();
	Map<String,String> map=new HashMap<>();
	Sheet sheet=workbook.getSheet(sheetname);
	for(int i=0;i<=sheet.getLastRowNum();i++) {
		String key=df.formatCellValue(sheet.getRow(1).getCell(0));
		String value=df.formatCellValue(sheet.getRow(1).getCell(1));
		map.put(key, value);
}return map;

}
public void writexcel(String sheetname,int rownum,int cellnum,String Excelpath, Date data) {
	Cell cell=workbook.getSheet(Excelpath).getRow(rownum).getCell(cellnum);
	cell.setCellValue(data);
	FileOutputStream fos=null;
	try {
fos =new FileOutputStream(Excelpath);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}try {
		workbook.write(fos);
		
	}
catch(IOException e) {
	e.printStackTrace();
}
	try {
		workbook.close();
	}catch(IOException e) {
		e.printStackTrace();
		
	}

}

}

