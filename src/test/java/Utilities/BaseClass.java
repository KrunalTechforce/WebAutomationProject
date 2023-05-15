package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass{

    public static WebDriver webDriver;

    @BeforeMethod
    public void setUp() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("./config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String browser = properties.getProperty("browser");

        if (browser.equals("chrome"))
        {
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
            ChromeOptions opt = new ChromeOptions();
            opt.addExtensions(new File("6.4_0.crx"));
            webDriver = new ChromeDriver(opt);
            webDriver.navigate().to("https://techforceglobal.com/");
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        else if (browser.equals("firefox"))
        {
//            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "./Drivers/geckodriver.exe");
            webDriver = new FirefoxDriver();
            webDriver.navigate().to("https://techforceglobal.com/");
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
}
