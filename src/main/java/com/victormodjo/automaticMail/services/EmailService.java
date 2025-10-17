package com.victormodjo.automaticMail.services;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Service de gestion de l'envoi de mail
 */
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Transactional
    void sendTimeMail(String to, String name) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject("Heure Actuel...");
        mailMessage.setText("Bonjour " + name + " \uD83D\uDE0A  il est actuellement " + LocalDate.now() + ".");

        javaMailSender.send(mailMessage);
    }

    @Transactional
    public void welcomeMessage(String to, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Bienvenue sur Mail Automation ");
        message.setText("Bienvenue "+ name + """
   
                Nous sommes heureux de vous compter parmi nous !
                Votre inscription a bien été enregistrée.
                
                L’équipe Mail Automation.
                """);

        javaMailSender.send(message);
    }


}
