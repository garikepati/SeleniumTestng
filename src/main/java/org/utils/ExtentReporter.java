package org.utils;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;

import java.io.File;
import java.util.Date;

public class ExtentReporter {
    public ExtentReports extentReports;
    public ExtentReports generateReport() {

        extentReports= new ExtentReports();
        ReadPropertyfile propertyfile = new ReadPropertyfile();

        File extentreportfile= new File(System.getProperty("user.dir")+"/target/ExtentReports/ExtentReport.html");
        ExtentSparkReporter spark = new ExtentSparkReporter(extentreportfile);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Extent Report");
        spark.config().setEncoding("utf-8");
        spark.config().setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
        extentReports.attachReporter(spark);
        extentReports.setSystemInfo("Tester", "kowsik");
        extentReports.setSystemInfo("Browser", propertyfile.propertyFile("browser"));
        extentReports.setSystemInfo("OS", "Windows");
        extentReports.setSystemInfo("Java Version", "17");
        extentreportfile.setReadable(true);
        System.out.println("Generating Extent Report");
        return extentReports;
    }
}
