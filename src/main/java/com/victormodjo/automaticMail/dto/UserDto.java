package com.victormodjo.automaticMail.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDto(

        @NotBlank(message = "le nom utilisateur est obligatoire")
        String usename,
        @NotBlank(message = "l'adresse email est obligatoire")
        @Email
        String email
) {
}
