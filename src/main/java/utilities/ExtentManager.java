package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	private static ExtentReports extent = null;

	public static ExtentReports getInstance() {
		if (extent == null)
		{
			setExtentReports();
		}
		return extent;
	}

	public static ExtentReports  setExtentReports ()
	{
		ExtentHtmlReporter htmlReporter = null;
		htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setReportName("My Test Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");
		extent = new ExtentReports();
		extent.setSystemInfo("Platform", "Windows");
		extent.attachReporter(htmlReporter);
		return extent;
	}
}
