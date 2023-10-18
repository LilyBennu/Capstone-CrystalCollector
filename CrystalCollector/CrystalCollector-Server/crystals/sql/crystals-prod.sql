drop database if exists crystals;
create database crystals;
use crystals;

create table crystal_specification (
	crystal_specification_id int primary key auto_increment,
    crystal_type varchar(50) not null
);

INSERT INTO crystal_specification (crystal_specification_id, crystal_type) VALUES
(1, 'REGULAR'),
(2, 'SPECIAL'),
(3, 'ORGONITE'),
(4, 'METAL'),
(5, 'NONSTONE'),
(6, 'JEWLRY');

create table app_user (
    app_user_id int primary key auto_increment,
    username varchar(50) not null unique,
    password_hash varchar(2048) not null,
    enabled bit not null default(1)
);


create table crystal (
	crystal_id int primary key auto_increment,
    crystal_name varchar(50) not null,
    color varchar(25) not null, 
    amount_owned int not null, 
    shape varchar(25) not null,
    notes varchar(2048),
    raw boolean not null,
    in_collection boolean not null, 
    image_url varchar(250),
    crystal_specification_id int not null,
    app_user_id int not null,
    -- may need to add to table for user uploading images
    foreign key (crystal_specification_id) references crystal_specification(crystal_specification_id),
    foreign key (app_user_id) references app_user(app_user_id)
);


create table blurbs (
	blurbs_id int primary key auto_increment,
    title varchar(250) not null,
    text_body varchar(2048) not null,
    image_url varchar(500),
    app_user_id int,
    foreign key (app_user_id) references app_user(app_user_id)
);

