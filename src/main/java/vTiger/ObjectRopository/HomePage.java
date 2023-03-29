package vTiger.ObjectRopository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtilite;

public class HomePage extends WebDriverUtilite {
	
	//Declaration
		@FindBy(linkText="Organizations")
		private WebElement organizationlnk;
		
		@FindBy(linkText="Contacts")
		private WebElement contactlnk;
		
		@FindBy(linkText="Opportunities")
		private WebElement opportunitieslnk;
		
		@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
		private WebElement AdminisrationImg;
		
		@FindBy(linkText ="Sign Out")
		private WebElement SignOutlnk;
		
		//Initialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}

		
		
		//Utilization
		public WebElement getOrganizationlnk() {
			return organizationlnk;
		}

		public WebElement getContactlnk() {
			return contactlnk;
		}

		public WebElement getOpportunitieslnk() {
			return opportunitieslnk;
		}

		public WebElement getAdminisrationImg() {
			return AdminisrationImg;
		}

		public WebElement getSingOutlnk() {
			return SignOutlnk;
		}
		
		// Business Libraries
		/**
		 * This method will perform click operation on Organization link
		 */
		public void  clickOnorganizationlnk()
		{
			organizationlnk.click();
		}
		/**
		 * This method will perform click operation on contact link.
		 */
		public void clickOncontactlnk()
		{
			contactlnk.click();
		}
		public void clickonopportunitieslnk()
		{
			opportunitieslnk.click();
		}
		/**
		 * This method will perform click operation on Sign out link.
		 */
		public void logoutOfApp(WebDriver driver)
		{
			mouseOverAction(driver, AdminisrationImg);
			SignOutlnk.click();
		}
}
