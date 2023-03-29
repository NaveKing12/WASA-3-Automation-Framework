package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		BaseClassForCreateContact bs=new BaseClassForCreateContact();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login action
		driver.get(bs.getDataFromProperties("url"));
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(bs.getDataFromProperties("username"));
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(bs.getDataFromProperties("password"));
		WebElement sub=driver.findElement(By.id("submitButton"));
		sub.submit();
		
		//Navigate to Contact Link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		// Create Contact with Mandatory fields
	    driver.findElement(By.cssSelector("[name='lastname']")).sendKeys(bs.getDataFromExcelSheet("Contact", 1, 2));
	    
	    //Select the Organization from organization
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> handles=driver.getWindowHandles();
		Iterator it=handles.iterator();
		String parentid=(String) it.next();
		String childid=(String) it.next();
		driver.switchTo().window(childid);
		driver.findElement(By.xpath("//a[text()='N V King']")).click();
		driver.switchTo().window(parentid);
		
		// Save and verify
				driver.switchTo().defaultContent();
				driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
				String vi=driver.findElement(By.className("dvHeaderText")).getText();
				
				if(vi.contains(bs.getDataFromExcelSheet("Contact", 1, 2))){
					System.out.println(vi+"---pass---");
				}
				else {
					System.out.println("---failed---");
				}
				
				// LogOut
				WebElement lo=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act=new Actions(driver);
				act.moveToElement(lo).perform();
			    driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("SignOut Successful");

	}

}
