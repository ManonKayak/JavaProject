create table programmer
(
    id   int auto_increment
        primary key,
    lastname TEXT not null,
    firstname TEXT not null,
    address TEXT not null,
    pseudo TEXT not null,
    manager TEXT not null,
    hobby TEXT not null,
    birth_year INT not null,
    salary DECIMAL(6,2) not null,
    bonus DECIMAL(6,2) not null
);
