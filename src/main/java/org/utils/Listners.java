package org.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Listners implements ITestListener {

  ExtentReports extentReport;
  ExtentReporter extentReporter = new ExtentReporter();
  ExtentTest ExtentTest;
    @Override
    public void onStart(ITestContext context) {
          extentReport = extentReporter.generateReport();
        System.out.println("Test case started and details are: " + context.getName());
    }
  @Override
    public void onTestStart(ITestResult result) {
    ExtentTest= extentReport.createTest(result.getName());
    ExtentTest.log(Status.INFO,result.getName() + "Test case started");
    System.out.println("Test case started and details are: " + result.getName());
  }
  @Override
    public void onTestSuccess(ITestResult result) {
      ExtentTest.log(Status.PASS,result.getName() + "Test case passed");
    System.out.println("Test case passed and details are: " + result.getName());
  }
  @Override
    public void onTestFailure(ITestResult result) {

    TakesScreenshot screenshot = (TakesScreenshot) BaseTest.driver;
    String path = System.getProperty("user.dir") + "/target/Screenshots/" + result.getName() + ".png";
    screenshot.getScreenshotAs(OutputType.FILE).renameTo(new File(path));
    ExtentTest.addScreenCaptureFromPath(path);
    ExtentTest.log(Status.INFO,result.getThrowable());
    ExtentTest.log(Status.FAIL,result.getName() + "Test case failed");
    System.out.println("Test case failed and details are: " + result.getName());
    System.out.println("Test case failed and details are: " + result.getThrowable());
  }

  @Override
    public void onTestSkipped(ITestResult result) {
      ExtentTest.log(Status.INFO,result.getThrowable());
    ExtentTest.log(Status.SKIP,result.getName() + "Test case skipped");
    System.out.println("Test case skipped and details are: " + result.getName());
    System.out.println("Test case failed and details are: " + result.getThrowable());
  }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
        try {
            Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "/target/ExtentReports/ExtentReport.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Test case finished and details are: " + context.getName());
  }


}
