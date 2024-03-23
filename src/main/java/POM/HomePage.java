package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement oragnizations;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contacts;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement image;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement click;

	public WebElement getOragnizations() {
		return oragnizations;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getClick() {
		return click;
	}
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	public void Home() {
		oragnizations.click();
	}
	
	public void Home(WebDriver driver) {
		
	}
}
