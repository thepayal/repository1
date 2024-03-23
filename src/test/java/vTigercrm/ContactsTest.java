package vTigercrm;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtiles.BaseClass;
import commonUtiles.ExcelUtil;
import commonUtiles.JavaUtil;
import commonUtiles.Listenerimplimentaion;
import commonUtiles.PropertyFileUtil;
import commonUtiles.WebDriverUtil;
@Listeners(Listenerimplimentaion.class)
public class ContactsTest extends BaseClass {
	PropertyFileUtil p =new PropertyFileUtil();
	WebDriverUtil wutil=new WebDriverUtil();
	ExcelUtil exutil=new ExcelUtil();
	@Test
	public void createconactsTest() throws EncryptedDocumentException, IOException, InterruptedException {	
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys("Payal");
		driver.findElement(By.name("lastname")).sendKeys("Kawale");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		wutil.getcurrenturl(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		driver.findElement(By.id("search_txt")).sendKeys("IBM");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='IBM']")).click();
		wutil.getcurrenturl(driver,"http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		WebElement click = driver.findElement(By.name("assigned_group_id"));
		/*
		wutil.handledropdown(click, dropdown);
		//wutil.handledropdown(click, "Team Selling");
		*/
		
		Select sc=new Select(click);
		sc.selectByVisibleText("Team Selling");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	}

}

