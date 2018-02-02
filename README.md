## Lord Of The Rings Adventure
Welcome to Lord of the Rings console game. Greetings from me.


![game banner](https://github.com/pramod-jazz/LOTRQuest_CLI/blob/master/banner.png)


This is simple game where you will be shown to the orcs at various parts of Middle Earth. There are in all 5 stages in this game. In every stage the speed of Arrow from the orc is going to increase. You need to avoid the arrow by pressing enter on console. As the intensity or speed will increase similarly points awarded to you will also increase. 

As this is command line game you need to enter commands to play Game. 



**System requirements:** 
1. Game is tested on Windows and Linux platform. 
2. System needs Java 8 installed on it as this game is developed in Java 8.

**Execution Instructions:**
If you are in the Linux environment then use below command: 

    ./mvnw package 

If you are in Windows environment then use below command:

    mvnw.cmd package 

To run game execute jar file using below command: 

    java  -jar  target/LOTR_Quest.jar
    
**To see Application Javadoc do following :**

Extract target/LOTR_Quest-javadoc.jar into folder.

Then open index.html with browser.

**To run tests use following command:**

    ./mvnw test (Linux)

or 

    mvnw.cmd test (Windows)

**To see test report use following command:**

    ./mvnw site (Linux)

or 

    mvnw.cmd site (Windows)

**and then you can find test report at following location:**

    target/site/surefire-report.html

**Commands that you are going to use are shown below:**

 - play - Play and save yourself by clicking mouse.
 - help - To see this page again.
 - profile - See your points, details, and current level.
 - map - To see where are you on map of middle earth.
 - quit - To quit game in between.
 
 
General Design Architecture of game looks like below:

![game architecture](https://github.com/pramod-jazz/LOTRQuest_CLI/blob/master/lotr_architecture.png)


