package vTigercrm;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import commonUtiles.BaseClass;
import commonUtiles.ExcelUtil;
import commonUtiles.Listenerimplimentaion;
import commonUtiles.PropertyFileUtil;
import commonUtiles.WebDriverUtil;
@Listeners(Listenerimplimentaion.class)
public class LeadsTest extends BaseClass {
	PropertyFileUtil p =new PropertyFileUtil();
	WebDriverUtil wutil=new WebDriverUtil();
	ExcelUtil exutil=new ExcelUtil();
	
	@Test
	public void leadsTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Payal");
		Thread.sleep(2000);
		driver.findElement(By.name("lastname")).sendKeys("Kawale");
		driver.findElement(By.name("company")).sendKeys("IBM");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		WebElement click = driver.findElement(By.name("assigned_group_id"));
		//webutil.handledropdown(click, "Team Selling");
		Select sc=new Select(click);
		sc.selectByVisibleText("Team Selling");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[class='crmButton small save']")).click();
		
		Thread.sleep(2000);
		
	}

}
