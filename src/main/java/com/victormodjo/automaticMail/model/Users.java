package com.victormodjo.automaticMail.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
@Table(name = "_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "nom utilisateur obligatoires")
    private String username;
    @NotBlank(message = "l'adresse email est obligatoire")
    @Email(message = "format de l'adresse email incorrect")
    private String email;
}
