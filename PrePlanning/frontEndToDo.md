### FRONT END TO DO ### 

============================== 

npm init [DONE]
npm instal (useeffect package and nav i think, right?) and bootstraps?

================================ 

### VS Code organizing ### 

[EST 30 MINS] [actual?: ]

*aaaaaaaaw yeah my bestie React!*

*okay realistically speaking thooooooo what is gonna be components, what is gonna be pages, how else can i compartimentalize these different parts in React so everything is organized well?* 

- make folders for components 
    - buttons?
    - add crystal form [*]
    - crystal list/ table
    - blurb form [*]
    - haaaaah?
    - is Nav in component folder lol?
    - sign in component
    - sign up component
- make folders for pages 
    - login page  [*]
    - welcome page/ [*]
    - crystals by user page [*]
    - blurbs page " "[*]
    - about page   [*]
    - contact page [*]
    - 404/ bad page [*]
    - anything else????
        - crystal detail page? (i think will be necessary) [*]
- make folder for styles
    - aaaaaaw yeah lets get cute 
- make NavBar component [*]
- in App js make code for Route
- *check board game example for what needs to be added for security and react lesson too*

================================ 

### configure App.js ###
[30 MINS MAX] [actual?: ]

- import everything [*]
- make da Routes! [MAKE SURE THEY MATCH THE PATHS/ DONT ID/AGENTID YOURSELF AGAIN LMAO] (wrap in AuthContext) [*]
- add useEffect for logging in 


=================================

### configure NavBar component ### [DONE]

[1 HR MAX] [actual?: ]

- import Link and everything else [*]
- make NavBar [*]
    - *how do i make the navbar only appear completely when someone is signed in, is it possible?*
    logout button on right
    - home/ welcome [*]
    - crystals [*]
    - blurbs [*]
    - about [*]
    - contact [*]
    - can i add sparkles to the nav bar??? something need to be glittery on this site!!!!!


=====================================================================

### configure securite with AuthContext.js ###

- low key what am i even doinggg
- import createContext fromt react
- create context
- export AuthContext 
- confirmation component
- import useHistory (localstorage connect)

// AuthContext first get this security stuff done first highkey since it's where i struggle most 

=======================================================================

### make pages and components!!!

*many of these components will be connected to endpoints/ paths in controller, need to think about that!!!!!*

### login/ sign up page ### [DONE]
[EST: ] [actual?: ]

- sign in button 
- sign up button 

### sign in component/ form ###
[EST: ] [actual?: ]

### sign up component/ form ###
[EST: ] [actual?: ]

### crystal list/ table component ### ????
[EST: ] [actual?: ]

- shows crystals on crystal collection page 
- gotta decide how on the card

### add/ update crystal form component ### 
[EST: ] [actual?: ]

