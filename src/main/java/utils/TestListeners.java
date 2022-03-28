package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestListeners implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.createInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest test = extent.createTest(result.getTestClass().getName()+" :: "
                + result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        String logText = "<b>Test Method " + result.getMethod().getMethodName() +
                "Successful</b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.get().log(Status.PASS,markup);
    }

    @Override
    public void onTestSkipped(ITestResult result){
        String logText = "<b>Test Method " + result.getMethod().getMethodName() +
                "Skipped</b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        extentTest.get().log(Status.SKIP,markup);
    }

    @Override
    public void onTestFailure(ITestResult result){
        String logText = "<b>Test Method " + result.getMethod().getMethodName() +
                "Failed</b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
        extentTest.get().log(Status.FAIL,markup);
        extentTest.get().log(Status.INFO,result.getThrowable());
        SlackReporter.failedTestList.add(result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        SlackReporter.sendMessageToSlack(context);
        if(extent!=null){
            extent.flush();
        }
        WebDriverController.closeBrowser();//This will close browser instance after completion
    }
}
