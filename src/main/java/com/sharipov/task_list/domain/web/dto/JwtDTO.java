package com.sharipov.task_list.domain.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class JwtDTO {
    private String username;
    private String role;
}
