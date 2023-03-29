package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {

	@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyzerImplemention.class)
	public void Practice() {
		
		System.out.println("Test Engnier");
		Assert.fail();
	}
}
