use crystals;

insert into app_user (app_user_id, username, password_hash, enabled)
	values 
    (1, 'Lily', 'password_hash1', 1),
    (2, 'Ylil', 'password_hash2', 1);

insert into blurbs (blurbs_id, title, text_body, image_url, app_user_id)
	values 
    (1, 'Crytals rock!', 'the best pet rock a girl could have', 'testurl.com', 1),
    (2, 'SuperJail', 'they had an episode about crystals, did that influence me?', 'fakeurl.com', 1),
    (3, 'Shikon Jewel', 'I wonder if I can get that cursed version of the Shikon Jewel online?', '123url.com', 2);


insert into crystal (crystal_id, crystal_name, color, amount_owned, shape, notes, raw, in_collection, 
    image_url, crystal_specification_id, app_user_id)
	values
    (1, 'Amethyst', 'purple', '1', 'oblong', 'have had this one for a long while!', 
    1, 1, 'fakeurl.com/image1', 2, 1),
    (2, 'Selenite', 'white', '1', 'triangle', 'has image of papa ra eye carved into it', 
    1, 1, 'fakeurl.com/image2', 2, 1);
    
select
	app_user_id, username, password_hash, enabled
from app_user
where username = 'Lily';
    
select
		app_user_id, username, password_hash, enabled
                from app_user
                where app_user_id = 1;
                
 select
	blurbs_id, title, text_body, image_url, app_user_id
from blurbs
where blurbs_id = 1;

select * from blurbs
where app_user_id = 1;

select
	blurbs_id, title, text_body, image_url, app_user_id
from blurbs
where blurbs_id = 1 AND app_user_id = 1; 

delete from blurbs
where blurbs_id = 7 AND app_user_id = 2;

 select * from crystal
where crystal_id = 1 AND app_user_id = 1;

select * from crystal
where app_user_id = 1;
