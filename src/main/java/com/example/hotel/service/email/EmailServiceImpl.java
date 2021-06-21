package com.example.hotel.service.email;

import com.example.hotel.model.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;
    @Value("${app.host.name}")
    private String hostName;

    @Override
    public void sendConfirm(User user) {

        String hash = user.getCookie();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(user.getEmail());
        message.setSubject("Подтверждение Email в гостинице.");
        message.setText("Здравствуйте, для подтверждения Email необходимо перейти по ссылке: http://" +
                        hostName + "/users/confirm?id=" + user.getId() + "&hash=" + hash);

        this.emailSender.send(message);
    }

    @Override
    public void sendUserData(User user) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(user.getEmail());
        message.setSubject("Добро пожаловать в гостиницу!");
        message.setText("Здравствуйте, вы были зарегистрированны на сайте гостиницы! \nВаш логин: " + user.getLogin()+
                " \nВаш пароль: " + user.getPassword());

        this.emailSender.send(message);
    }
}
