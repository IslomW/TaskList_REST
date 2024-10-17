package com.sharipov.task_list.domain.service;

import com.sharipov.task_list.domain.entity.profile.Profile;
import com.sharipov.task_list.domain.web.dto.ProfileDTO;

public interface ProfileService {
    Profile getById(Long id);
    Profile getByUsername(String username);
    Profile update(Profile profile);
    ProfileDTO create(ProfileDTO profileDTO);
    void delete(Long id);
}
