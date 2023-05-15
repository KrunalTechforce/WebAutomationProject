package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass1 {

    public static WebDriver webDriver;

    public ExtentSparkReporter htmlReporter;
    public ExtentReports reports;
    public ExtentTest test;

    @BeforeTest
    public void abc () throws IOException {
        htmlReporter = new ExtentSparkReporter("ExtentReport.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("Machine","acer");
        reports.setSystemInfo("OS","Windows 10");
        reports.setSystemInfo("User","Krunal Parekh");
        reports.setSystemInfo("Browser","Chrome");

        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        FileInputStream fileInputStream = new FileInputStream("./config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String browser = properties.getProperty("browser");

        if (browser.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
//            ChromeOptions opt = new ChromeOptions();
//            opt.addExtensions(new File("6.4_0.crx"));
            webDriver = new ChromeDriver();
            webDriver.navigate().to("https://techforceglobal.com/");
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @AfterMethod
    public void getTestResult(ITestResult result)
    {
//        webDriver.close();
        if (result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASS ", ExtentColor.GREEN));
        }
        else if (result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "FAIL", ExtentColor.RED));
        }
        else if (result.getStatus() == ITestResult.SKIP)
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIP", ExtentColor.YELLOW));
        }
    }

    @AfterTest
    public void Teardown()
    {
        reports.flush();
    }
}
