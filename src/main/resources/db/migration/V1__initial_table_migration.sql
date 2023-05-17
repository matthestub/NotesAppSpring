drop table if exists note;
create table note(
    id int primary key auto_increment,
    description varchar(255) not null,
    done bit
);


