package advSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readclass {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//to read data from excel file
		//Step 1- Create object of fileInputStream class 
		FileInputStream fis =new FileInputStream("src\\test\\resources\\data.xlsx");
		
		//Step 2- call create(inputstream) ...have to read the data thats why we create create method
		 Workbook wb = WorkbookFactory.create(fis);
		 
		 //Step 3- call getSheet(String name)
		  Sheet sh = wb.getSheet("Organizations");
	
		 //Step 4-call getRow(int row numb)
		  Row rw = sh.getRow(0);
		  
		  //Step 5-call getColoum()
		  Cell cl = rw.getCell(0);
		  
		  //Step 6- 
		  String data = cl.getStringCellValue();
		  System.out.println(data);
	}

}
