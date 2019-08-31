# RossTestFramework

Example UI Test framework to cover regression scenarios for computers-database application.

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

In the pom.xml build section, update the \<tags\> property to any or all of the utilised tags below to run those cucumber tags:
```$xslt
wip
smoke
regression
create
read
update
delete
```

```
mvn clean verify
```

### Break down into end to end tests

@smoke tests cover basic create/read/update/delete functions\
All tests are marked as @regression for full coverage

## Authors

* **Ross Kelly**
