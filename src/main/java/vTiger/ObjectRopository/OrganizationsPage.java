package vTiger.ObjectRopository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	//Deceleration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrgLookupImg;
	
	//initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization

	public WebElement getCreateOrgLookupImg() {
		return CreateOrgLookupImg;
	}
	// Business Library
	public void clickonCreateOrgLookupImg()
	{
		CreateOrgLookupImg.click();
	}
	
	

}
