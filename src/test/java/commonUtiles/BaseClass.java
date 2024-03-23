package commonUtiles;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listenerimplimentaion.class)
public class BaseClass {
	public WebDriver driver;
	
	public static WebDriver sdriver;
	PropertyFileUtil p =new PropertyFileUtil();
	WebDriverUtil webutil=new WebDriverUtil();
	@BeforeSuite
	public void BS() {
		System.out.println("Connect to Data Base");
	}

	@BeforeClass
	public void BC() throws IOException {
		String BROWSER = p.getDataFromPropertyFile("Browser");
		String URL = p.getDataFromPropertyFile("Url");
		
		//To launch the browser
		if(BROWSER.equals("Chrome")) {
			 driver =new ChromeDriver();
		}
		else if(BROWSER.equals("Edge")) {
			 driver =new EdgeDriver();
		}
		else {
			driver =new FirefoxDriver();
		}
		
		sdriver=driver;
		// to add implicite wait
		webutil.maximize(driver);
		webutil.implicitwait(driver);
		
		// to launch the aaplication
		driver.get(URL);
	}
	
	@BeforeMethod
	public void BM() throws IOException {
		//To read the data from property file
		String USERNAME = p.getDataFromPropertyFile("Username");
		String PASSWORD = p.getDataFromPropertyFile("Password");
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();	
	}
	
	@AfterMethod
	public void AM() throws InterruptedException {
		Thread.sleep(2000);
		//Mouse hover on image
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		webutil.actions(driver, img);
		/*
		Actions a=new Actions(driver);
		a.moveToElement(img);
		a.perform();
		*/
		//Click on sign out button
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	
	@AfterClass
	public void AC() {
		driver.quit();
	}
	
	@AfterSuite
	public void AS() {
		System.out.println("Disconnect from base class");
	}
}
