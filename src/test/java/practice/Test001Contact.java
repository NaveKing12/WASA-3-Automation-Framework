package practice;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Test001Contact {

	public static void main(String[] args) {
		
		//Step 1: Launch browser
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2: Login 
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
		WebElement sub=driver.findElement(By.id("submitButton"));
		sub.submit();
		
		//Step 3: Navigate to Contacts link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Step 4: Click on create contact link 
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step 5: Create contact with mandatory fields and save
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Naveen King");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 6: Verification for Contact
		String contactv=driver.findElement(By.className("dvHeaderText")).getText();
		if(contactv.contains("Naveen King")) {
			System.out.println(contactv+"----pass----");
		}
		else {
			System.out.println("----faile----");
		}
		
		//Step 7: Logout of  Application
		WebElement ele= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions act=new Actions(driver);
	    act.moveToElement(ele).perform();
	    driver.findElement(By.linkText("Sign Out")).click();
	    System.out.println("SignOut Successful");
		
	}

}
