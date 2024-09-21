package com.sharipov.tasklist.domain.repository.impl;

import com.sharipov.tasklist.domain.repository.TaskRepository;
import com.sharipov.tasklist.domain.task.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class TaskRepositoryImpl implements TaskRepository {
    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAllByUserId(Long userId) {
        return null;
    }

    @Override
    public void assignToUserById(Long taskId, Long UserId) {

    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void create(Task task) {

    }

    @Override
    public void delete(Long id) {

    }
}
