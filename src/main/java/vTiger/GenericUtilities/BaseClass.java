package vTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRopository.HomePage;
import vTiger.ObjectRopository.LoginPage;

/**
 * This class consist of Basic Configuration annotation
 * @author Naveen
 *
 */
public class BaseClass {
	
	public PropertieFileUtilite pfu=new PropertieFileUtilite();
	public ExcelFileUtilitie efu=new ExcelFileUtilitie();
	public WebDriverUtilite wdu=new WebDriverUtilite();
	public JavaUtility ju=new JavaUtility();
	public static WebDriver sdriver; //Listeners
	
	public WebDriver driver;
	
	
	@BeforeSuite (groups = { "SmokeSuite","Regresstion"})
	public void bsConfigur()
	{
		System.out.println("----Database Connected Successful");
	}
	
//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(groups = { "SmokeSuite","Regresstion"})
	public void bcConfigur(/*String BROWSER*/) throws IOException
	{
    	String URL = pfu.readDataFromPropertiesFile("url");
		String BROWSER = pfu.readDataFromPropertiesFile("browser");		
		if(BROWSER.equalsIgnoreCase("msedge"))
		{
			WebDriverManager.edgedriver().setup();
		     driver = new EdgeDriver();
		    System.out.println("-----"+BROWSER+"-----Lanched Successful");
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("----"+BROWSER+"----Lanched Successful");
		}else {
			System.out.println("Invalid Browser");
		}
		sdriver=driver;
		wdu.maximize(driver);
		wdu.implictly(driver);
		driver.get(URL);
		
	}
	@BeforeMethod(groups = { "SmokeSuite","Regresstion"})
	public void BmConfigur() throws IOException
	{
		String USERNAME = pfu.readDataFromPropertiesFile("username");
		String PASSWORD = pfu.readDataFromPropertiesFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.LogintoApp(USERNAME, PASSWORD);
		
		System.out.println("----Login Successful----");
		
		
	}
	
	@AfterMethod(groups = { "SmokeSuite","Regresstion"})
	public void amConfigur()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("----Logout Successful----");
		
	}
	@AfterClass(groups = { "SmokeSuite","Regresstion"})
	public void acConfigur()
	{
		driver.quit();
		System.out.println("----Browser Close Successful----");
	}
	@AfterSuite(groups = { "SmokeSuite","Regresstion"})
	public void asConfigur()
	{
		System.out.println("----Database Connection Successful----");
	}
	
}
