package com.sharipov.tasklist.domain.service;

import com.sharipov.tasklist.domain.entity.task.Task;

import java.util.List;


public interface TaskService {
    Task getById(Long id);
    List<Task> findAllByUserId(Long userId);
    Task update(Task task);
    Task create(Task task);
    void delete(Long id);
}
