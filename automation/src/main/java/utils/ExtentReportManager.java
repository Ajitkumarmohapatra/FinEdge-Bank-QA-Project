package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir")+"/test-output/ExtentReport.html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            sparkReporter.config().setDocumentTitle("Mifos Automation Report");
            sparkReporter.config().setReportName("Mifos X Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "Mifos X");
            extent.setSystemInfo("Tester", "Ajit Kumar");
            extent.setSystemInfo("Environment", "Local");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("OS", "Windows 11");
        }

        return extent;
    }
}
