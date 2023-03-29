package vTiger.ObjectRopository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtilite;

public class CreateNewOrgnizationPage extends WebDriverUtilite {
	
	// Deceleration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	// Initialization
	public CreateNewOrgnizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	// Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	// Business Library
	public void createOrganization(String Orgname)
	{
		OrgNameEdt.sendKeys(Orgname);
		SaveBtn.click();
	}
	public void createOrganization(String Orgname,String industryType)
	{
		OrgNameEdt.sendKeys(Orgname);
		handledropdown(industryType, IndustryDropDwn);
		SaveBtn.click();
	}
}
