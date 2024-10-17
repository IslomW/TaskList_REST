package com.sharipov.task_list.domain.web.dto;


import lombok.Data;

@Data
public class ProfileDTO {

    private String name;

    private String username;

    private String password;

    private String passwordConfirmation;

}
