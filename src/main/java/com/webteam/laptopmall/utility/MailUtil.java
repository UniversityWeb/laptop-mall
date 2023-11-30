package com.webteam.laptopmall.utility;

import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.*;

public class MailUtil {

    public static void sendMail(String to, String from, String subject, String body)
            throws MessagingException{
        Properties props = new Properties();
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.quitwait", "false");

        System.setProperty("mail.smtp.ssl.ciphersuites", "TLS_AES_128_GCM_SHA256");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        Message message = new MimeMessage(session);
        message.setSubject(subject);
        message.setContent(body, "text/html; charset=UTF-8");

        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        Transport transport = session.getTransport();

        try {
            transport.connect("vanantran009@gmail.com", "slqohvgrgtqkftbp");
            transport.sendMessage(message, message.getAllRecipients());
        } finally {
            transport.close();
        }
    }
}
