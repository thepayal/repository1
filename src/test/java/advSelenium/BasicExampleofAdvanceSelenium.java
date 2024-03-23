package advSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicExampleofAdvanceSelenium {

	public static void main(String[] args) throws IOException {
		
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			//d.findElement(By.cssSelector("button[type='submit']")).click();
		
		//step1- create object 
		FileInputStream fis =new FileInputStream("src\\test\\resources\\data.properties");
		//step2-create object of perpreties class 
		Properties p=new Properties();
		//step3- call a method called load because to featch the location of property file  handle the input and output exception 
		p.load(fis);
		//step4- call getProperty() because of featching the key
		String username = p.getProperty("Username");
		String password = p.getProperty("Password");
		d.findElement(By.name("username")).sendKeys("username");
		d.findElement(By.name("password")).sendKeys("password");
		
	}

}
