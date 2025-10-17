package com.victormodjo.automaticMail.services;

import com.victormodjo.automaticMail.model.Users;
import com.victormodjo.automaticMail.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Classe de planification de tâche
 */

@Service
@Slf4j
@EnableScheduling
public class SchedulerService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    public SchedulerService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = 300000) // toutes les 5 minutes
    public void sendEmailsToAllUsers() {
        List<Users> users = userRepository.findAll();
        log.info("Envoi automatique aux " + users.size() + " utilisateurs...");
        for (Users user : users) {
            emailService.sendTimeMail(user.getEmail(), user.getUsername());
        }
    }
}
