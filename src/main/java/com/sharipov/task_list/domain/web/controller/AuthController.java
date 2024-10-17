package com.sharipov.task_list.domain.web.controller;

import com.sharipov.task_list.domain.entity.profile.Profile;
import com.sharipov.task_list.domain.service.ProfileService;
import com.sharipov.task_list.domain.web.dto.ProfileDTO;
import com.sharipov.task_list.domain.web.mappers.ProfileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ProfileService profileService;


    @PostMapping("/registration")
    public ProfileDTO registration(@RequestBody ProfileDTO profileDTO) {
        ProfileDTO result = profileService.create(profileDTO);
        return ResponseEntity.ok(result).getBody();
    }
}
