# Computer-Database-UI-Tests

Example UI Test framework to cover regression scenarios for computers-database application.

### Prerequisites

Java 8 or above\
Maven 3.5 or above

## Manual Tests

The associated test plan can be found in the root directly as Computer Database Test Plan.xlsx

## Running the tests

By default, ```mvn clean verify``` will run the full regression suite in chrome headless mode with 20 concurrent threads.
Report will be generated in target/generated-report, open via index.html

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
