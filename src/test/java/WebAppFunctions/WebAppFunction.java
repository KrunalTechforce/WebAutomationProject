package WebAppFunctions;

import PageObejcts.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class WebAppFunction{

    WebDriver driver;
    public WebAppFunction(WebDriver remoteDriver)
    {
        driver = remoteDriver;
    }

    public void Header_ContactUS()
    {
        ContactUs_PO contactUsPo = new ContactUs_PO(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(contactUsPo.VerifyHomePage));
        Assert.assertEquals(contactUsPo.VerifyHomePage.getText(),"Custom Software Development Solutions");
        contactUsPo.HandleCookiesPopup.click();
        contactUsPo.ContactUsButton.click();
        wait.until(ExpectedConditions.visibilityOf(contactUsPo.VerifyContactUsPage));
        Assert.assertEquals(contactUsPo.VerifyContactUsPage.getText(),"Request A Proposal");
        contactUsPo.FirstName.sendKeys("Krunal");
        contactUsPo.LastName.sendKeys("Parekh");
        contactUsPo.Email.sendKeys("krunaltechforce@gmail.com");
        contactUsPo.PhoneNumber.sendKeys("7600285263");

        Select budget = new Select(contactUsPo.SelectBudget);
        budget.selectByVisibleText("Between 10K to 50K");

        Select option = new Select(contactUsPo.SelectServices);
        option.selectByVisibleText("Website Development");

        contactUsPo.Description.sendKeys("This is only for testing");
        contactUsPo.SubmitButton.click();
        wait.until(ExpectedConditions.visibilityOf(contactUsPo.SuccessThankYou));
        Assert.assertEquals(contactUsPo.ReceivedInquiryMSG.getText(),"We have received your inquiry.");
    }

    public void Footer_ContactUs() throws InterruptedException {
        ContactUs_PO contactUsPo = new ContactUs_PO(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(contactUsPo.VerifyHomePage));
        Assert.assertEquals(contactUsPo.VerifyHomePage.getText(),"Custom Software Development Solutions");
        contactUsPo.HandleCookiesPopup.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", contactUsPo.ScrollFooterContactUS);
        Thread.sleep(5000);
        contactUsPo.FirstName.sendKeys("Krunal");
        contactUsPo.LastName.sendKeys("Parekh");
        contactUsPo.Email.sendKeys("krunaltechforce@gmail.com");
        contactUsPo.FooterPhoneNumber.sendKeys("7600285263");

        Select option = new Select(contactUsPo.SelectFooterServices);
        option.selectByVisibleText("Website Development");

        contactUsPo.Description.sendKeys("This is only for testing");
        contactUsPo.SubmitButton.click();
        wait.until(ExpectedConditions.visibilityOf(contactUsPo.SuccessThankYou));
        Assert.assertEquals(contactUsPo.ReceivedInquiryMSG.getText(),"We have received your inquiry.");
    }

    public void ReCaptchaForm() throws InterruptedException {
        driver.navigate().to("chrome-extension://hapgiopokcmcnjmakciaeaocceodcjdn/options/main.html");
        ReCaptchaForm_PO reCaptchaFormPo = new ReCaptchaForm_PO(driver);
        Thread.sleep(5000);
        reCaptchaFormPo.ApiKey.sendKeys("84DCB52FB1FF48098EB80D905A56486D");
        Select services = new Select(reCaptchaFormPo.Services);
        services.selectByVisibleText("BestCaptchaSolver ($2.50/1000)");
        reCaptchaFormPo.AutoSubmitForm.click();
        reCaptchaFormPo.AutoClickCheckbox.click();
        reCaptchaFormPo.SwitchONOFF.click();
//        reCaptchaFormPo.SwitchONOFF.click();
    }

    public void CareerApplyHere() throws InterruptedException {
        ReCaptchaForm();
        driver.navigate().to("https://techforceglobal.com/");
        Career_PO careerPo = new Career_PO(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        wait.until(ExpectedConditions.visibilityOf(careerPo.VerifyHomePage));
        Assert.assertEquals(careerPo.VerifyHomePage.getText(),"Custom Software Development Solutions");
        careerPo.HandleCookiesPopup.click();
        careerPo.CareerButton.click();
        wait.until(ExpectedConditions.visibilityOf(careerPo.ApplyHereButton));
        String careerUrl = driver.getCurrentUrl();
//        Assert.assertEquals(careerUrl,"https://techforceglobal.com/career/");
        Assert.assertEquals(careerUrl,"https://staging.techforce.global/career/");
        careerPo.ApplyHereButton.click();
        String applynowUrl = driver.getCurrentUrl();
//        Assert.assertEquals(applynowUrl,"https://techforceglobal.com/career/applynow/");
        Assert.assertEquals(applynowUrl,"https://staging.techforce.global/career/applynow/");
        careerPo.FirstName.sendKeys("KrunalTest");
        careerPo.LastName.sendKeys("ParekhTest");
        careerPo.Email.sendKeys("krunaltechforce@gmail.com");
        careerPo.MobileNumber.sendKeys("7600285263");

        Select applingFor = new Select(careerPo.SelectApplyFor);
        applingFor.selectByVisibleText("Quality Assurance – Automation");

        Select communicateOffice = new Select(careerPo.SelectRelocate);
        communicateOffice.selectByVisibleText("Yes");

        Select noticePeriod = new Select(careerPo.SelectNoticePeriod);
        noticePeriod.selectByVisibleText("2 months");

        Select jobOpening = new Select(careerPo.SelectFindJobOpening);
        jobOpening.selectByVisibleText("Techforce Career");

        careerPo.ChooseFile.sendKeys("C:/Users/krunal.parekh/Downloads/sample.pdf");
        js.executeScript("window.scrollBy(0,250)");

        Thread.sleep(20000);

        careerPo.SubmitButton.click();

        wait.until(ExpectedConditions.visibilityOf(careerPo.SuccessThankYou));
        Assert.assertEquals(careerPo.ThankYouSuccessMSG.getText(),"We have received your Application. Thank you for submitting your application at Techforce Global");
    }

    public void HireDedicatedDevelopers()
    {
        Build_Your_Team_PO buildYourTeamPo = new Build_Your_Team_PO(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(buildYourTeamPo.VerifyHomePage));
        Assert.assertEquals(buildYourTeamPo.VerifyHomePage.getText(),"Custom Software Development Solutions");
        buildYourTeamPo.HandleCookiesPopup.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(buildYourTeamPo.BuildYourTeamHeader).build().perform();

        buildYourTeamPo.HireDedicatedDevButton.click();
        wait.until(ExpectedConditions.visibilityOf(buildYourTeamPo.VerifyHireDedicatedDevPage));
        String hirededicateddev = driver.getCurrentUrl();
//        Assert.assertEquals(hirededicateddev,"https://techforceglobal.com/hire-dedicated-developers/");
        Assert.assertEquals(hirededicateddev,"https://staging.techforce.global/hire-dedicated-developers/");
        Assert.assertEquals(buildYourTeamPo.VerifyHireDedicatedDevPage.getText(),"Hire Dedicated Offshore Developers");

        buildYourTeamPo.FirstName.sendKeys("KrunalTest");
        buildYourTeamPo.LastName.sendKeys("ParekhTest");
        buildYourTeamPo.Email.sendKeys("krunaltechforce@gmail.com");
        buildYourTeamPo.PhoneNumber.sendKeys("7600285263");
        buildYourTeamPo.Description.sendKeys("It's Just for testing");
        buildYourTeamPo.SubmitButton.click();

        wait.until(ExpectedConditions.visibilityOf(buildYourTeamPo.SuccessThankYou));
        Assert.assertEquals(buildYourTeamPo.ReceivedInquiryMSG.getText(),"We have received your inquiry.");
    }

    public void DedicatedSoftwareTeams()
    {
        Build_Your_Team_PO buildYourTeamPo = new Build_Your_Team_PO(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(buildYourTeamPo.VerifyHomePage));
        Assert.assertEquals(buildYourTeamPo.VerifyHomePage.getText(),"Custom Software Development Solutions");
        buildYourTeamPo.HandleCookiesPopup.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(buildYourTeamPo.BuildYourTeamHeader).build().perform();

        buildYourTeamPo.DedicatedSoftwareTeamsButton.click();
        wait.until(ExpectedConditions.visibilityOf(buildYourTeamPo.VerifyDedicatedSoftwarePage));
        String dedicatedsoftwareUrl = driver.getCurrentUrl();
//        Assert.assertEquals(dedicatedsoftwareUrl,"https://techforceglobal.com/custom-software-development-services/");
        Assert.assertEquals(dedicatedsoftwareUrl,"https://staging.techforce.global/custom-software-development-services/");
        Assert.assertEquals(buildYourTeamPo.VerifyDedicatedSoftwarePage.getText(),"Custom Software Development Service");

        buildYourTeamPo.FirstName.sendKeys("KrunalTest");
        buildYourTeamPo.LastName.sendKeys("ParekhTest");
        buildYourTeamPo.Email.sendKeys("krunaltechforce@gmail.com");
        buildYourTeamPo.PhoneNumber.sendKeys("7600285263");
        buildYourTeamPo.Description.sendKeys("It's Just for testing");
        buildYourTeamPo.SubmitButton.click();

        wait.until(ExpectedConditions.visibilityOf(buildYourTeamPo.SuccessThankYou));
        Assert.assertEquals(buildYourTeamPo.ReceivedInquiryMSG.getText(),"We have received your inquiry.");
    }

    public void CaseStudies() throws InterruptedException {
        CaseStudies_PO caseStudiesPo = new CaseStudies_PO(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(caseStudiesPo.VerifyHomePage));
        Assert.assertEquals(caseStudiesPo.VerifyHomePage.getText(),"Custom Software Development Solutions");
        caseStudiesPo.HandleCookiesPopup.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(caseStudiesPo.OurWorkHeader).build().perform();

        caseStudiesPo.CaseStudiesButton.click();
        wait.until(ExpectedConditions.visibilityOf(caseStudiesPo.VerifyCaseStudyPage));
        String casestudyUrl = driver.getCurrentUrl();
//        Assert.assertEquals(casestudyUrl,"https://techforceglobal.com/case-studies/");
        Assert.assertEquals(casestudyUrl,"https://staging.techforce.global/case-studies/");
        Assert.assertEquals(caseStudiesPo.VerifyCaseStudyPage.getText(),"Case Study");

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", caseStudiesPo.Scroll);
        Thread.sleep(2000);

        caseStudiesPo.ExploreButton.click();
        wait.until(ExpectedConditions.visibilityOf(caseStudiesPo.VerifyBlockChainPage));
        String blokchainPageUrl = driver.getCurrentUrl();
//        Assert.assertEquals(blokchainPageUrl,"https://techforceglobal.com/case-studies/blockchain-survey-solution/");
        Assert.assertEquals(blokchainPageUrl,"https://staging.techforce.global/case-studies/blockchain-survey-solution/");
        Assert.assertEquals(caseStudiesPo.VerifyBlockChainPage.getText(),"Blockchain Survey Solution");

        caseStudiesPo.DownloadPDFButton.click();
        wait.until(ExpectedConditions.visibilityOf(caseStudiesPo.VerifyCaseStudyPopup));
        Assert.assertEquals(caseStudiesPo.VerifyCaseStudyPopup.getText(),"Case Study");

        caseStudiesPo.CompanyName.sendKeys("Techforce");
        caseStudiesPo.EmailId.sendKeys("krunaltechforce@gmail.com");
        caseStudiesPo.Name.sendKeys("KrunalTest");
        caseStudiesPo.ContactNumber.sendKeys("7600285263");
        caseStudiesPo.SubmitDownloadPDFButton.click();

        wait.until(ExpectedConditions.visibilityOf(caseStudiesPo.PDFDownloadSuccessfully));
        Assert.assertEquals(caseStudiesPo.PDFDownloadSuccessfully.getText(),"Downloaded file successfully");

        caseStudiesPo.CaseStudyClosePopup.click();
    }
}
