package com.sharipov.tasklist.domain.web.controller;


import com.sharipov.tasklist.domain.service.TaskService;
import com.sharipov.tasklist.domain.service.UserService;
import com.sharipov.tasklist.domain.task.Task;
import com.sharipov.tasklist.domain.user.User;
import com.sharipov.tasklist.domain.web.dto.task.TaskDto;
import com.sharipov.tasklist.domain.web.dto.user.UserDto;
import com.sharipov.tasklist.domain.web.dto.vadlidation.OnCreate;
import com.sharipov.tasklist.domain.web.dto.vadlidation.OnUpdate;
import com.sharipov.tasklist.domain.web.mappers.TaskMapper;
import com.sharipov.tasklist.domain.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto dto){
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id){
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id){
        List<Task> tasks = taskService.findAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.delete(id);
    }

    @PostMapping("/{id}/tasks")
    public TaskDto createTask(@PathVariable Long id,
                              @Validated(OnCreate.class) @RequestBody TaskDto dto){
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }
}
