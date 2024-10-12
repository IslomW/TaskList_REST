package com.sharipov.tasklist.domain.service.impl;

import com.sharipov.tasklist.domain.exception.ResourceNotFoundException;
import com.sharipov.tasklist.domain.repository.UserRepository;
import com.sharipov.tasklist.domain.service.UserService;
import com.sharipov.tasklist.domain.entity.user.Role;
import com.sharipov.tasklist.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public User update(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public User create(User user) {
        if (userRepository.findByUsername(user.getUsername()).equals(user)){
            throw new IllegalStateException("User already exists");
        }
        if (!user.getPassword().equals(user.getPasswordConfirmation())){

            throw new IllegalStateException("Password and password confirmation do not match");
        }
          user.setPassword(encoder.encode(user.getPassword()));
          user.setRole(Role.ROLE_USER);
          userRepository.save(user);
//        userRepository.create(user);
//        Set<Role> roles = Set.of(Role.ROLE_USER);
//        userRepository.insertUserRole(user.getId(), Role.ROLE_USER);
//        user.setRoles(roles);

        return user;
    }


    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
