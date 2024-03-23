package advSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class newBasic {
// to make driver as a goble variable
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("src\\test\\resources\\LoginCredential.properties");
		Properties p =new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("Browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
	
	
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		// to launch the aaplication
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();

}
}