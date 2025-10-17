package com.victormodjo.automaticMail.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
@Table(name = "_users")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "le nom utilisateur est obiligatoire")
    private String username;
    @Email
    private String email;

}
