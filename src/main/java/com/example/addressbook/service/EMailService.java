package com.example.addressbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String subject, String to, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("shaileshdubeyr@gmail.com");
        message.setTo(to);
        message.setText(body);
        message.setSubject(subject);
        File file = new File("C:/Users/Admin/Desktop/vector_assingment/Pointers.pdf");

        javaMailSender.send(message);
        System.out.println("mail is sent successfully");
    }

    public String textBody(String body) {
        return "this is verification mail" + body;
    }

    public void updateEmail(String subject, String to, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("shaileshdubeyr@gmail.com");
        message.setTo(to);
        message.setText(body);
        message.setSubject(subject);
        javaMailSender.send(message);
        System.out.println("mail sent successfully");
    }
}
