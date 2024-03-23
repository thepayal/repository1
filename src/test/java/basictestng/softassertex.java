package basictestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softassertex {

	@Test()
	public void Ajio() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ajio.com/");
		
		String actualurl = driver.getTitle();
		System.out.println(actualurl);
		
		String expectedtitle="Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO";
		
		SoftAssert a=new SoftAssert();
		a.assertEquals(actualurl, expectedtitle);
		System.out.println("Good morning");
		

}
}
