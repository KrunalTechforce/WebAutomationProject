package PageObejcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs_PO {

    WebDriver webDriver;

    public ContactUs_PO(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Custom Software Development Solutions')]")
    public WebElement VerifyHomePage;

    @FindBy(xpath = "//div[@id='hs-eu-cookie-confirmation-button-group']")
    public WebElement HandleCookiesPopup;

    ////////////////////////////Header Footer Contact Us Common Fields/////////////////////////////////
    @FindBy(xpath = "//div[@class='btn-box ml-3 rq']//a[contains(text(),'Contact Us')]")
    public WebElement ContactUsButton;

    @FindBy(xpath = "//h4[contains(text(),'Request A Proposal')]")
    public WebElement VerifyContactUsPage;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement FirstName;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement LastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement Email;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement PhoneNumber;

    @FindBy(xpath = "//select[@name='budget']")
    public WebElement SelectBudget;

    @FindBy(xpath = "//select[@name='service']")
    public WebElement SelectServices;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement Description;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement SubmitButton;

    @FindBy(xpath = "//img[@alt='Thank you page']")
    public WebElement SuccessThankYou;

    @FindBy(xpath = "//h2[contains(text(),'We have received your inquiry.')]")
    public WebElement ReceivedInquiryMSG;

    ////////////////////////////Header Footer Contact Us Common Fields/////////////////////////////////

    ////////////////////////////Footer Contact Us//////////////////////////////////////////////////////

    @FindBy(xpath = "//p[@class='title']")
    public WebElement ScrollFooterContactUS;

    @FindBy(xpath = "//input[@name='phonenumber']")
    public WebElement FooterPhoneNumber;

    @FindBy(xpath = "//select[@name='services']")
    public WebElement SelectFooterServices;

    ////////////////////////////Footer Contact Us/////////////////////////////////////////////////////

    ////////////////////////////Header Verification Messages Contact Us///////////////////////////////

    ////////////////////////////Header Verification Messages Contact Us///////////////////////////////
}
