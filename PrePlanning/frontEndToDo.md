### FRONT END TO DO ### 

============================== 

npm init 
npm instal (useeffect package and nav i think, right?) and bootstraps?

================================ 

### VS Code organizing ### 

[EST 30 MINS] [actual?: ]

*aaaaaaaaw yeah my bestie React!*

*okay realistically speaking thooooooo what is gonna be components, what is gonna be pages, how else can i compartimentalize these different parts in React so everything is organized well?* 

- make folders for components 
    - buttons?
    - add crystal form
    - crystal list/ table
    - haaaaah?
    - is Nav in component folder lol?
- make folders for pages 
    - login page
    - welcome page/ 
    - crystals by user page 
    - blurbs page " "
    - about page 
    - contact page 
    - 404/ bad page
    - anything else????
        - crystal detail page? (i think will be necessary)
- make folder for styles
    - aaaaaaw yeah lets get cute 
- make NavBar component
- in App js make code for Route

================================ 

### configure App.js ###

- import everything
- make da Routes! [MAKE SURE THEY MATCH THE PATHS/ DONT ID/AGENTID YOURSELF AGAIN LMAO] (wrap in AuthContext)
- add useEffect for logging in 


=================================

### configure NavBar component ###

- import Link and everything else
- make NavBar
    - *how do i make the navbar only appear completely when someone is signed in, is it possible?*
    logout button on right
    - home/ welcome
    - crystals 
    - blurbs 
    - about 
    - contact 
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

### login/ sign up page ### 
- sign in button 
- sign up button 

### crystal list/ table component ### ????
- shows crystals on crystal collection page 
- gotta decide how on the card

### add crystal form component ### 
- if crystalId > 0 edit *else* add new crystal 
- have input for all necessary fields 
- image can either be URL (for instance if it's a crystal not in their collection)
- or image can be uploaded from the users device (AWS S3) 
- *once my models is complete with the fields i will come and write more details here*

### view crystals page ### 
- them cards we been using for everyting 
- would like them displayed 3 at a time in rows
- display crystal image, and name, and a button to view crystal maybe edit and delete buttons too
- have a total of all crystals in collection up top, maybe some other stats??
- ### *MAS IMPORTANTE* ### - 
    - want to have several view functions for this page for the user 
        - view all crystals
        - view by collection 
        - view by not in collection 
        - *que mas?*
        - sort by name 
        - sort by color 

### crystal detail page? (findbyCrystalId) ??? ###
- yeah i think this is necessary
- this will show all of the crystal information beyonce whats on the card
- have edit and delete buttons for crystal 
- have other crystal stats maybe like how many of this crystal in collection, something else maybe 

### blurbs form component ### 
- see doing this whole to do list is good it is helping my brain brain up ideas correctly 
- form to handle input for blurbs
- also needs to be able to handle uploading images for user as well 
- once model is complete in java will come write more details here
- is this where the RTE plugin would go ? (most likely)

### blurbs page ### 
- ooooooh RTE!!! for text (mini stretch goal) 
- aaaah *bleep* i need make a blurbs form component
- add a blurb button 
- edit and delete existing blurbs 
- shown in a card format, like crystals they are blurbs they should be that big
- title => text => image 

### 404/ not found page ### 
- can i be fancy and have it redirect to home like patrick did?
- wanna have a cute image or meme

### error page ### 
- redirect countdown if possible 
- error message
- cute meme or image too if possible

### welcome page ### 
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
- simple enough
- explain purpose of site, hot to use it a bit and about the site creator cystal queen lily
- decide on desin later, not pertinent right now

### contact page
- simple page for now with email and whatever 
- page not as pertinent to site as others


========================================================

### CSS Stretch goals ### 

- glitter ?????!!!!!!!!
- css animations on the welcome page 
- how can i make everything pretty afffffff?!?!?!?!?!?
