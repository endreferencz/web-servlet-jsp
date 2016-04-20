package com.epam.training;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

    private final String HOST = "smtp.gmail.com";
    private final String USERNAME = "sprinkler.training@gmail.com";
    private final String PASSWORD = "Secret123";

    public void sendMail(String to, EmailMessage message) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", HOST);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(USERNAME));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject(message.getSubject());
            mimeMessage.setText(message.getContent());

            Transport.send(mimeMessage);

        } catch (MessagingException mess) {
            mess.printStackTrace();
        }
    }
}
