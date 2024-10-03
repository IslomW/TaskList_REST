package com.sharipov.tasklist.domain.repository.impl;

import com.sharipov.tasklist.domain.exception.ResourceMappingException;
import com.sharipov.tasklist.domain.repository.DataSourceConfig;
import com.sharipov.tasklist.domain.repository.TaskRepository;
import com.sharipov.tasklist.domain.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {
    private final DataSourceConfig dataSourceConfig;

    private final String FIND_ALL_BY_USER_ID = """
            select t.id              as task_id,
                   t.title           as task_title,
                   t.description     as task_description,
                   t.expiration_date as task_expiration_date,
                   t.status          as task_status
            from tasks t
            join users_tasks ut on t.id = ut.task_id
            where ut.user_id = ?
            """;

    private final String FIND_BY_ID = """
            select t.id              as task_id,
                   t.title           as task_title,
                   t.description     as task_description,
                   t.expiration_date as task_expiration_date,
                   t.status          as task_status
            from tasks t
            where id = ?
            """;

    private final String ASSIGN = """
            insert into users_tasks (user_id, task_id)
            values (?,?)
            """;

    private final String UPDATE = """
            update tasks
            set title = ?,
                description = ?,
                expiration_date = ?,
                status = ?
            where id = ?
            """;

    private final String CREATE = """
            insert into tasks (title, description, status, expiration_date)
            values (?, ?, ?, ?)
            """;

    private final String DELETE = """
            delete from tasks
            where id = ?
            """;


    @Override
    public Optional<Task> findById(Long id) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);

        }catch (SQLException throwables){
            throw new ResourceMappingException("Error while finding user by id.");
        }

    }

    @Override
    public List<Task> findAllByUserId(Long userId) {
        return null;
    }

    @Override
    public void assignToUserById(Long taskId, Long UserId) {

    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void create(Task task) {

    }

    @Override
    public void delete(Long id) {

    }
}
