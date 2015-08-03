/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 *
 * @author Levi Barasa
 */
public class SendMail {

    public static void main(String[] args) {
        send("Test App", "lvbarasa@gmail.com", "", "lvbarasa@gmail.com", "<html>"
            + "<head>"
            + "</head>"
            + " <body>"
            + "     <h1>Dear Mail Crawler,</h1>"
            + "     <br/>"
            + "     <p>No spam to my email, please!</p>"
            + " </body>"
            + "</html>", "Test", "text/html; charset=utf-8");
    }

    public static void send(String accountName, final String source, final String sourcePassword, String destination, String content, String subject, String messageType) {
        try {
            Properties props = new Properties();
            props.put("mail.host", "192.168.0.115");
            props.put("mail.port", "25");
            props.put("mail.smtp.auth", "true");
            Session mailConnection = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(source, sourcePassword);
                    }
                });

            Message msg = new MimeMessage(mailConnection);

            Address from = new InternetAddress(source, accountName);
            InternetAddress[] iAddressArray = InternetAddress.parse(destination);
            msg.setContent(content, messageType);

            msg.setFrom(from);
            msg.setRecipients(Message.RecipientType.TO, iAddressArray);
            msg.setSubject(subject);

            Transport.send(msg);

            System.out.println("Sent email to: " + destination);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
