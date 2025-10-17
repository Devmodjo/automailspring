package com.victormodjo.automaticMail.controller;


import com.victormodjo.automaticMail.model.Users;
import com.victormodjo.automaticMail.repository.UserRepository;
import com.victormodjo.automaticMail.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Utilisateurs", description = "Endpoints pour la gestion des utilisateurs et l'envoi d'e-mails.")
public class UserController {

    private final UserRepository userRepository;
    private final EmailService emailService;

    /**
     * Enregistre un nouvel utilisateur et lui envoie un message de bienvenue.
     *
     * @param user objet JSON contenant le nom et l'adresse e-mail de l'utilisateur.
     * @return l'utilisateur sauvegardé dans la base de données.
     */
    @Operation(
            summary = "Créer un nouvel utilisateur",
            description = "Enregistre un utilisateur dans la base de données et lui envoie un e-mail de bienvenue."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur créé avec succès",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class))),
            @ApiResponse(responseCode = "400", description = "Données invalides fournies", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur", content = @Content)
    })
    @PostMapping
    public Users registerUser(@RequestBody Users user) {
        emailService.welcomeMessage(user.getEmail(), user.getUsername());
        return userRepository.save(user);
    }

    /**
     * Récupère la liste de tous les utilisateurs enregistrés.
     *
     * @return une liste d'utilisateurs.
     */
    @Operation(
            summary = "Lister tous les utilisateurs",
            description = "Renvoie la liste complète des utilisateurs enregistrés dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class))),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur", content = @Content)
    })
    @GetMapping
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}