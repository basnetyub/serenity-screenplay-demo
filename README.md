# Itonic Demo Using Screenplay Pattern with Serenity BDD

###This project is a demonstration for automation test of:
Dropdown test of Amazon Category

Login test of Facebook

###This project is implemented using the [Screenplay pattern](https://dzone.com/articles/page-objects-refactored-solid-steps-to-the-screenp), And  [Serenity BDD](http://serenity-bdd.info/#/) library and JUnit.

This test is testd for Windows Chrome, chrome binary is located on resources/webdriver/windows.

## Screenplay implementation

These tests use tasks, actions, questions and page elements defined in `src/main/java/net/serenitybdd/demos/itonics/screenplay`.

The overall project structure is shown below:
````
+ model
    Domain model classes
+ tasks
    Business-level tasks
+ action
    UI interactions
+ pages
    Page Objects and Page Elements
+ questions
    Objects used to query the application
````

## Running the project

To run the project you'll need JDK 1.8 and Maven installed.

### Screenplay and Cucumber

To run it, execute:

```
mvn clean verify
```
## Reporting

The Serenity reports will be generated in the `target/site/serenity` directory.
