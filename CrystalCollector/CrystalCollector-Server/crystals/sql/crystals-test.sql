drop database if exists crystals_test;
create database crystals_test;
use crystals_test;

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

delimiter //
create procedure set_known_good_state()
begin 

	delete from crystal_specification;
	alter table crystal_specification auto_increment = 1;
	delete from app_user;
	alter table app_user auto_increment = 1;
	delete from crystal;
	alter table crystal auto_increment = 1;
	delete from blurbs;
	alter table blurbs auto_increment = 1; 
    
    insert into app_user (app_user_id, username, password_hash, enabled)
	values 
    (1, 'TestLily', 'password_hash1', 1),
    (2, 'TestYlil', 'password_hash2', 1);
    

insert into blurbs (blurbs_id, title, text_body, image_url, app_user_id)
	values 
    (1, 'TestCrytals rock!', 'the best pet rock a girl could have', 'testurl.com', 1),
    (2, 'TestSuperJail', 'they had an episode about crystals, did that influence me?', 'fakeurl.com', 1),
    (3, 'TestShikon Jewel', 'I wonder if I can get that cursed version of the Shikon Jewel online?', '123url.com', 2),
    (4, 'DeleteCopyTestSuperJail', 'they had an episode about crystals, did that influence me?', 'fakeurl.com', 1);


insert into crystal (crystal_id, crystal_name, color, amount_owned, shape, notes, raw, in_collection, 
    image_url, crystal_specification_id, app_user_id)
	values
    (1, 'TestAmethyst', 'purple', '1', 'oblong', 'have had this one for a long while!', 
    1, 1, 'fakeurl.com/image1', 2, 1),
    (2, 'TestSelenite', 'white', '1', 'triangle', 'has image of papa ra eye carved into it', 
    1, 1, 'fakeurl.com/image2', 2, 1),
    (3, 'DeleteCopyTest2Selenite', 'white', '1', 'triangle', 'has image of papa ra eye carved into it', 
    1, 1, 'fakeurl.com/image2', 2, 1);
    
    
    end //
    delimiter ;


