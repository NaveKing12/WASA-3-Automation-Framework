package vTiger.ObjectRopository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactLookupImg;
	
	//Initialization
	public ContactsPage(WebDriver driver)
	{
	PageFactory.initElements( driver,this);
    }
	
	//Utilization
	public WebElement getCreateContactLookupImg() {
		return CreateContactLookupImg;
	}
	
	//Business Libraries
	/**
	 * This method will perform click operation on create contact lookup img.
	 */
	public void clickOnCreateContactLookupImg()
	{
		CreateContactLookupImg.click();
	}

	
}
