package com.sharipov.task_list.domain.web.mappers;

import com.sharipov.task_list.domain.entity.task.Task;
import com.sharipov.task_list.domain.web.dto.TaskDTO;
import org.springframework.stereotype.Component;


@Component
public class TaskMapper {
    public Task TaskDTOTOEntity(TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        return task;
    }

    public TaskDTO TaskEntityToDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setExpirationDate(task.getExpirationDate());
        dto.setStatus(task.getStatus());
        return dto;
    }
}
