package com.sharipov.tasklist.domain.repository.impl;

import com.sharipov.tasklist.domain.repository.UserRepository;
import com.sharipov.tasklist.domain.user.Role;
import com.sharipov.tasklist.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final String FIND_BY_ID = """
            select u.id              as user_id,
                   u.name            as user_name,
                   u.username        as user_username,
                   u.password        as user_password,
                   ur.role           as user_user_role,
                   t.id              as task_id,
                   t.title           as task_title,
                   t.description     as task_description,
                   t.expiration_date as task_expiration_date,
                   t.status          as task_status
            from users u
                     left join users_roles ur on u.id = ur.user_id
                     left join users_tasks ut on u.id = ut.user_id
                     left join tasks t on ut.task_id = t.id
            where u.id = ?
            """;

    private final String FIND_BY_USER_NAME = """
            select u.id              as user_id,
                   u.name            as user_name,
                   u.username        as user_username,
                   u.password        as user_password,
                   ur.role           as user_user_role,
                   t.id              as task_id,
                   t.title           as task_title,
                   t.description     as task_description,
                   t.expiration_date as task_expiration_date,
                   t.status          as task_status
            from users u
                     left join users_roles ur on u.id = ur.user_id
                     left join users_tasks ut on u.id = ut.user_id
                     left join tasks t on ut.task_id = t.id
            where u.username = ?
            """;

    private final String UPDATE = """
            update users
            set name     = ?,
                username = ?,
                password = ?
            where id = ?
                        
            """;

    private final String CREATE = """
            insert into users (name, username, password)
            values (?, ?, ?);
            """;

    private final String IS_TASK_OWNER = """
            select exists(
                           select 1
                           from users_tasks
                           where user_id = ?,
                           and task_id = ?
                       )
            """;
    private final String DELETE = """
            delete
            from users
            where id = ?
            """;
    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void create(User user) {

    }

    @Override
    public void insertUserRole(Long userId, Role role) {

    }

    @Override
    public boolean isTaskOwner(Long userId, Long taskId) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }
}
