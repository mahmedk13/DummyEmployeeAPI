package Utility;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentHtmlReporter htmlReporter ;
	private static ExtentReports extent;
	
	private static String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\ExecutionReports\\extentreports.html";;
	
	public static ExtentReports getInstance() {
		
		if(extent!=null) {
			return extent;
		}else {
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter());
			extent.setSystemInfo("Host Name", "Dummy API");
			extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
			extent.setSystemInfo("Windows", "10");
			return extent;

			
		}
	}
		
	public static ExtentHtmlReporter getHtmlReporter() {
		htmlReporter= new ExtentHtmlReporter(filePath);
		htmlReporter.setAppendExisting(false);
		htmlReporter.config().setDocumentTitle("Execution Report");
		htmlReporter.config().setReportName("Automation Suite");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\PropertyFiles\\extent-config.xml");
		return htmlReporter;
		
	}
		
	
	

}
