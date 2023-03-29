package vTiger.ObjectRopository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Naveen
 *
 */
public class LoginPage {// rule 1: Create pom class for every web page
	
	// rule 2: identify the web element with @findBy,@findAll and @findBys
	@FindBy(name="user_name")
	private WebElement UsernameEdt;
	
	@FindAll({@FindBy(xpath="//input[@type='password']"),@FindBy(xpath="//input[@name='user_password']")})
	private WebElement PasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement SumbmitBtn;
	
	// rule 3: Create a Constructor to initialise these web element
	public  LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	// rule 4: provide getters to access these element

	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSumbmitBtn() {
		return SumbmitBtn;
	}
	// Business Libraries -generic method specific method to current project
	/**
	 * This method will login to app with username and  password
	 * @param Username
	 * @param Password
	 */
	public void LogintoApp(String Username , String Password)
	{
		UsernameEdt.sendKeys("admin");
		PasswordEdt.sendKeys("admin");
		SumbmitBtn.click();
		
	}
		
	}
	
