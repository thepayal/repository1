package commonUtiles;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	JavaUtil jutil=new JavaUtil();
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));	
	}
	
	public void handledropdown(WebElement targeteddropdown,String targetedoptions ) {
		
		Select sc=new Select(targeteddropdown);
		sc.selectByVisibleText(targetedoptions);
	}
	
	public void actions(WebDriver driver, WebElement movetoover ) {
		Actions a=new Actions(driver);
		a.moveToElement(movetoover);
		a.perform();
	}

	public void getcurrenturl(WebDriver driver, String string) {
		// TODO Auto-generated method stub
			Set<String> ids = driver.getWindowHandles();
		
		for(String allWindows:ids) {
			String actualurl = driver.switchTo().window(allWindows).getCurrentUrl();
			
			if(actualurl.contains(allWindows)) {
				break;
			}
				
		}
			
	}
	public String Screenshot(WebDriver driver) throws IOException {
	TakesScreenshot js=(TakesScreenshot) driver;
	  File tempfile = js.getScreenshotAs(OutputType.FILE);
	  File destination=new File("./screenshot/imagee.png");
	  FileUtils.copyFile(tempfile, destination);
	  return destination.getAbsolutePath();
	  
	}
	
}
	

