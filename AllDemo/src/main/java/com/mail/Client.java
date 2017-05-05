package com.mail;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by sunchong on 2016/7/29.
 */
public class Client{
    public static void main(String[] args) throws MessagingException{
        String username = "";
        String password = "";

        Properties properties = new Properties();

        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.host", "smtp-mail.outlook.com");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.stmp.ssl.enable", "true");//设置ssl为true，才能发送邮件

        Session session = Session.getInstance(properties);

        Message message = new MimeMessage(session);

        message.setSubject("test mail");
        message.setText("第一封邮件");
        message.setFrom(new InternetAddress("schongking@outlook.com"));
        javax.mail.Transport transport = session.getTransport();
        transport.connect(username,password);
        transport.sendMessage(message, new Address[]{new InternetAddress("970378898@qq.com")});

        transport.close();
    }
}
