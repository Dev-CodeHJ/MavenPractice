create table if not exists board_dto(
                     id int primary key auto_increment,
                     member_id varchar(20),
                     title varchar(50),
                     content varchar(250)
);
