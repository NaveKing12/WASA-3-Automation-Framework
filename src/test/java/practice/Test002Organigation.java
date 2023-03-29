package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test002Organigation {

	public static void main(String[] args) {
		
		//Step 1: Launch browser
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2: Login
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
		WebElement sub=driver.findElement(By.id("submitButton"));
		sub.submit();
		
		//Step 3: Navigate to Organization link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//Step 4: Click on Create Organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 5: Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("N V Kings");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//Step 6: Save and verify
		String os=driver.findElement(By.className("dvHeaderText")).getText();
		if(os.contains("N V Kings")) {
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
