INITIAL THOUGHTS AND IDEAAAS

Crystal Collection Site

Pages
- landing page/ home/ login page?
- Crystals (shows all crystals in database)
    - has button to show crystals in collection and not in collection
- Map/ Location (shows map of world and where crystals are sourced from)[*stretch goal*]
- Blurbs (silly page full of random thoughts on crystals)
- About (??? would be silly at this point)
- 404 page
- Steven Universe (api stretch goal)

==============================================================================

### Pages In-Depth ###

LANDING PAGE [1]
- sign in and sign up buttons (if this has to be implemented for security)
- otherwise really pretty ass intro page

CRYSTALS PAGE 
BLURBS PAGE
ABOUT PAGE
CONTACT PAGE
404/ BAD PAGE
WELCOME PAGE (once logged in)
LOCATION MAP (stretch goal)

==============================================================================

### BACK END ###

*MODELS*

Crystal 
- String color
- int amountOwned 
- String shapes 
- String notes/ description
- boolean raw/ tumbled (or enum?)
- boolean inCollection
- int crystalId

// own table
- ENUM type (regular, special, orgonite, metal, non-stone, jewelry) //radio button or drop down

Blurbs
- String title
- String textBody
- String imageUrl

AppUser/ user role


*SQL*
- need to create tables in sql 
- schema for production and test 

==============================================================================

### FRONT END ### 

CSS/ Design
- pink and purple themed site 
- black and white outlines and text
- if can sort crystals by color then each color page background should be that color
- how can i add gold and glitter like the gaudy queen that i am???
- design layout ideas in affinity designer

==============================================================================

### SECURITY ###

==============================================================================

### Learning Goal ### 

CSS Animations???
audio??? React
Framermotion/ Sass/ Tailwhinds
styled components (custom bootstraps components)
Seperate data per user?
*[AWS/ S3 (react SDK?)] learn how to let users upload images from computer directory*
custom bootstraps template?

