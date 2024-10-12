package com.sharipov.tasklist.domain.entity.user;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String passwordConfirmation;


    private Role role;
}
