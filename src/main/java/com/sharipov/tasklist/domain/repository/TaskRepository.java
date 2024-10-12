package com.sharipov.tasklist.domain.repository;

import com.sharipov.tasklist.domain.entity.task.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
List<Task> findAllByUserId(Long id);
}
