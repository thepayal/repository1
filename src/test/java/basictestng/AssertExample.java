package basictestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class AssertExample {

	@Test()
	public void Ajio() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ajio.com/");
		//for url
		//assertequal--------------------------------
		//String actualurl = driver.getCurrentUrl();
		//System.out.println(actualurl);
		
		/*
		if(actualurl.equals("https://www.ajio.com/")) {
			System.out.println("url is matching");
		}
		else {
			System.out.println("url is not matching");
		}
		System.out.println("Good morning");
		*/
		/*
		//for title55
		String expectedurl = "https://www.ajio.com/";
		Assert.assertEquals(actualurl, expectedurl);
		System.out.println("Good Morning");
		
		
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		
		
		String excepted="Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO";
		Assert.assertEquals(actualtitle, excepted);
		System.out.println("Good morning");
		*/
		//assertTrue--------------------------
		//Trueconditionthe output will be pass
		//Trueconditionthe output will be fail
		/*
		//using select we can select only redio button and check box
		WebElement click = driver.findElement(By.name("searchVal"));
		Assert.assertTrue(click.isEnabled());
		//Assert.assertTrue(click.isSelected());
		System.out.println("Good morning");
		*/
		//Trueconditionthe output will be fail
		//Trueconditionthe output will be pass
		//assertfalse---------------------
		
		WebElement click = driver.findElement(By.name("searchVal"));
		//Assert.assertFalse(click.isEnabled()); //true comdition
		Assert.assertFalse(click.isSelected()); //false conditon
		System.out.println("Good morning");
		
			
	}
		
	

}
