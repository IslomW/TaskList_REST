package com.sharipov.task_list.domain.web.dto;

import com.sharipov.task_list.domain.entity.task.Status;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class TaskDTO {
    private String title;

    private String description;
    private Status status;

    private LocalDateTime expirationDate;
}
