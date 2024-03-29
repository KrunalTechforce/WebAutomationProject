package TestCases;


import WebAppFunctions.WebAppFunction;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.maven.shared.utils.io.FileUtils;
import org.codehaus.plexus.util.IOUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class All_TestCases_With_ExtentReport{

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public static WebDriver webDriver;

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
    public void setUp() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("./config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String browser = properties.getProperty("browser");
        if (browser.equals("chrome"))
        {
//            ChromeOptions opt = new ChromeOptions();
//            opt.addExtensions(new File("6.4_0.crx"));
//            opt.addArguments("--headless");
//            opt.addArguments("--no-sandbox");
//            opt.addArguments("--disable-dev-shm-usage");
            webDriver = new ChromeDriver();
            webDriver.navigate().to("https://staging.techforce.global/");
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        else if (browser.equals("firefox"))
        {
//            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "./Drivers/geckodriver.exe");
            webDriver = new FirefoxDriver();
            webDriver.navigate().to("https://staging.techforce.global/");
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @Test(priority = 1)
    public void HeaderContactUS()
    {
        WebAppFunction webAppFunction = new WebAppFunction(webDriver);
        webAppFunction.Header_ContactUS();
    }

    @Test(priority = 2)
    public void FooterContactUS() throws InterruptedException {
        WebAppFunction webAppFunction = new WebAppFunction(webDriver);
        webAppFunction.Footer_ContactUs();
    }

    @Test(priority = 3)
    public void HireDedicatedDevelopers()
    {
        WebAppFunction webAppFunction = new WebAppFunction(webDriver);
        webAppFunction.HireDedicatedDevelopers();
    }

    @Test(priority = 4)
    public void DedicatedSoftwareTeams()
    {
        WebAppFunction webAppFunction = new WebAppFunction(webDriver);
        webAppFunction.DedicatedSoftwareTeams();
    }

    @Test(priority = 5)
    public void CaseStudies() throws InterruptedException {
        WebAppFunction webAppFunction = new WebAppFunction(webDriver);
        webAppFunction.CaseStudies();
    }

//    @Test(priority = 6)
//    public void Career() throws InterruptedException {
//        WebAppFunction webAppFunction = new WebAppFunction(webDriver);
//        webAppFunction.CareerApplyHere();
//    }

    public static String capture(WebDriver driver, String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"\\"+screenShotName+".PNG";
        System.out.println("dest : " + dest);
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        System.out.println("destination : " + destination);
        String path = destination.getAbsolutePath();

        InputStream is = new FileInputStream(dest);
        byte[] ssBytes = IOUtil.toByteArray(is);
        String base64 = Base64.getEncoder().encodeToString(ssBytes);

        return base64;
    }

    @AfterMethod
    public void getTestResult(ITestResult result) throws IOException
    {
        if (result.getStatus() == ITestResult.SUCCESS)
        {
            test = reports.createTest(result.getName()).assignCategory("Functional Test").assignDevice("Chrome").assignAuthor("Krunal Prekh");
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASS ", ExtentColor.GREEN));
        }
        else if (result.getStatus() == ITestResult.FAILURE)
        {
            String abc = capture(webDriver,"Fail Test");
            test = reports.createTest(result.getName()).assignCategory("Functional Test").assignDevice("Chrome").assignAuthor("Krunal Prekh");
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAIL ", ExtentColor.RED))
                    .addScreenCaptureFromBase64String(abc,result.getName())
                    .fail(result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SKIP)
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIP", ExtentColor.YELLOW));
        }
        webDriver.close();
    }

    @AfterTest
    public void Teardown() throws EmailException, InterruptedException {
        reports.flush();
        Thread.sleep(10000);

        //Create the attachment
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String date1= dateFormat.format(date);
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("ExtentReport.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(date1 + " Techforce WebAutomation HTML Test Report"+".html");
        attachment.setName(date1 + " Test Report ");

        //Create the email message
        System.out.println("====================Start Sending Mail====================");
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("krunaltechforce@gmail.com", "nawkikeptovheqxb"));
        email.setSSLOnConnect(true);
        email.addTo("krunal.parekh@techforceglobal.com", "Krunal Parekh");
        email.addTo("shivani.mehta@techforceglobal.com","Shivani Maheta");
        email.addTo("vedanshi.bhagat@techforceglobal.com","Vedanshi Bhagat");
        email.addTo("sanju.sanghadiya@techforceglobal.com","Sanju Sanghadiya");
        email.addCc("bhavin.shah@techforceglobal.com", "Bhavin Shah");
        email.setFrom("krunaltechforce@gmail.com", "Krunal Parekh");
        email.setSubject(date1 + " Techforce WebAutomation HTML Test Report ");
        email.setMsg(date1 + "\n\nNOTE : This is a HTML Test Report So Open In Any Browser For Viewing Report.\n\nThank You");
        //add the attachment
        email.attach(attachment);

        //send the email
        email.send();
        System.out.println("===================Mail Sent Successfully=========================");
    }
}
