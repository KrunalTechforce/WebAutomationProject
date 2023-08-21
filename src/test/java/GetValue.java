import PageObejcts.ContactUs_PO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v110.systeminfo.model.Size;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Scanner;

public class GetValue {


    //Runtime Get Value from Console
    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        ContactUs_PO contactUsPo = new ContactUs_PO(driver);
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Your FirstName : ");
//        String Firstname = scanner.nextLine();
//
//        System.out.println("Enter Your LastName : ");
//        String Lastname = scanner.nextLine();
//
//        System.out.println("Enter Your Email : ");
//        String Email = scanner.nextLine();
//
//        System.out.println("Enter Your PhoneNumber : ");
//        String PhoneNumber = scanner.nextLine();
//
//        System.out.println("Select Budget : ");
//        String SelectBudget = scanner.nextLine();
//
//        System.out.println("Select Services : ");
//        String SelectService = scanner.nextLine();
//
//        System.out.println("Enter Your Description : ");
//        String Description = scanner.nextLine();
//
//        WebDriver driver = new ChromeDriver();
//        driver.navigate().to("https://staging.techforce.global/");
//        driver.manage().window().maximize();
//
//        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Search);
//
//        ContactUs_PO contactUsPo = new ContactUs_PO(driver);
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(contactUsPo.VerifyHomePage));
//        Assert.assertEquals(contactUsPo.VerifyHomePage.getText(),"Custom Software Development Solutions");
//        contactUsPo.HandleCookiesPopup.click();
//        contactUsPo.ContactUsButton.click();
//        wait.until(ExpectedConditions.visibilityOf(contactUsPo.VerifyContactUsPage));
//        Assert.assertEquals(contactUsPo.VerifyContactUsPage.getText(),"Request A Proposal");
//        contactUsPo.FirstName.sendKeys(Firstname);
//        contactUsPo.LastName.sendKeys(Lastname);
//        contactUsPo.Email.sendKeys(Email);
//        contactUsPo.PhoneNumber.sendKeys(PhoneNumber);
//
//        Select budget = new Select(contactUsPo.SelectBudget);
//        budget.selectByVisibleText(SelectBudget);
//
//        Select option = new Select(contactUsPo.SelectServices);
//        option.selectByVisibleText(SelectService);
//
//        contactUsPo.Description.sendKeys(Description);
//        contactUsPo.SubmitButton.click();
//        wait.until(ExpectedConditions.visibilityOf(contactUsPo.SuccessThankYou));
//        Assert.assertEquals(contactUsPo.ReceivedInquiryMSG.getText(),"We have received your inquiry.");


//        //How to store input values in array
//        System.out.println("Enter Value In Array : ");
//        String input = scanner.nextLine();
//        String[] stringArr = input.split(" ");
//        for (int i = 0; i < stringArr.length; i++)
//        {
//            System.out.println(stringArr[i]);
//        }

    }

}
