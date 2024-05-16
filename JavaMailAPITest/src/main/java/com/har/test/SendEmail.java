package com.har.test;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

    public static void main(String[] args) {
        // Sender's email address
       final String senderEmail = "xxx@gmail.com";
        // Sender's password
      final  String senderPassword = "yyy";

        // Receiver's email address
        String receiverEmail = "zzzz@gmail.com";

        // SMTP server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.starttls.required","true");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        // Authenticator to authenticate the sender's credentials
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        };

        // Session object with authenticator
        Session session = Session.getInstance(props, authenticator);

        try {
            // Creating a MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Setting sender's email
            message.setFrom(new InternetAddress(senderEmail));

            // Setting recipient's email
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));

            // Setting email subject
            message.setSubject("Test Email from JavaMail API");

            // Setting email body
            message.setText("Hello, this is a test email sent from JavaMail API.");

            // Sending the email
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

