# QuizEu

This is a game written by Buda Tibor for Programming technologues class. <br/>
It's a simple quiz about European countries in general.

# Requirements

For running you need to install [Apache Maven](https://maven.apache.org/download.cgi "Apache Maven Download Page") 3.6.0 or above.<br/>
This game requires [Java](https://openjdk.java.net/ "OpenJDK") 11 or above.

---

## Generating javadoc
-    To generate reports and javadoc, use the following commands: 
>
```
mvn clean site
```

## Running
-    To run this game with maven, run the following commands: 
>
```
mvn clean compile exec:java
```
----
## Score system:

Until you end up answering a question incorrectly your spree point increases by one for every question aswered. <br/>
After the incorrect answer the value of these questiones are added up and multiplied by your spree count.<br/>
After that the spree resets to zero and your spree score is added to your main score.<br/>
You have three lifes so you have plenty of chance to be the leader of the board.<br/> ENJOY!

