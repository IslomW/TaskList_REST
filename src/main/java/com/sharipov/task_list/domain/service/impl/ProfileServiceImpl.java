package com.sharipov.task_list.domain.service.impl;

import com.sharipov.task_list.domain.entity.profile.GeneralStatus;
import com.sharipov.task_list.domain.entity.profile.Profile;
import com.sharipov.task_list.domain.entity.profile.Role;
import com.sharipov.task_list.domain.exception.ResourceNotFoundException;
import com.sharipov.task_list.domain.repository.ProfileRepository;
import com.sharipov.task_list.domain.service.ProfileService;
import com.sharipov.task_list.domain.web.dto.ProfileDTO;
import com.sharipov.task_list.domain.web.mappers.ProfileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private PasswordEncoder passwordEncoder;

    private final ProfileRepository profileRepository;

    private final ProfileMapper mapper;

    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task Not Found."));
    }

    @Override
    public Profile getByUsername(String username) {
        return profileRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Task Not Found."));
    }

    @Override
    public Profile update(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public ProfileDTO create(ProfileDTO profileDTO) {
        Profile profile = mapper.profileDTOToEntity(profileDTO);
        profile.setPassword(passwordEncoder.encode(profileDTO.getPassword()));
        profile.setStatus(GeneralStatus.ACTIVE);
        profile.setRole(Role.ROLE_USER);
        profileRepository.save(profile);

        return mapper.profileEntityToDTO(profile);
    }

    @Override
    public void delete(Long id) {
        profileRepository.deleteById(id);
    }
}
