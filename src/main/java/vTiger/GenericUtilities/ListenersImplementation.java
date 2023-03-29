package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	private String path;
	
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----Execuation Started");
		
		test=report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		
		test.log(Status.PASS,methodName+"----Pass");
	
	}

	public void onTestFailure(ITestResult result) {
		
		JavaUtility ju=new JavaUtility();
		WebDriverUtilite wdu=new WebDriverUtilite();
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL,methodName+"----File");
		test.log(Status.INFO,result.getThrowable());
		
		String screenshotname = methodName+"-"+ju.getSystemInFormat();
		try {
			wdu.takeScreenShot(BaseClass.sdriver, screenshotname);
			test.addScreenCaptureFromPath(screenshotname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.INFO, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("Suite Execuation Started");
		
		ExtentSparkReporter htmlReport =new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTIGER EXECUTION REPORT");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL","http://localhost:8888");
		report.setSystemInfo("Base BROWSER","Firefox");
		report.setSystemInfo("Reporter Name","Naveen King");
		
		
	}

	public void onFinish(ITestContext context) {
	
		System.out.println("Suite Execuation Finished");
		
		report.flush();
	}
	

}
