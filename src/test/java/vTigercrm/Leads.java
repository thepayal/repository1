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
import commonUtiles.JavaUtil;
import commonUtiles.Listenerimplimentaion;
import commonUtiles.PropertyFileUtil;
import commonUtiles.WebDriverUtil;
@Listeners(Listenerimplimentaion.class)
public class Leads {
	 public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		PropertyFileUtil p =new PropertyFileUtil();
		JavaUtil jutil=new JavaUtil();
		ExcelUtil exutil=new ExcelUtil();
		WebDriverUtil webutil=new WebDriverUtil();
		String BROWSER = p.getDataFromPropertyFile("Browser");
		String URL = p.getDataFromPropertyFile("Url");
		String USERNAME = p.getDataFromPropertyFile("Username");
		String PASSWORD = p.getDataFromPropertyFile("Password");
		String ORGNAME = exutil.getDataFromExcelFile("Organizations", 0, 1);
	    String group = exutil.getDataFromExcelFile("Organizations", 1, 1);
	    //to launch the browser
		
		if(BROWSER.equals("Chrome")) {
			 driver =new ChromeDriver();
		}
		else if(BROWSER.equals("Edge")) {
			 driver =new EdgeDriver();
		}
		else {
			driver =new FirefoxDriver();
		}
		
		webutil.maximize(driver);
		webutil.implicitwait(driver);
		// to launch the aaplication
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Payal");
		driver.findElement(By.name("lastname")).sendKeys("Kawale");
		driver.findElement(By.name("company")).sendKeys("IBM");
		
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		WebElement click = driver.findElement(By.name("assigned_group_id"));
		//webutil.handledropdown(click, "Team Selling");
		Select sc=new Select(click);
		sc.selectByVisibleText("Team Selling");
		
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		Thread.sleep(2000);
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		webutil.actions(driver, img);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
