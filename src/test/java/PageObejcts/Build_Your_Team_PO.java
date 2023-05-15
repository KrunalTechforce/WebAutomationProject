package PageObejcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Build_Your_Team_PO {

    WebDriver webDriver;

    public Build_Your_Team_PO(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Custom Software Development Solutions')]")
    public WebElement VerifyHomePage;

    @FindBy(xpath = "//a[contains(text(),'×')]")
    public WebElement HandleCookiesPopup;

    /////////////////////////////////Hire Dedicated Developers/////////////////////////////////

    @FindBy(xpath = "//a[contains(text(),'Build your team')]")
    public WebElement BuildYourTeamHeader;

    @FindBy(xpath = "//a[contains(text(),'Hire Dedicated Developers')]")
    public WebElement HireDedicatedDevButton;

    @FindBy(xpath = "//h1[contains(text(),'Hire Dedicated Offshore Developers')]")
    public WebElement VerifyHireDedicatedDevPage;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement FirstName;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement LastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement Email;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement PhoneNumber;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement Description;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement SubmitButton;

    @FindBy(xpath = "//img[@alt='Thank you page']")
    public WebElement SuccessThankYou;

    @FindBy(xpath = "//h2[contains(text(),'We have received your inquiry.')]")
    public WebElement ReceivedInquiryMSG;

    /////////////////////////////////Hire Dedicated Developers/////////////////////////////////

    /////////////////////////////////Dedicated Software Teams//////////////////////////////////

    @FindBy(xpath = "//a[contains(@href,'custom-software-development-services')]")
    public WebElement DedicatedSoftwareTeamsButton;

    @FindBy(xpath = "//h1[contains(text(),'Custom Software Development Service')]")
    public WebElement VerifyDedicatedSoftwarePage;


    /////////////////////////////////Dedicated Software Teams//////////////////////////////////
}
