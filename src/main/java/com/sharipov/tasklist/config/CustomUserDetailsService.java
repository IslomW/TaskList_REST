package com.sharipov.tasklist.config;

import com.sharipov.tasklist.domain.entity.user.User;
import com.sharipov.tasklist.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = Optional.ofNullable(userRepository.findByUsername(username));
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        User user = optional.get();

        CustomUserDetails userDetails = new CustomUserDetails(user);

        return userDetails;
    }
}
