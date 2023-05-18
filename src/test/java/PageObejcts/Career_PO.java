package PageObejcts;

import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Career_PO {

    WebDriver webDriver;

    public Career_PO(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Custom Software Development Solutions')]")
    public WebElement VerifyHomePage;

    @FindBy(xpath = "//div[@id='hs-eu-cookie-confirmation-button-group']")
    public WebElement HandleCookiesPopup;

    @FindBy(xpath = "//a[contains(text(),'Career')]")
    public WebElement CareerButton;

    @FindBy(xpath = "//a[contains(text(),'Apply Here')]")
    public WebElement ApplyHereButton;

    @FindBy(xpath = "//h6[contains(text(),'Application Form')]")
    public WebElement VerifyApplyFormPage;

    @FindBy(xpath = "//input[@name='fname']")
    public WebElement FirstName;

    @FindBy(xpath = "//input[@name='lname']")
    public WebElement LastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement Email;

    @FindBy(xpath = "//input[@name='mobilenumber']")
    public WebElement MobileNumber;

    @FindBy(xpath = "//select[@name='apply_job']")
    public WebElement SelectApplyFor;

    @FindBy(xpath = "//select[@name='txt_relocate']")
    public WebElement SelectRelocate;

    @FindBy(xpath = "//select[@name='txt_notice']")
    public WebElement SelectNoticePeriod;

    @FindBy(xpath = "//select[@name='txt_know_cliqtechno']")
    public WebElement SelectFindJobOpening;

    @FindBy(xpath = "//input[@id='myFile']")
    public WebElement ChooseFile;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement SelectCaptchaCheckbox;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement CaptchaFrame;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement SubmitButton;

    @FindBy(xpath = "//img[@alt='thank you']")
    public WebElement SuccessThankYou;

    @FindBy(xpath = "//h2[contains(text(),'We have received your Application. Thank you for submitting your application at Techforce Global')]")
    public WebElement ThankYouSuccessMSG;

}
