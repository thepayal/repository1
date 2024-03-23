package commonUtiles;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerimplimentaion implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	JavaUtil jutil=new JavaUtil();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodname = result.getMethod().getMethodName();
		test=report.createTest("orgnaization");
		Reporter.log(methodname+"Testscript execution is start",true);
		test=report.createTest(methodname);
	}
     
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		//test=report.createTest("Orgnaization");
		Reporter.log(methodname+"Testscript execution is pass",true);
		test=report.createTest(methodname);
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is failed",true);
		test.log(Status.FAIL,"Testscript execution is failed");
		
		WebDriverUtil webutil=new WebDriverUtil();
		try {
			String path = webutil.Screenshot(BaseClass.sdriver);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
	
		Reporter.log(methodname+"Testscript execution is skipped",true);
		test.log(Status.PASS,"Testscript execution is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter esr = new ExtentSparkReporter("./Extentreport/report.html"+jutil.randomnumber(null));
		esr.config().setReportName("vTigercrm");
		esr.config().setTheme(Theme.DARK);
		esr.config().setDocumentTitle("VTiger");
		
		//To generate extent reports
		 report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Chrome", "122");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Author", "Payal");
		
	}

	public void onFinish(ITestContext context) {
	 report.flush();
	}
}
