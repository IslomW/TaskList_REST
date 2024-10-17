package com.sharipov.task_list.config;

import com.sharipov.task_list.domain.entity.profile.Profile;
import com.sharipov.task_list.domain.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Profile> optional = profileRepository.findByUsername(username);
        if (optional.isEmpty()){
            throw new UsernameNotFoundException(username);
        }
        Profile profile = optional.get();

        CustomUserDetails userDetails = new CustomUserDetails(profile);

        return userDetails;
    }
}
