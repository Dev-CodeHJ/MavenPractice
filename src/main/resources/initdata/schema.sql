drop table if exists board_dto;


create table board_dto(
                     id int primary key auto_increment,
                     member_id varchar(20),
                     title varchar(50),
                     content varchar(250)
);