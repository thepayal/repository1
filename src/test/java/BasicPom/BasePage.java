package BasicPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import POM.HomePage;
import POM.Loginpage;
import POM.OragnizationsInformationPage;
import POM.OragnizationsPage;

public class BasePage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
	
		
		Loginpage lp=new Loginpage(driver);
		//to initialize the webelement 
		/*
		PageFactory.initElements(driver, lp);
		lp.getUsernametf().sendKeys("admin");
		lp.getPasswordtf().sendKeys("root");
		//click on ongin button
		lp.getLogin().click();
		*/
		lp.login("admin", "root");
		
		
		
		HomePage hp=new HomePage(driver);
		//to initialize the webelement 
		
		//PageFactory.initElements(driver, hp);
		//click on organization
		//hp.getOragnizations().click();
		hp.Home();
		
		
		OragnizationsPage op=new OragnizationsPage(driver);
		//to initialize the webelement 
		//PageFactory.initElements(driver, op);
		//click on create oragnization
		//op.getClass();
		//op.getOragnizations().click();
		op.getOragnizations().click();
		
		OragnizationsInformationPage oip =new OragnizationsInformationPage();
		PageFactory.initElements(driver, oip);
		oip.getCompanyname().sendKeys("tcs8788");
		oip.getGropurb().click();
		
		Select s=new Select(oip.getDropdown());
		s.selectByVisibleText("Support Group");
		
		oip.getSaveb().click();
		Thread.sleep(2000);
		Actions a=new Actions(driver);
		Thread.sleep(2000);
		PageFactory.initElements(driver, hp);
		a.moveToElement(hp.getImage()).perform();
		
		hp.getClick().click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.findElement(By.id("email")).sendKeys("admin");
		driver.navigate().refresh();
		driver.findElement(By.id("password")).sendKeys("user");
		driver.findElement(By.id("keepLoggedInCheckBox")).click();
		driver.findElement(By.id("last")).click();
	*/
	}

}
