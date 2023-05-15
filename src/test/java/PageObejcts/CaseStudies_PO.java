package PageObejcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseStudies_PO {

    WebDriver webDriver;

    public CaseStudies_PO(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Custom Software Development Solutions')]")
    public WebElement VerifyHomePage;

    @FindBy(xpath = "//a[contains(text(),'×')]")
    public WebElement HandleCookiesPopup;

    @FindBy(xpath = "//a[contains(text(),'Our Work')]")
    public WebElement OurWorkHeader;

    @FindBy(xpath = "//a[@title='Case Studies']")
    public WebElement CaseStudiesButton;

    @FindBy(xpath = "//h1[contains(text(),'Case Study')]")
    public WebElement VerifyCaseStudyPage;

    @FindBy(xpath = "//h4[contains(text(),'Blockchain Survey Solution')]")
    public WebElement Scroll;

    @FindBy(xpath = "//a[contains(@href,'blockchain-survey-solution')]/button")
    public WebElement ExploreButton;

    @FindBy(xpath = "//h1[contains(text(),'Blockchain Survey Solution')]")
    public WebElement VerifyBlockChainPage;

    @FindBy(xpath = "//a[@id='download-btn']")
    public WebElement DownloadPDFButton;

    @FindBy(xpath = "//h4[contains(text(),'Case Study')]")
    public WebElement VerifyCaseStudyPopup;

    @FindBy(xpath = "//input[@name='user_comapny_name']")
    public WebElement CompanyName;

    @FindBy(xpath = "//input[@name='user_email']")
    public WebElement EmailId;

    @FindBy(xpath = "//input[@name='user_name']")
    public WebElement Name;

    @FindBy(xpath = "//input[@name='user_phone']")
    public WebElement ContactNumber;

    @FindBy(xpath = "//input[@value='Download PDF']")
    public WebElement SubmitDownloadPDFButton;

    @FindBy(xpath = "//p[contains(text(),'Downloaded file successfully')]")
    public WebElement PDFDownloadSuccessfully;

    @FindBy(xpath = "//button[contains(text(),'×')]")
    public WebElement CaseStudyClosePopup;

}
