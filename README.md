# Computer-Database-UI-Tests

Example UI Test framework to cover regression scenarios for computers-database application.``

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Java 8 or above\
Maven 3.5 or above

### Installing

Clone from git.

Open src/main/resources/config.properties\
Define browser (chrome or firefox)\
Update URL if necessary

## Running the tests

#### Tags to run

Examples of tags used are:
```@smoke``` ```@regression``` ```@wip```


```@smoke``` covers highest priority TC's\
```@wip``` is used for creating new tests\
```@regression``` is to run all tests

Update \<tags\> in pom build section to your selection.

Then run: ```mvn clean verify```

### Running in Window

Headless mode is controlled in BrowserOptions.java\
To run in window, comment out the "--headless" option for whichever browser you're using.

### Debugging

1) ensure only the test to debug is marked as @wip
2) add breakpoints if necessary
3) right click RunCucumberTest.java
4) select Debug RunCucumberTest

## Author

* **Ross Kelly**
