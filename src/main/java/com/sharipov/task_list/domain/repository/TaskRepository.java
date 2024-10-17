package com.sharipov.task_list.domain.repository;

import com.sharipov.task_list.domain.entity.task.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Optional<Task> findAllByProfileId(Long id);
}
