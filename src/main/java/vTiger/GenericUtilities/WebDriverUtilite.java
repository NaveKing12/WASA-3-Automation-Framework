package vTiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class consist of generic method related to  Webdriver action
 * @author Naveen
 *
 */

public class WebDriverUtilite {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		
		driver.manage().window().maximize();
	}
	
	public void minixize(WebDriver driver) {
		
		driver.manage().window().minimize();
	}
	/**
	 * This method wait for the page load
	 * @param driver
	 */
	public void implictly(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for the page load
	 */
	public void waitForElementvisiable(WebDriver driver,WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is use for click action.
	 * @param driver
	 */
	public void clickaction(WebDriver driver) {
		
		Actions act=new Actions(driver);
		act.click();
	}
	/**
	 * This method used for particular click WebElement
	 * @param driver
	 * @param element
	 */
	public void clickWebElement(WebDriver driver, WebElement element) {
		
		Actions act=new Actions(driver);
		act.click(element);
	}
	/**
	 * This method used for right Click action.
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick();
	}
	/**
	 * This method use for right Click action on particular WebElement
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element);
	}
	/**
	 * This method used to perform mouse over action.
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method used to double click action.
	 * @param driver
	 */
	public void doubleclick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick();
		
	}
	/**
	 * This method used to double click an particular WebElement.
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element);
	}
	/**
	 * This method used to select index.
	 * @param element
	 * @param index
	 */
	public void handledropdown(WebElement element ,int index) {
		
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method used to select by visible text.
	 * @param element
	 * @param value
	 */
	public void handledropdown(WebElement element,String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method used to select by value.
	 * @param value
	 * @param element
	 */
	public void handledropdown(String value,WebElement element) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method used to Accept the notification
	 * @param driver
	 */
	public void alertAccept(WebDriver driver) {
		
		driver.switchTo().alert().accept();
	}
	/**
	 * This method used to dismiss the notification
	 * @param driver
	 */
	public void alertdismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void alertgetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
	public void handleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void handleFrame(WebDriver driver,String nameorId) {
		driver.switchTo().frame(nameorId);
	}
	/**
	 * This method will handle frame based on WebElement
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchtoParent(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void swithchtoDefult(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will switch the window base an partial window title.
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle) {
		
		// Step 1: Capture all the window ids
		Set<String> winIDs = driver.getWindowHandles();
		
		// Step 2: Navigate to each window
		for(String win:winIDs)
		{
			// Step 3: switch to window and capture the title
			String winTitle = driver.switchTo().window(win).getTitle();
			
			// Step 4: compare the title with required partial title
			if(winTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method will take Screen shot and save in folder
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenshotname) throws IOException {
		
		 //Convert web driver object to TakeScreenshot
		TakesScreenshot src=((TakesScreenshot)driver);
		
		//Call getScreenshotAs method to create image file
		File srcfile=src.getScreenshotAs(OutputType.FILE);
		
		//Move image file to new destination
		File DestFile=new File(".\\ScreenShorts\\"+screenshotname+".png");
		
		 //Copy file at destination
		FileUtils.copyFile(srcfile, DestFile);
		
		return DestFile.getAbsolutePath(); // used for extend reports
	}
	
	/**
	 * This method will perform scroll downward vertically
	 * @param driver
	 */
	public void scrollaction(WebDriver driver) {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500");
	}
	
	public void scrollaction(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy0,"+y+")"+element);
		
	}
}
