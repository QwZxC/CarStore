insert into Brand(uuid, name)
values (gen_random_uuid(), 'BMW'),
       (gen_random_uuid(), 'Mercedes-Benz'),
       (gen_random_uuid(), 'Lada'),
       (gen_random_uuid(), 'Haval'),
       (gen_random_uuid(), 'Audi');


insert into Users(uuid, name, username, password, balance)
values (gen_random_uuid(), 'Ivan Ivanov', 'ivan.ivanov@gmail.com',
        '$2a$10$UcKxhWXQOXsHo4CoiX0V9ul8LuJ1mLFroBS7E/y6cU2q7CBbVULje', 100000),
       (gen_random_uuid(), 'Jon Snow', 'jon.snow@gmail.com',
        '$2a$10$UcKxhWXQOXsHo4CoiX0V9ul8LuJ1mLFroBS7E/y6cU2q7CBbVULje', 100000);

insert into Car(uuid, name, user_id, brand_id)
values (gen_random_uuid(), 'BMW M5 f90', (select uuid from users where name = 'Jon Snow'),
        (select uuid from Brand where name = 'BMW')),
       (gen_random_uuid(), 'BMW M8 Competition Gran Coupe', (select uuid from users where name = 'Jon Snow'),
        (select uuid from Brand where name = 'BMW')),
       (gen_random_uuid(), 'Mercedes-Benz G-Class SUV', (select uuid from users where name = 'Ivan Ivanov'),
        (select uuid from Brand where name = 'Mercedes-Benz')),
       (gen_random_uuid(), 'Mercedes-AMG GT 4', (select uuid from users where name = 'Ivan Ivanov'),
        (select uuid from Brand where name = 'Mercedes-Benz'));

insert into Users_roles(user_uuid, role)
values ((select uuid
         from Users
         where name = 'Jon Snow'), 'ROLE_ADMIN'),
       ((select uuid
         from Users
         where name = 'Jon Snow'), 'ROLE_USER'),
       ((select uuid
         from Users
         where name = 'Ivan Ivanov'), 'ROLE_USER');

insert into Brand(uuid, name)
values (gen_random_uuid(), 'BMW'),
       (gen_random_uuid(), 'Mercedes-Benz'),
       (gen_random_uuid(), 'Lada'),
       (gen_random_uuid(), 'Haval'),
       (gen_random_uuid(), 'Audi');


insert into Users(uuid, name, username, password, balance)
values (gen_random_uuid(), 'Ivan Ivanov', 'ivan.ivanov@gmail.com',
        '$2a$10$UcKxhWXQOXsHo4CoiX0V9ul8LuJ1mLFroBS7E/y6cU2q7CBbVULje', 100000),
       (gen_random_uuid(), 'Jon Snow', 'jon.snow@gmail.com',
        '$2a$10$UcKxhWXQOXsHo4CoiX0V9ul8LuJ1mLFroBS7E/y6cU2q7CBbVULje', 100000);

insert into Car(uuid, name, user_id, brand_id)
values (gen_random_uuid(), 'BMW M5 f90', (select uuid from users where name = 'Jon Snow'),
        (select uuid from Brand where name = 'BMW')),
       (gen_random_uuid(), 'BMW M8 Competition Gran Coupe', (select uuid from users where name = 'Jon Snow'),
        (select uuid from Brand where name = 'BMW')),
       (gen_random_uuid(), 'Mercedes-Benz G-Class SUV', (select uuid from users where name = 'Ivan Ivanov'),
        (select uuid from Brand where name = 'Mercedes-Benz')),
       (gen_random_uuid(), 'Mercedes-AMG GT 4', (select uuid from users where name = 'Ivan Ivanov'),
        (select uuid from Brand where name = 'Mercedes-Benz'));

insert into Users_roles(user_uuid, role)
values ((select uuid
         from Users
         where name = 'Jon Snow'), 'ROLE_ADMIN'),
       ((select uuid
         from Users
         where name = 'Jon Snow'), 'ROLE_USER'),
       ((select uuid
         from Users
         where name = 'Ivan Ivanov'), 'ROLE_USER');

insert into Brand(uuid, name)
values (gen_random_uuid(), 'BMW'),
       (gen_random_uuid(), 'Mercedes-Benz'),
       (gen_random_uuid(), 'Lada'),
       (gen_random_uuid(), 'Haval'),
       (gen_random_uuid(), 'Audi');


insert into Users(uuid, name, username, password, balance)
values (gen_random_uuid(), 'Ivan Ivanov', 'ivan.ivanov@gmail.com',
        '$2a$10$UcKxhWXQOXsHo4CoiX0V9ul8LuJ1mLFroBS7E/y6cU2q7CBbVULje', 100000),
       (gen_random_uuid(), 'Jon Snow', 'jon.snow@gmail.com',
        '$2a$10$UcKxhWXQOXsHo4CoiX0V9ul8LuJ1mLFroBS7E/y6cU2q7CBbVULje', 100000);

insert into Car(uuid, name, user_id, brand_id)
values (gen_random_uuid(), 'BMW M5 f90', (select uuid from users where name = 'Jon Snow'),
        (select uuid from Brand where name = 'BMW')),
       (gen_random_uuid(), 'BMW M8 Competition Gran Coupe', (select uuid from users where name = 'Jon Snow'),
        (select uuid from Brand where name = 'BMW')),
       (gen_random_uuid(), 'Mercedes-Benz G-Class SUV', (select uuid from users where name = 'Ivan Ivanov'),
        (select uuid from Brand where name = 'Mercedes-Benz')),
       (gen_random_uuid(), 'Mercedes-AMG GT 4', (select uuid from users where name = 'Ivan Ivanov'),
        (select uuid from Brand where name = 'Mercedes-Benz'));

insert into Users_roles(user_uuid, role)
values ((select uuid
         from Users
         where name = 'Jon Snow'), 'ROLE_ADMIN'),
       ((select uuid
         from Users
         where name = 'Jon Snow'), 'ROLE_USER'),
       ((select uuid
         from Users
         where name = 'Ivan Ivanov'), 'ROLE_USER');

