package commonUtiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public String getDataFromExcelFile(String sheetname,int rowname,int cellvalue) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis =new FileInputStream("src\\test\\resources\\data.xlsx");
		
		//Step 2- call create(inputstream) ...have to read the data thats why we create create method
		 Workbook wb = WorkbookFactory.create(fis);
		 
		 //Step 3- call getSheet(String name)
		  Sheet sh = wb.getSheet(sheetname);
	
		 //Step 4-call getRow(int row numb)
		  Row rw = sh.getRow(rowname);
		  
		  //Step 5-call getColoum()
		  Cell cl = rw.getCell(cellvalue);
		  
		  //Step 6- 
		  String data = cl.getStringCellValue();
		  return data;
		  
	}

}
