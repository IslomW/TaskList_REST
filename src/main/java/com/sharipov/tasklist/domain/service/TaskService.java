package com.sharipov.tasklist.domain.service;

import com.sharipov.tasklist.domain.task.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface TaskService {
    Task getById(Long id);
    List<Task> findAllByUserId(Long userId);
    Task update(Task task);
    Task create(Task task, Long userId);
    void delete(Long id);
}
