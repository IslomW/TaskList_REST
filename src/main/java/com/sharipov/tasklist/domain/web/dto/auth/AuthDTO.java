package com.sharipov.tasklist.domain.web.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDTO {
    @NotNull(message = "Username must be not null.")
    private String username;
    @NotNull(message = "Password must be not null.")
    private String password;
}
