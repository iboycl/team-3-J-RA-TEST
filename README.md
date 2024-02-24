# Team-3 JIRA API Testing Framework

This project is a testing framework for the JIRA API. It uses Maven for dependency management, Cucumber for behavior-driven development (BDD), Java as the programming language, RestAssured for API interaction, and Log4J2 for logging.

## Getting Started

### Prerequisites

- Java JDK 11 or higher
- Maven installed and configured
- An IDE like IntelliJ IDEA or Eclipse

### Setting Up

1. Clone the repository to your local machine.
2. Open the project in your IDE.
3. Make sure to refresh Maven dependencies to download all required libraries.

### Configuration

The framework reads the base URI and other configuration settings from `application.properties` located in `src/test/resources`.

Example `application.properties` content:

base.uri=https://inaracademygroup3.atlassian.net


### Running Tests

To run the tests, you can use the following Maven command:

`mvn clean test`


Alternatively, you can run the tests directly from your IDE by running the Cucumber test runner class.

# Running Tests with Cucumber Runner

To execute the tests with the Cucumber Runner, you can either run the `TestRunner` class directly from your IDE or use Maven.

From the IDE:
- Navigate to `src/test/java/runner/TestRunner.java`.
- And run it.

### Project Structure

- `src/main/java`: Contains utility classes and POJOs (Plain Old Java Objects) for request and response bodies.
- `src/test/java`: Contains the test code, including step definitions and hooks.
- `src/test/resources`: Contains feature files, properties files, and logging configuration.

### Key Components

- `ConfigManager`: Utility class for reading properties from the configuration file.
- `TestContext`: Context class used for sharing data between steps.
- `Hooks`: Class containing `@Before` and `@After` methods for setting up preconditions and postconditions for the tests.
- `BaseSteps`, `CommonSteps`, `IssueAttachments`, `IssueComments`, `Issues`, `Projects`, `Users`, `UsersSearch`: Step definition classes and folders for the Cucumber steps.
- `Pojo`: POJO classes representing various entities.

### Logs

Logs are configured via `log4j2.properties` and output to the console. They provide detailed information about test execution.

## Changelog

For all notable changes to this project, see the `CHANGELOG.md` file.

## Authors

- **Taha F. Çetinkaya** - [Taha F. Çetinkaya]()
- **Yusuf B. Çetin** - [Yusuf B. Çetin]()
- **Okan Tıraş** - [Okan Tıraş]()
- **Mehmet Bilgiç** - [Mehmet Bilgiç]()
- **Enes Yel** - [Enes Yel]()
- **Mustafa Sayar** - [Mustafa Sayar]()
- **İbrahim Yücel** - [Ibrahim Yucel](https://github.com/iboycl)





