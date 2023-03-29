create table if not exists board_dto(
                     board_id int primary key auto_increment,
                     member_id varchar(30),
                     title varchar(80),
                     content varchar(250)
);

create table if not exists member_dto(
                     member_id varchar(30) primary key,
                     pw varchar(50) not null,
                     name varchar(30) not null,
                     gender varchar(10),
                     email varchar(250) not null unique
);