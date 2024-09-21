package com.sharipov.tasklist.domain.repository;

import com.sharipov.tasklist.domain.task.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Optional<Task> findById(Long id);
    List<Task> findAllByUserId(Long userId);
    void assignToUserById(Long taskId, Long UserId);
    void update(Task task);
    void create(Task task);
    void delete(Long id);
}
