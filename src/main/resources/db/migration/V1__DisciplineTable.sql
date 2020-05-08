CREATE TABLE TB_USER (
                         id int AUTO_INCREMENT UNIQUE,
                         name varchar(255) not null,
                         password varchar(255) not null,
                         email varchar(255) not null,
                         PRIMARY KEY (id)
);

CREATE TABLE TB_DISCIPLINE (
                               id int AUTO_INCREMENT UNIQUE,
                               name varchar(255) not null,
                               teacher varchar(255) not null,
                               absences int not null,
                               max_absences int not null,
                               user_id int not null,
                               primary key (id),
                               foreign key (user_id) references TB_USER(id)
);

