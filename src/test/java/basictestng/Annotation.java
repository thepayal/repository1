package basictestng;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class Annotation {

	@Test(priority=0)
	public void flipcart() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
	@Test(invocationCount=2)
	public void amazon() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
	}
}
