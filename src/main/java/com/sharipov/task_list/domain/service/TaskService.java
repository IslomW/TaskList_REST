package com.sharipov.task_list.domain.service;

import com.sharipov.task_list.domain.entity.task.Task;

import java.util.List;

public interface TaskService {
    Task getById(Long id);
    List<Task> findAllByUserId(Long userId);
    Boolean update(Task task, Long id);
    Task create(Task task);
    void delete(Long id);
}
