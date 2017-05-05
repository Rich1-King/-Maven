package com.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by rich1 on 5/5/17.
 */
public class SpringMailClient{


    public static void main(String[] args){
        JavaMailSender javaMailSender = getJavaMailSender();

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setSubject("test mail");
        mail.setText("第一封邮件");
        mail.setTo("");
        mail.setFrom("");//必须设置，发送邮箱
        javaMailSender.send(mail);
    }

    public static JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setUsername(""); //服务器账号
        javaMailSender.setPassword(""); //服务器的密码
        javaMailSender.setHost("smtp-mail.outlook.com");
        Properties properties = new Properties();
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.host", "smtp-mail.outlook.com");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.stmp.ssl.enable", "true");//设置ssl为true，才能发送邮件
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

}
