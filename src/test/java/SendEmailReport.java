import org.apache.commons.mail.*;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SendEmailReport {

    @Test
    public void SendReportEmail() throws EmailException {
         //Create the attachment
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String date1= dateFormat.format(date);
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("./test-output/emailable-report.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(date1 + " Test Report");
        attachment.setName(date1 + " Test Report");

         //Create the email message
        System.out.println("====================Start Sending====================");
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("krunaltechforce@gmail.com", "nawkikeptovheqxb"));
        email.setSSLOnConnect(true);
        email.addTo("parekhkrunal1997@gmail.com", "Krunal Parekh");
        email.setFrom("krunaltechforce@gmail.com", "Techforce");
        email.setSubject(date1 + " Test Report");
        email.setMsg(date1 + " Test Report");

         //add the attachment
        email.attach(attachment);

         //send the email
        email.send();
        System.out.println("===================Mail Sent Successfully=========================");
    }
}
