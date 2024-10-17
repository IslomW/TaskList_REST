package com.sharipov.task_list.domain.service.impl;

import com.sharipov.task_list.domain.entity.task.Task;
import com.sharipov.task_list.domain.exception.ResourceNotFoundException;
import com.sharipov.task_list.domain.repository.TaskRepository;
import com.sharipov.task_list.domain.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found."));
    }

    @Override
    public List<Task> findAllByUserId(Long userId) {
        List<Task> tasks = (List<Task>) taskRepository.findAllByProfileId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        return tasks;

    }

    @Override
    public Boolean update(Task task, Long id) {
//        Task exist = getById(id);
//        Long userId =

        return true;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
