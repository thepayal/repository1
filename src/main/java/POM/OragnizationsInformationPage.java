package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OragnizationsInformationPage {
	
	
	@FindBy(name="accountname")
	private WebElement companyname;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement gropurb;
	
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement saveb;

	public WebElement getCompanyname() {
		return companyname;
	}

	public WebElement getGropurb() {
		return gropurb;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSaveb() {
		return saveb;
	}
	
	public void Organitioninfomation(String ORGNAME) {
		companyname.sendKeys(ORGNAME);
		gropurb.click();
		
	
	}

}