- if crystalId > 0 edit *else* add new crystal 
- have input for all necessary fields 
- image can either be URL (for instance if it's a crystal not in their collection)
- or image can be uploaded from the users device (AWS S3) 
- *once my models is complete with the fields i will come and write more details here*

### view crystals page ### 
[EST: ] [actual?: ]

- them cards we been using for everyting 
- would like them displayed 3 at a time in rows
- display crystal image, and name, and a button to view crystal maybe edit and delete buttons too
- have a total of all crystals in collection up top, maybe some other stats??
- ### *MAS IMPORTANTE* ### - .sort() React function heck yeeeee
    - want to have several view functions for this page for the user 
        - view all crystals
        - view by collection 
        - view by not in collection 
        - *que mas?*
        - sort by name 
        - sort by color 

### crystal detail page? (findbyCrystalId) ??? ###
[EST: ] [actual?: ]

- yeah i think this is necessary
- this will show all of the crystal information beyonce whats on the card
- have edit and delete buttons for crystal 
- have other crystal stats maybe like how many of this crystal in collection, something else maybe 

### blurbs form component ### 
[EST: ] [actual?: ]

- see doing this whole to do list is good it is helping my brain brain up ideas correctly 
- form to handle input for blurbs
- also needs to be able to handle uploading images for user as well 
- once model is complete in java will come write more details here
- is this where the RTE plugin would go ? (most likely)

### blurbs page ### 
[EST: ] [actual?: ]

- ooooooh RTE!!! for text (mini stretch goal) 
- aaaah *bleep* i need make a blurbs form component
- add a blurb button 
- edit and delete existing blurbs 
- shown in a card format, like crystals they are blurbs they should be that big
- title => text => image 

### 404/ not found page ### 
[EST: ] [actual?: ]

- can i be fancy and have it redirect to home like patrick did?
- wanna have a cute image or meme

### error page ### 
[EST: ] [actual?: ]

- redirect countdown if possible 
- error message
- cute meme or image too if possible

### welcome page ### 
[EST: ] [actual?: ]

- aaaaaaaaaaaaw eff yeah
- want to CSS animations into this page 
- if no csss just have cute intro/ welcome page 
    - find or make some kind of pretty background page 
- for CSS Animation 
    - use the keyframes the have letters come from all across the screen and say "Welcome to your Crystal Collection in like 3-5 seconds if possible
    - also can sound be tied to the keyframes? would like a lil wind chime noise or something if possible oooooh fancy!
- welcome to crystal collection in center page with possible carousel of crystals around it? that would be fancy af
    - if not possible within time just do crystal collection title in middle maybe in a box that is pretty with glitter or something lol

### about page ### 
[EST: ] [actual?: ]

- simple enough
- explain purpose of site, hot to use it a bit and about the site creator cystal queen lily
- decide on desin later, not pertinent right now

### contact page
[EST: ] [actual?: ]

- simple page for now with email and whatever 
- page not as pertinent to site as others


========================================================

### CSS Stretch goals ### 

- glitter ?????!!!!!!!!
- css animations on the welcome page 
- how can i make everything pretty afffffff?!?!?!?!?!?
==================================================================

### Tuesday to do ###

- add authorization for roles on path in app (renderWithAuthority)
- update NavBar with context

- connect sign in form to sign in button [DONE]
- connect sign up form to sign up button [DONE]
- does sign in and sign out work? SIGN IN? [DONE]    SIGN OUT?

- in app route paths add element = { !user ? <SignIn>}
    - element = {user ? <MostComponents />}

- add/update blurb form [DONE] (working in browser too yaaaay)
- add/ update crystal form [DONE]
 
- confirm delete crystal page [DONE]
- confirm delte blurbs page [DONE]

- configure crystal cards [DONE]
- configure viewAllCrystals [DONE]

- configure blurbs cards [DONE]
- configure viewAllBlurbs [DONE]

- do i need DisplayCrystals component????? *NO*
- make crystal collection page [DONE]
- make blurbs page [DONE]

- can i even do AWS at this point *cries* YES YOU CAN
=============================================================

### what is working??!!!!!! ###
- add crystal works!!!
- viewAllCrystals works!!
- add blurb is working !!!
- delete blurb works
- delete crystal works

==================================================================

### help needed for wednesday ### [DONE]

- blurb images not showing 
- update crystal not working causes error on submit
- same for blurbs, same error
- don't i need to add these new image upload paths to security config???
- what about the CORS in App?

==============================================================

### wednesday to do ###

- complete viewCrystalDetails page or whatevs its called

- AWS S3!!!!!!!! [DONE]
    - signed up for account
    - created crystalcollectorbucket 
    - npm installed aws-sdk
    - added aws s3 dependency 
    - added image upload controller
- add credentials in Run - Edit Configurations [DONE]
- add code to front end [DONE]
*
- NEED TO BE ABLE TO SIGN OUT
- TEST SIGN UP [DONE]

- make error page (add image and sign in or sign up statement)
- about 
- contact 
- not found

==================================================================

### thursday to do ###

- complete viewCrystalDetails page or whatevs its called [DONE]

- make error page 
- about [DONE]
- contact [DONE]
- not found

- enter in hella crystal into issaMeLily!
- enter fakey cakes crystals into Anti-Lily's profile
- same for blurbs
- modify .js files to have uniform look, change names back to normal low key
- ADD SOME MFN SPARKLES SOMEWHERE [DONE]

- aaaaaaah make these slides for the presentation

- COMPLETE AND FIX BACKEND DATA TESTS GUUUURL [DONE]
    - only [1] data test failing yay!

- CSS ANIMATION THOOOOOOOOOOO [DONE]
======================================================================

### thursday questions ### 
- can i make sign out button to={/} ??? [DONE]
- how do i make sign out work?!!!![DONE]
- how do i make home button be welcome button if signed in? [DONE]

=============================================

### friday to do! ###

- present
- cry with joy for all you've accomplished!!!!!!

