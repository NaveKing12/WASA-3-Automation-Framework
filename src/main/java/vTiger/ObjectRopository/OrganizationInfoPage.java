package vTiger.ObjectRopository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	// Declaration
	@FindBy(className="dvHeaderText")
	private WebElement OrgHederText;
	
	//initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public  WebElement getOrgHederText()
	{
		return OrgHederText;
	}
	
	// Business Library
	public String getOrgHeder()
	{
		return OrgHederText.getText();
	}
}
