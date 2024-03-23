package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

		@FindBy(name="user_name")
		private WebElement usernametf;
		
		@FindBy(name="user_password")
		private WebElement passwordtf;
		
		@FindBy(id="submitButton")
		private WebElement login;

		
		public WebElement getLogin() {
			return login;
		}

		public WebElement getUsernametf() {
			return usernametf;
		}

		public WebElement getPasswordtf() {
			return passwordtf;
		}
		
		public Loginpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	    
		public void login(String username,String password) {
		usernametf.sendKeys(username);
		passwordtf.sendKeys(password);
		login.click();
	}
	}


