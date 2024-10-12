package com.sharipov.tasklist.domain.web.mappers;


import com.sharipov.tasklist.domain.entity.user.User;
import com.sharipov.tasklist.domain.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto dto);
}
