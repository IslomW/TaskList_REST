package com.sharipov.tasklist.domain.service.impl;

import com.sharipov.tasklist.domain.exception.ResourceNotFoundException;
import com.sharipov.tasklist.domain.repository.TaskRepository;
import com.sharipov.tasklist.domain.service.TaskService;
import com.sharipov.tasklist.domain.entity.task.Status;
import com.sharipov.tasklist.domain.entity.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findAllByUserId(Long userId) {
        return taskRepository.findAllByUserId(userId);
    }

    @Override
    @Transactional
    public Task update(Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.TODO);
        }
        taskRepository.save(task);
        return task;
    }

    @Override
    @Transactional
    public Task create(Task task) {
        task.setStatus(Status.TODO);
        taskRepository.save(task);
        return task;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
