package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;
import java.util.Locale;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports createInstance(){
        String fileName = getReportName();
        String directory = System.getProperty("user.dir") + "/reports/";
        new File(directory).mkdirs();
        String path = directory + fileName;
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Test Case Result");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.setSystemInfo("Test Run By:","Rajan Chaudhary");
        extent.setSystemInfo("Browser", WebDriverController.browser.toUpperCase(Locale.ROOT));
        extent.attachReporter(htmlReporter);

        return extent;
    }

    public static String getReportName(){
        //Date d = new Date();
        /*String fileName = "report_" + d.toString().replace(":","_").replace(" ","_")+".html";*/
        String fileName = "index.html";
        return fileName;
    }

}