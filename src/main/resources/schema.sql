create table if not exists Users
(
    uuid     uuid primary key,
    name     varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null
);

create table if not exists Brand
(
    uuid uuid primary key,
    name varchar(255) not null
);

create table if not exists Car
(
    uuid     uuid primary key,
    name     varchar(255) not null,
    user_id  uuid,
    brand_id uuid         not null,
    CONSTRAINT fk_user foreign key (user_id) references Users (uuid),
    CONSTRAINT fk_brand foreign key (brand_id) references Brand (uuid) on delete cascade on update no action
);

create table if not exists Users_Roles
(
    user_id uuid         not null,
    role    varchar(255) not null,
    primary key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references Users (uuid) on delete cascade on update no action
);

