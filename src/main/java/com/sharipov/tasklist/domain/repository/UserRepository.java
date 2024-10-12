package com.sharipov.tasklist.domain.repository;

import com.sharipov.tasklist.domain.entity.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
User findByUsername(String username);
}
