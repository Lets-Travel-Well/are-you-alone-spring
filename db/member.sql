use rualone_local;
drop table member;
create table member(
                       `id` bigint not null primary key auto_increment,
                       `login_id` varchar(20),
                       `name` varchar(10),
                       `password` varchar(30),
                       `email` varchar(20),
                       `domain` varchar(20),
                       `footage` bigint default 0,
                       `hashcode` varchar(256)
)