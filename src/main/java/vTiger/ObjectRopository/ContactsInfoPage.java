package vTiger.ObjectRopository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	// Declaration
	@FindBy(className = "dvHeaderText")
	private WebElement ContactHeader;
	
	//initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getContactHeader()
	{
		return ContactHeader;
	}
	// Business Library
	/**
	 * This method will capture the text form Contact and return it to caller.
	 * @return 
	 */
	public String ContactHeaderText()
	{
		return ContactHeader.getText();
	}

}
