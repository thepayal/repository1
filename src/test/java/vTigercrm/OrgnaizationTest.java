package vTigercrm;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtiles.BaseClass;
import commonUtiles.ExcelUtil;
import commonUtiles.JavaUtil;
import commonUtiles.Listenerimplimentaion;
import commonUtiles.WebDriverUtil;
//@Listeners(Listenerimplimentaion.class)
public class OrgnaizationTest extends BaseClass {
	//Create Objects
	WebDriverUtil webutil=new WebDriverUtil();
	JavaUtil jutil=new JavaUtil();
	ExcelUtil exutil=new ExcelUtil();
	
	@Test
	public void createOrgnaizationTest() throws InterruptedException, EncryptedDocumentException, IOException {
		
		String ORGNAME = exutil.getDataFromExcelFile("Organizations", 0, 1);
	    String group = exutil.getDataFromExcelFile("Organizations", 1, 1);
	    
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.randomnumber(null));
		
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "http://localhost:8888/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing";
		Assert.assertEquals(actualurl, expectedurl);
		
		webutil.Screenshot(driver);
		
		
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		WebElement click = driver.findElement(By.name("assigned_group_id"));
		
		/*
		Select sc=new Select(click);
		sc.selectByVisibleText(group);
		*/
		
		webutil.handledropdown(click, group);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		//save the button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		
		Thread.sleep(2000);
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		webutil.actions(driver, img);
	}

}
