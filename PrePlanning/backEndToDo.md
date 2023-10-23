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

### fill out data layer ### [DONE]

[EST: 4 HRS MAX] [actual?: 4hrs n change ]

*these first two will take the longest part of my time*

- actually think and plan out what methods i will need per model object [25 mins]

- make the mappers [like 1-2 hrs i think *cries*]
    - crystal mapper (need to add specification type)
    - blurbs mapper
    - appUser mapper

- once methods is thought of and finalized write them in jdbc repositories (but i will write the sql statements in workbench first to make sure they actually work) [2 HRS]


- once repositories and mappers are complete refactor jdbc repsitories into interfaces [3 mins]

================================

### area to think up methods for model repositories ### [DONE]

[EST: 1 HR MAX] [actual?: 25 mins ]

*thinking thinking*

### MODEL METHODS ###

CRYSTAL *these all need to be tied to a userId*
- addCrystal (CREATE)
- updateCrystal
- removeCrystalById 
- viewAllCrystals
- viewCrystalById duh!

### these can be done using .sort() in front end
*- viewCrystalsByCollection*
*- viewCrystalsNotInCollection*
*- viewCrystalsByName (sorting) [may not need these 2]*
*- viewCrystalsByColor (sorting) [ ''' ]*

BLURBS
- addBlurb
- updateBlurb
- deleteBlurbById
- viewBlurbs

APPUSER
- findByUsername
- findById 
- addAppUser     
- getAuthorities // may not need this 


================================

### DATA TESTING ### [DONE]

*looooord please be nice to me tests criessss* 

[4 HRS MAX PLS] [actual?:7 HRS TOTAL ] 
*testing whooped my aaaaahhh but at least its done now!*

- in SQL make/ finish testing schema tab [*]
- in intelli j make data test package and classes per model [*]
- will make all other packages for testing while i am here 
- make tests for:[*]
    - crystals/ specfication
    - blurbs
 
- hopefully my tests pass and don't make me suffer as usual lol

- if not troubleshoot them til everything is passing for the right reasons

=================================

### area to brainstorm necessary tests for models ### [DONE]

[1 HR MAX] [actual?: 15 mins]

*thiiinkkiiinngggg*

### APPUSER TESTS ### [TIME?: ]
[45 mins alone on non stop errors related to @SpringConfiguration
not being found, sql known good state order errors, literal wastes
of tiiiiiiiiiime :O]
[another hour for trying to fix known good state *cries*]

shouldFindAppUserByUsername
shouldNotFindNonExistantUsername
shouldFindAppUserById
shouldNotFindNonExistentAppUser
shouldAddAppUser
shouldNotAddNullFieldsAppUser


### BLURBS TESTS ### [TIME?: ]

shouldAddBlurb
shouldNotAddNullFieldsBlurb
shouldNotAddBlurbWithoutAppUserId
shouldUpdateBlurb
shouldNotUpdateMissingFieldsBlurb
shouldDeleteBlurb
shouldNotDeleteNonExistentBlurb
shouldNotDeleteBlurbWithoutAppUserId
shouldFindAllBlurbs
shouldNotFindBlurbsWithoutAppUserId
shouldFindBlurbById
shouldNotFindNonExistentBlurb
shouldNotFindBlurbWithoutAppUserId

### CRYSTALS TESTS ### [TIME?: ]

shouldAddCrystal
shouldNotAddMissingFieldsCrystal
shouldNotAddCrystalWithoutAppUserId
shouldUpdateCrystal
shouldNotUpdateMissingFieldsCrystal
shouldRemoveCrystal
shouldNotRemoveNonExistentCrystal
shouldNotRemoveCrystalWithoutAppUserId
shouldFindAllCrystalsByUser
shouldNotFindCrystalsWithoutAppUserId
shouldFindCrystalById
shouldNotFindNonExistentCrystal
shouldNotFindCrystalWitoutAppUserId

=====================================================================

### do security ### 

[EST: 4 HRS] [actual?: ]

*this might take me longer than i like because i am kinda iffy on security tbh*

- use existing examples to fill in these classes high key!!! [45 mins]
- is not very complicated but just still really unfamiliar [lies]

- ### reconfigure AuthController class 
    - make sure to add refresh_token path 
    - import appUser class
    - think i need to change all instances of "username" to appUsername
    - everyone is authorized on site because only users exist no admin
    - add endpoint to add users (controller tings look at lesson for example) aaaah pooh i need to make a sign up component and sign in component for front end

- ### reconfigure AppUserService class 
    - no admins needed
    - import appUser class
    -  change instances of "username" to *appUserName*
    - add AppUserRepository to this class (check lesson if you get confused)
    - check lesson for service class example and see what should be added to my class, what is necessary for my project?
    - wait until database lesson is done then might have to come back to this class

- ### reconfigure SecurityConfig class 
    - update all them antMatchers for sure
    - high key everything is just permitAll() 
    - does http.csrf().disable(); need to be enabled eventually?
    - unComment JWT Converter
    - update antMatchers for create-account path

- ### reconfigure JWTConverter class [DONE]
    - update "username"  to *appUserName*
    - import appUser class 
    - aaah the authorities stuff need to be taken out and roles

- ### AppConfig
    - think this is fine how it is now
    - do i take everything out the App class now?

- ### AppUser [DONE]
    - of those overide methods do i need to change them?

- ### AppUserMapper 
    - if i'm not using roles do i have to add sql exception and all that other stuff to the mapper?

- hopefully doesn't take me long and i can test security immediately when done *Esin said no need to test security, but make sure user is working*

=====================================================================

### test security #### NO MAS [OMITTED]

[EST: 2 HRS] [actual?: ]

- make class for security tests
- look at other tests and think of tests i need to make for my project if any of the example tests don't fit my needs 
- make da tests 
- pass da tests 
- hopefully no crying lol

====================================================================

 *with everything done above this data layer will be complete yay*

 - things will be subject to change though if what I research about uploading photos for users needs to alter these existing plans already


=====================================================================

### DOMAIN ### [DONE]

[EST: 2 HRS MAX] [actual?: 3 HRS]

- make service classes for all models 
    - crystals/ crystal specification [25 mins] + [1 HR for validations]
    - blurbs [25 mins] + [1 hour for validations]
    - users 
- go service by service making rules per model and validate them in the validate method 
- uh oh duh populate the Result class as well

=====================================================================

### test the domain ### [KINDA-DONE]

[EST: 4 HRS MAX] [actual?: 4HRS ] (will need to troubleshoot null tests with Esin porque estoy sufrendo)

*domain testing is usually nicer to me than data testing , so hopefully this goes way smooth*

- finish appUser Tests for *domain and data*

- make testing classes for models
- think up and write test methods for each class
- test them 
- pass da tests 
- hopefully no crying here either lol

====================================================================

### area for domain testing method ideas ### [DONE]
[EST:30 mins] [actual?: 30 mins ]

*thiiiiiiiiiiiink*
*remeber what Esin said, focus on testing validations not necessarily passthrough methods*

### Blurb Service TESTS ### [DONE]

- shouldOnlyShowBlurbsForUser
- shouldntAllowNullTitle
- shouldntAllowNullTextBody
- shouldntAllowOverMaxCharTitle
- shouldntAllowOverMaxCharTextBody
- shouldntAllowOverMaxCharImgUrl
- shouldBeTiedToUser

- test for making sure appUserId connect to everything?


### Crystal Service TESTS ### [DONE]
- *why did make so many fields for crystal criesss* 
- shouldntAllowNullCrystalName
- shouldntAllowCrystalNameOverMaxChars
- shouldntAllowNullColor
- shouldntAllowColorOverMaxChars
- shouldntAllowEmptyAmountOwned
- shouldAllowZeroAmountOwned 
- shouldntAllowNullShape
- shouldntAllowShapeOverMaxChars
- shouldAllowNullNotes 
- shouldntAllowNotesOverMaxChars
- shouldAllowNullImgUrl
- shouldntAllowImgUrlOverMaxChars
- shouldntAllowNullCrystalSpecType
- shouldBeTiedToUser

- how to test booleans???



### App User Service TESTS (will be done in security) ###

- is there where i do testing to make sure user is logged in so that everything is tied to appUserId??




=====================================================================

### make controllers! ### 

[EST: 1-2 HR MAX] [actul?: ]

*now this will require some braining because these paths will be connecting back end to front end so i need to do them correctly*

- 1st make official path for all controllers ("/crystals/user_id/????")
- make all mapgetter methods for:
    - crystals [1.5 HRS] [DONE]
    - blurbs [30 mins] [DONE]
    - users (AuthController)

- ### make http test file in vs code 
- *NOT SURE I CANT TEST THESE WITHOUT SECURITY BEING DONE*
- test the http requests in vs code they all need to work
- test happy and unhappy paths

=====================================================================

### controller paths notes and thoughts ### 

*this is important because the paths need to be per user for most of the CRUD functions/ for login, need to write that correctly*
 - i was getting getting mapping paths confused with Route Paths lol
=====================================================================

*once all this done back end is complete yaaaaaaaaay*

*in reality i only want to do three days MAX on back end, security and testing are my weak points right now but even then oh well lol. this really should not take me that long, some of these time estimates are generous but yeah should have back end done to boot and thursday or friday i should start on front end*


- celebrate and have a snack lol 
=====================================================================

### Back end questions for Esin ### 

- do what for the user login haaaaaaah?

- is it possible to add null statment for boolean validating?
- should i be validating anything else for blurbs and crystals

- do i really gotta test all these tests i made lmao [yes]

- for controllers/ paths how should i set things up so the paths or  login is connected to user always? is it by 
      ###  ("/appUserId/crystals/blah)??? noooo easier to hack
      user info in token with authprincipal

- for the antMatchers for security I have to make one for every method that has a path essentially?
- yep petmitAll and authenticated decided what pages need to authenticated and what are permit all

 - ### Notes ### - 
 - authentication principle to grab user assoicated with token
    

    ### example ###
    - public Result<Crystal> add(@RequestBody Crystal crystal, @AuthenticationPrinciple AppUser user) {
    crystal.setAppUserId(user.getAppUserId); 
    Result<Crystal> result = service.add(crystal); 
    // etc. ... 
}
=====================================================================

### Weekend To Do ### 

- research and start implementation for AWS S3 for photo upload

- implement as much as possible back end security (come and right here whatever questions you have for monday) (maybe ask Brian for help since he volunteered himself lol) [DONE]
    - add user role and other table to sql [DONE]
    - go on ahead and implement security as it is that is the lazy programmer way to do it mawhahah [DONE]

- add all necessary components and code for front end React Security, go through lessons for help

- what needs to be done/ can be done for front end?

- npm init/ install everything (npx create react app/ bootstraps/ route/ jwt-decode) [DONE]
- flesh out front end to if anything is vague
- add time estimates to front end

====================================================================

### over the weekend questions ###

- tests keep failing becauase the fields can't be null but that is the whole point of the test
    CrystalServiceTest
        - shouldNotAddNullCrystal


- question for JWTConverter -getUserFromToken method differences
- should http.crsf().disabled(); in SecurityConfig be enabled
- can i just move what's in appConfig into App?


=====================================================================

### MONDAY TO DOOOO ### 

- write antMatchers paths in correct order for SecurityConfig Class
- complete AuthController
- how can now broken user tests be fixed?

- make http requests for all backend mappings 
- make sure sign in and sign up work
- finish up back end (appUser and Security)

- start on front end To Do list