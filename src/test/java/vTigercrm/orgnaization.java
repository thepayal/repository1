package vTigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

import commonUtiles.ExcelUtil;
import commonUtiles.JavaUtil;
import commonUtiles.Listenerimplimentaion;
import commonUtiles.PropertyFileUtil;
import commonUtiles.WebDriverUtil;
@Listeners(Listenerimplimentaion.class)
public class orgnaization {
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
		// to add implicite wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		webutil.maximize(driver);
		webutil.implicitwait(driver);
		// to launch the aaplication
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//login to application
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.randomnumber(null));
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
		/*
		Actions a=new Actions(driver);
		a.moveToElement(img);
		a.perform();
		*/
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
