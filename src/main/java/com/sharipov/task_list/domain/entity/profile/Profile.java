package com.sharipov.task_list.domain.entity.profile;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;

    @Transient
    private String passwordConfirmation;
    private GeneralStatus status;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
