import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

import java.net.Authenticator;

public class Email1 {

    public static void main(String[] args) throws EmailException {

        System.out.println("====================Start Sending====================");
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("krunaltechforce@gmail.com", "nawkikeptovheqxb"));
        email.setSSLOnConnect(true);
        email.setFrom("krunaltechforce@gmail.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("parekhkrunal1997@gmail.com");
        email.send();
        System.out.println("===================End Sending=========================");
    }
}
