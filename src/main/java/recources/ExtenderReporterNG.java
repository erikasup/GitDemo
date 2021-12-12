package recources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenderReporterNG {
	
static ExtentReports extent;
	
	public static  ExtentReports getReportObject() {
		
		// ExtentReports, ExtentSparkReporter
		
		// kur raportas turetu buti sukurtas 
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation results");
		reporter.config().setDocumentTitle("Test rezultatai");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Erika");
		return extent;
		
	}
}
