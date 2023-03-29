package practice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestPractice {
	
	@BeforeSuite
	public void create()
	{
		System.out.println("Custmer Created");
	}
	@BeforeMethod
	public void update()
	{
		System.out.println("Custmer Updated");
	}
	@AfterSuite
	public void delete()
	{
		System.out.println("Custmer Deleted");
		
	}
}
