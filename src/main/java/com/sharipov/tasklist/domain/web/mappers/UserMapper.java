package com.sharipov.tasklist.domain.web.mappers;

import com.sharipov.tasklist.domain.task.Task;
import com.sharipov.tasklist.domain.user.User;
import com.sharipov.tasklist.domain.web.dto.task.TaskDto;
import com.sharipov.tasklist.domain.web.dto.user.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto dto);
}
