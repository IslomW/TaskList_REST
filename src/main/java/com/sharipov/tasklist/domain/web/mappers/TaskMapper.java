package com.sharipov.tasklist.domain.web.mappers;

import com.sharipov.tasklist.domain.entity.task.Task;
import com.sharipov.tasklist.domain.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    List<TaskDto> toDto(List<Task> tasks);

    Task toEntity(TaskDto taskDto);

}
