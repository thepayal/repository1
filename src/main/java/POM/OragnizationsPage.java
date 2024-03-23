package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OragnizationsPage {

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement oragnizations;
	
	public OragnizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOragnizations() {
		return oragnizations;
	}
	
	
}
