### BACK END TO DO ### 

========================= 
[EST: 1 HR MAX] [actual?: 30 ]
### create maven intelli j project ### [DONE]

- make all necessary packages for project
    - controllers
    - data
    - domain
    - security 
    - TESTING 
        - data tests
        - domain tests 

- make classes 
    - Models
        - Crystal
        - Crystal Specification
        - Blurbs
        - App User
    - Data
        - Mappers
        - Jdbc Repositories 
        - repository interfaces (refactor them from repo)
    - Security
        - app user service
        - JWT converter
        - JWT request filter
        - SecurityConfig 
    - Domain
        - user service
        - crystal service 
        - blurbs service 
        - result 
    - Controllers
        - crystal controller
        - user controller 
        - blurbs controller
    - under main 
        - app class
        - appConfig 
    - POM XML
        - make sure version is correct to handle security 
        - add all necessary depeddencies 

====================================================================

### research how to let users upload photos from their devices ### 

*lord i done wrote everything below already but i'm pretty sure i need to read into this first becaue there will be things i may need to implement in the data layer to make this possible*

[EST 2 HRS MAX] [actual?: ]

*girl what did you learn?*

=====================================================================
### Create Models in Intelli J ### [DONE]
[EST: 30 mins MAX][actual?:10 ] 

create models and their fields, getters, setters, and hashcode for: 
- crystals
- crystal specification type (ENUM)
- blurbs
- users

=====================================================================

### Create SQL files and tables ### [DONE]
[EST: 1HRS MAX] [actual?: 45 mins]

- create query tabs
    - for production schema n tables
    - for testing 
    - for writing sql statements that will be used in jdbc repository

- create tables in production schema 
    - crystals
    - crystal specification
    - blurbs 
    - app user 
    - (app role)??? (esin said yead add these just in case)
    - (app user role) ???
- insert some data??? (maybe)

// *going to wait to do this til i start testing and repository sql statements are complete* //
- create test schema
    - copy prod schema into tab
    - create procedure "set_known_good_state()"
    - do these delete and alter table statements in the right order
    - insert data into values to for testing data

====================================================================

### application properties ### [DONE]

- add special resources package 
    - in main 
    - and in testing
- add the sql url path and username and passwork
- add them into the Run, edit configuration 
    - for application
    - for j unit testing


=============================

### fill out data layer ### 

[EST: 4 HRS MAX] [actual?: ]

*these first two will take the longest part of my time*

- actually think and plan out what methods i will need per model object [25 mins]

- make the mappers 
    - crystal mapper (need to add specification type)
    - blurbs mapper
    - appUser mapper

- once methods is thought of and finalized write them in jdbc repositories (but i will write the sql statements in workbench first to make sure they actually work) 


- once repositories and mappers are complete refactor jdbc repsitories into interfaces 

================================

### area to think up methods for model repositories ###

[EST: 1 HR MAX] [actual?: 25 mins ]

*thinking thinking*

### MODEL METHODS ###

CRYSTAL *these all need to be tied to a userId*
- addCrystal (CREATE)
- updateCrystal
- removeCrystalById 
- viewAllCrystals
- viewCrystalsByCollection
- viewCrystalsNotInCollection
- viewCrystalsByName (sorting)
- viewCrystalsByColor (sorting)

BLURBS
- addBlurb
- updateBlurb
- deleteBlurbById
- viewBlurbs

APPUSER
- findByUsername
- findById 
- addAppUser 
- updateRoles
- getAuthorities


================================

### DATA TESTING ### 

*looooord please be nice to me tests criessss* 

[4 HRS MAX PLS] [actual?: ] 

- in SQL make/ finish testing schema tab
- in intelli j make data test package and classes per model 
- will make all other packages for testing while i am here 
- make tests for:
    - crystals/ specfication
    - blurbs
- user tests will be in security test package 
- hopefully my tests pass and don't make me suffer as usual lol
- if not troubleshoot them til everything is passing for the right reasons

=================================

### area to brainstorm necessary tests for models ### 

*thiiinkkiiinngggg*

===============================

### do security ### 

[EST: 4 HRS] [actual?: ]

*this might take me longer than i like because i am kinda iffy on security tbh*

- use existing examples to fill in these classes high key!!! 
- is not very complicated but just still really unfamiliar 
- hopefully doesn't take me long and i can test security immediately when done

===============================

### test security #### 

[EST: 2 HRS] [actual?: ]

- make class for security tests
- look at other tests and think of tests i need to make for my project if any of the example tests don't fit my needs 
- make da tests 
- pass da tests 
- hopefully no crying lol

=============================

 *with everything done above this data layer will be complete yay* 
 - things will be subject to change though if what I research about uploading photos for users needs to alter these existing plans already


=========================== 

### DOMAIN ### 

[EST: 2 HRS MAX] [actual?: ]

- make service classes for all models 
    - crystals/ crystal specification 
    - blurbs
    - users 
- go service by service making rules per model and validate them in the validate method 

=================================

### test the domain ###

[EST: 4 HRS MAX] [actual?: ]

*domain testing is usually nicer to me than data testing , sho hopefully this goes way smooth*

- make testing classes for models
- think up and write test methods for each class
- test them 
- pass da tests 
- hopefully no crying here either lol

==============================

### area for domain testing method ideas ### 

*thiiiiiiiiiiiink*


=========================

### make controllers! ###

[EST: 1-2 HR MAX] [actul?: ]

*now this will require some braining because these paths will be connecting back end to front end so i need to do them correctly*

- 1st make official path for all controllers ("/crystals/user_id/????")
- make all mapgetter methods for:
    - crystals
    - blurbs
    - users (AuthController)

- make http test file in vs code 
- test the http requests in vs code they all need to work
- test happy and unhappy paths

================================

### controller paths notes and thoughts ### 

*this is important because the paths need to be per user for most of the CRUD functions/ for login, need to write that correctly*

============================== 

*once all this done back end is complete yaaaaaaaaay*

*in reality i only want to do three days MAX on back end, security and testing are my weak points right now but even then oh well lol. this really should not take me that long, some of these time estimates are generous but yeah should have back end done to boot and thursday or friday i should start on front end*


- celebrate and have a snack lol