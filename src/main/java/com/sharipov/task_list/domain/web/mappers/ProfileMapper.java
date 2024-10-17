package com.sharipov.task_list.domain.web.mappers;

import com.sharipov.task_list.domain.entity.profile.Profile;
import com.sharipov.task_list.domain.web.dto.ProfileDTO;
import org.springframework.stereotype.Component;


@Component
public class ProfileMapper {

    public Profile profileDTOToEntity(ProfileDTO dto){
        Profile profile = new Profile();
        profile.setName(dto.getName());
        profile.setUsername(dto.getUsername());
        profile.setPassword(dto.getPassword());
        profile.setPasswordConfirmation(dto.getPasswordConfirmation());
        return profile;
    }


    public ProfileDTO profileEntityToDTO(Profile profile){
        ProfileDTO dto = new ProfileDTO();
        dto.setName(profile.getName());
        dto.setUsername(profile.getUsername());
        return dto;
    }
}
