insert into users (name, username, password)
values ('Islom', 'tawkensky@gmail.com', '$2a$12$dmaFWqvC//MHxhB0z1U13.nF0K1qqfF8DOGXa916TiBXQoKsS12Ua'),
       ('Ilgar', 'baltun@gmail.com', '$2a$12$dmaFWqvC//MHxhB0z1U13.nF0K1qqfF8DOGXa916TiBXQoKsS12Ua');

insert into tasks(title, description, status, expiration_date)
values ('Buy cheese', null, 'TODO', '2024-09-24 12:00:00'),
       ('Do homework', 'Math, Physics, Literature', 'IN_PROGRESS', '2024-09-24 12:00:00'),
       ('Clean rooms', null, 'DONE', '2024-09-24 09:00:00'),
       ('Call islom', 'Ask about meeting', 'TODO', '2024-09-26 10:00:00');

insert into users_tasks (task_id, user_id)
values (1, 2),
       (2, 2),
       (3, 2),
       (4, 1);

insert into users_roles(user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');