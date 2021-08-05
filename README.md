# Coin Market Cap Project Automation using Serenity Cucumber Library

This is repository of CoinMarket Cap project automated using serenity cucumber based library.

## Tools/Framework/Libraries

- Maven - build tool
- Serenity library
- Cucumber - BDD/Gherkin style feature files
- Serenity HTML Report

## Project Structure
```
.
├── README.md
├── pom.xml                   Dependency for libraries
├── serenity.properties       Endpoints for API's
├── src
│   ├── main
│   └── test                  Test runners and supporting code 
└── target
    ├── classes
    ├── failsafe-reports
    ├── generated-test-sources
    ├── maven-archiver
    ├── maven-status
    ├── serenity-rest-cucumber-1.0.0-SNAPSHOT.jar
    ├── site                  Serenity HTML Report inside target/site/serenity/index.html
    └── test-classes

```

### How to run the test on local machine
- Prerequisites: maven3, java8 or greater
- Junit :
    - go to src/test/java/ and run class CoinMarketCapTestRunner.java
      (will run all test scenarios with **@regression** tag by default)
    - You can also modify the tags you want to execute from **@CucumberOptions** inside the class
- Maven :
    - run command from base project :

      ```bash
      $ mvn clean verify
      ```

      (will run all scenarios with @regression tag by default)

    - If you want to run different tags:

      ```bash
      $ mvn clean verify -Dcucumber.filter.tags=@backend_task1
      ```

    - Serenity HTML report is generated when running the previous commands in target directory - open target/site/serenity/index.html after the execution.