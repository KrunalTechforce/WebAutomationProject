package PageObejcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReCaptchaForm_PO {

    WebDriver webDriver;

    public ReCaptchaForm_PO(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//input[@id='apiKey']")
    public WebElement ApiKey;

    @FindBy(xpath = "//select[@id='service']")
    public WebElement Services;

    @FindBy(xpath = "//input[@id='Auto']")
    public WebElement AutoSubmitForm;

    @FindBy(xpath = "//input[@id='AutoClick']")
    public WebElement AutoClickCheckbox;

    @FindBy(xpath = "//span[@class='slider round']")
    public WebElement SwitchONOFF;

}
