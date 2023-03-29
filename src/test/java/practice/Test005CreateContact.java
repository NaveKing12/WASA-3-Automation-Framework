package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test005CreateContact {

	public static void main(String[] args) {
		

		//Step 1:Launch Browser
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2:Login 
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
		WebElement sub=driver.findElement(By.id("submitButton"));
		sub.submit();
		
		//Step 3: Navigate to Contact Link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step 4: Create Contact with Mandatory fields
		driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Kings");
		
		//Step 5: Select the Organization from organization
//		driver.findElement(By.className("lvtColDataHover")).click();
		driver.findElement(By.xpath("//img[@title='Select']")).click();
//		String mainid=driver.getWindowHandle();
//		Set<String> allid=driver.getWindowHandles();
//		for(String id:allid) {
//			if(!(mainid.equals(id)));
//			{
//				driver.switchTo().window(id);
//			}
//	}
		Set<String> handles=driver.getWindowHandles();
		Iterator it=handles.iterator();
		String parentid=(String) it.next();
		String childid=(String) it.next();
		
		driver.switchTo().window(childid);
		driver.findElement(By.xpath("//a[text()='N V King']")).click();
		driver.switchTo().window(parentid);
		
		//Step 6: Save and verify
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		String vi=driver.findElement(By.className("dvHeaderText")).getText();
		
		if(vi.contains("Kings")){
			System.out.println(vi+"---pass---");
		}
		else {
			System.out.println("---failed---");
		}
		
		//Step 7: LogOut
		WebElement lo=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(lo).perform();
	    driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("SignOut Successful");
		
	}

}
