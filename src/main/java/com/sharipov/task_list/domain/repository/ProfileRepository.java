package com.sharipov.task_list.domain.repository;

import com.sharipov.task_list.domain.entity.profile.Profile;
import com.sharipov.task_list.domain.entity.task.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Optional<Profile> findByUsername(String username);
}
