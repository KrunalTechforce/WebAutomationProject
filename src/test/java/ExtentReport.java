import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class ExtentReport {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    @BeforeTest
    public void abc (){
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
    public void setUp()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.extentreports.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void launch1()
    {
        System.out.println("Demo Extent Report 1");
        test = reports.createTest("Launch Chrome Browser 1");
    }

    @Test
    public void launch2()
    {
        System.out.println("Demo Extent Report 2");
        test = reports.createTest("Launch Chrome Browser 2");
    }

    @AfterMethod
    public void getTestResult(ITestResult result)
    {
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
