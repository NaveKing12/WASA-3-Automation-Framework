package vTiger.ObjectRopository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtilite;

public class CreateNewContactPage extends WebDriverUtilite{
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgLookupImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	//initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	// Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgLookupImg() {
		return OrgLookupImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	// Business Library
	
	public void CreateNewContact(String Lastname)
	{
		LastNameEdt.sendKeys(Lastname);
		SaveBtn.click();
	}
	public void CreateNewContact(WebDriver driver,String Lastname,String Orgname )
	{
		LastNameEdt.sendKeys(Lastname);
		OrgLookupImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(Orgname);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}

}
