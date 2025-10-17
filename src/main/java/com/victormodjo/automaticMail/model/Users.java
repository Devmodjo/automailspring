package com.victormodjo.automaticMail.model;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
}
