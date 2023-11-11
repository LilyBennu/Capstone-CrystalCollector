### Capstone Read Me - Crystal Collector by Lily W ###

*Introduction*
From August to October I participated in the Dev 10 Academy Java Cohort.
For 12 weeks we learned Java, SQL, JavaScript, HTML, CSS, and React.
At the end of our lessons for Week 11 and 12 we created our Capstone projects.

*Capstone Requirements*
Our projects were required to meet several Technical Requirements which were:
    - Manage 4-7 database tables that are independent concepts. 
    - Relational database for data management.
    - Spring Boot, MVC (@RestController), JdbcTemplate, Testing.
    - An HTML and CSS UI built with React.
    - Sensible layering and pattern choices.
    - A full test suite that covers the domain and data layers.

Along with these requirements we had to implement a Learning Goal:
Adding some functionality to our site that we were not taught in class.

*Deliverables*
Once everything was completed we needed to give our deliverables:
    - A schedule of concrete tasks that represent all work required to 
        finish your project along with task status. (at most 4 hours per task)
    - Diagrams: a database schema, class, layer, flow
    - Wireframes: rougly sketch the UI and how one view transitions to another
    - A short presentation, 4-6 slides, describing who you are, how you found
        programming, and your project
    - Complete project source code free of compiler errors
    - A schema creation script along with and DML for data needed to run the app
    - A complete test suite with all tests passing

*This Repository*

This repository has all the deliverables completed for this project:
    - all of the projects codes:
        * MySQL Workbench Database
        * Java Server using Spring Framework and J Unit Tests
        * React JSX for the entire front end
    - Back End Code is under CrystalCollector => CrystalCollector-Server
    - Front End Code is under CrystalCollector => CrystalCollector-Client
    - The PrePlanning Folder has my tasks, and organizing files
        *proposal - file is the proposal I sent the day before our capstones 
            started to get approval on the project from my instructor.
        *prePlan - file is the list I made the monday before capstones started
            after being inspired from all the work we did and seen for our 
            group projects. It has my initial ideas of the site and my 
            original to do list tasks for setting up the project.
            My notes and questions I had on my project initially for my 
            instructor are also in this file as well.
        *backEndToDo - file is the task list a kept for back end. Here you 
            can see my esitmated times and actual times for tasks, and
            all that had to be done and thought of for the back end to be 
            completed efficiently.
        * frontEndToDo - file is my task list for the front end of the project.
            there is my list of tasks although my time estimates and actual 
            times aren't all allotted for. But you can see all that I thought of
            and accomplished for the front end here.
    - The Presentation folder has the slides i used in my presentation, as well
        as my presentation script which I wrote up to ensure I didn't go over 
        the allotted time of my presentation. And so I knew what to actually 
        talk about and not ramble or be lost.

*Crystal Collector Site Explanation*
- I wanted to make a site that I would actually use and decided to make a site
    to catalog crystals I've gotten over the past ten years. So that meant 
    needing to implement CRUD functionality for a Crystal Object. I also 
    wanted users to have a place to jot down/ keep track of any random thoughts 
    they had in connection to their collection, and thus the Blurbs object was 
    thought up, and would need CRUD functionality as well. Lastly it was very 
    important to me to learn how to have multiple users use the site but have 
    everyones information be seperate and only accessable via logging in, so I 
    had to also implement security - allowing users to sign up and sign into the
    site and to retrieve only their data when they are logged in fron their token.
I can say I acheived my MVP (minimal viable product) and had a fun time 
    making my site functional. My learning goal was AWS S3 to allow users
    to upload their own photos for their collection and to have it be 
    hosted online. Signing up for the AWS account and getting all the settings
    configured was more difficult than making the code to allow for the 
    uploading and hosting of the actual image. I can say for fact that 
    Amazon is serious about the security of their services (maybe too much).
Overall I am proud of what I acheived in about 12 days! I will continue on 
    my coding learnig journey next with:
        *AWS 
        *React Native
        *Flutter
Stay tuned to for all I'll be creating with code in the future!
    If you would like to get in contact with me please send an email to:
        lilyrunsthematrix@gmail.com
    Thanks so much for reading, stay blessed!

    - Lily Williams