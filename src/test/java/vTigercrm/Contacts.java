package vTigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

import commonUtiles.ExcelUtil;
import commonUtiles.Listenerimplimentaion;
import commonUtiles.PropertyFileUtil;
import commonUtiles.WebDriverUtil;
@Listeners(Listenerimplimentaion.class)
public class Contacts {
	public static  WebDriver driver ;
	public static void main(String[] args) throws IOException, InterruptedException {
		PropertyFileUtil p =new PropertyFileUtil();
		WebDriverUtil wutil=new WebDriverUtil();
		ExcelUtil exutil=new ExcelUtil();
		String BROWSER = p.getDataFromPropertyFile("Browser");
		String URL = p.getDataFromPropertyFile("Url");
		String USERNAME = p.getDataFromPropertyFile("Username");
		String PASSWORD = p.getDataFromPropertyFile("Password");
		String ORGNAME = exutil.getDataFromExcelFile("Organizations", 0, 1);
		String group = exutil.getDataFromExcelFile("Organizations", 1, 1);
		
		if(BROWSER.equals("Chrome")) {
			 driver =new ChromeDriver();
		}
		else if(BROWSER.equals("Edge")) {
			 driver =new EdgeDriver();
		}
		else {
			driver =new FirefoxDriver();
		}
		
		wutil.maximize(driver);
		wutil.implicitwait(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		String FIRSTNAME = exutil.getDataFromExcelFile("Contacts", 0, 1);
		String LASTNAME = exutil.getDataFromExcelFile("Contacts", 1, 1);
		String dropdown = exutil.getDataFromExcelFile("Contacts", 2, 1);
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		wutil.getcurrenturl(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		driver.findElement(By.id("search_txt")).sendKeys("IBM");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='IBM']")).click();
		wutil.getcurrenturl(driver,"http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		WebElement click = driver.findElement(By.name("assigned_group_id"));
		wutil.handledropdown(click, dropdown);
		//wutil.handledropdown(click, "Team Selling");
		
		Select sc=new Select(click);
		sc.selectByVisibleText("Team Selling");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		Thread.sleep(2000);
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.actions(driver, img);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	}

}
