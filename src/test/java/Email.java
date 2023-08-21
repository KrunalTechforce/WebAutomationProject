import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Email {

    @Test
    public void Email() throws EmailException, IOException {
        //Create the attachment
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String date1= dateFormat.format(date);
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("ExtentReport.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(date1 + " Test Report");
        attachment.setName(date1 + " Test Report");

        //Create the email message
        System.out.println("====================Start Sending====================");
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.office365.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("krunal.parekh@techforceglobal.com", "ggpxthmlbldjkxlf"));
        email.setSSLOnConnect(true);
        email.setStartTLSRequired(true);
        email.addTo("krunal.parekh@techforceglobal.com", "Krunal Parekh");
        //email.addTo("himanshu.tatariya@techforceglobal.com","Himanshu Tatariya");
        //email.addCc("bhavin.shah@techforceglobal.com", "Bhavin Shah");
        email.setFrom("krunaltechforce@gmail.com", "Krunal Parekh");
        email.setSubject(date1 + " Extent Test Report");
        email.setMsg(date1 + " Extent Test Report");

       //add the attachment
       email.attach(attachment);

        //send the email
        email.send();
        System.out.println("===================Mail Sent Successfully=========================");

    }

//        //Runtime Get Value fom concol
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What is yout name : ");
//        String Name = scanner.nextLine();
//        System.out.println("Hey %s , How are you ?" + Name);
//        String Status = scanner.nextLine();
//        System.out.println("What is your Age : ");
//        int age = scanner.nextInt();
//        System.out.println("Thank you!!! %d" + age);
//    }
}
