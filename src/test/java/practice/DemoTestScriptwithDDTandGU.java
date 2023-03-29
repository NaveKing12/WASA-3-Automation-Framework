package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtilitie;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertieFileUtilite;
import vTiger.GenericUtilities.WebDriverUtilite;

public class DemoTestScriptwithDDTandGU {

	public static void main(String[] args) throws IOException {
		
		ExcelFileUtilitie efu=new ExcelFileUtilitie();
		PropertieFileUtilite pfu=new PropertieFileUtilite();
		JavaUtility ju=new JavaUtility();
		WebDriverUtilite wdu=new WebDriverUtilite();
		
		// Read Data from properties File
		String Url=pfu.readDataFromPropertiesFile("url");
		String Browser = pfu.readDataFromPropertiesFile("browser");
		String Username = pfu.readDataFromPropertiesFile("username");
		String Password = pfu.readDataFromPropertiesFile("password");
		
		//Read Data from Excel Sheet
		String Orgname = efu.getDataFromExcelSheet("Orgnization", 1, 2)+ju.getRandom();
		
		WebDriver driver= null;
		
		//Launch browser -runtime polymorphism
		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid browser name");
		}
		pfu.readDataFromPropertiesFile(Url);
		wdu.maximize(driver);
		wdu.implictly(driver);
		//Step 2: Login
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(Username);
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(Password);
		WebElement sub=driver.findElement(By.id("submitButton"));
		sub.submit();
		
		//Step 3: Navigate to Organization link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//Step 4: Click on Create Organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 5: Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//Step 6: Save and verify
		String os=driver.findElement(By.className("dvHeaderText")).getText();
		if(os.contains(Orgname)) {
			System.out.println(os+"---pass---");
		}
		else {
			System.out.println("---fail---");
		}
		//Step 7:Logout of Application
		WebElement ele= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions act=new Actions(driver);
	    act.moveToElement(ele).perform();
	    driver.findElement(By.linkText("Sign Out")).click();
	    System.out.println("SignOut Successful");
		
	}

}
