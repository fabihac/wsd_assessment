# Software Testing Automation Framework
### This framework implements automated tests for the Practice Software Testing website using Java, Selenium WebDriver and TestNG.

## Project Structure
src/
test/
java/
config/ # WebDriver and configuration setup
pages/ # Page Object Models for web pages
testrunner/ # Testng runner classes
resources/
suite.xml # TestNG suite configuration
    

## Setup
1.Prerequisites:
- Java JDK 11 or higher
- Gradle
- Chrome

2.Dependencies (add to suite.xml):
- Selenium WebDriver
- TestNG
- WebDriverManager

## Running Tests
Via TestNG:
- Run the TestNG XML configuration file

## Design Choices
- **Page Object Model (POM)**:
- Separates test logic from UI element interactions.
- Improves reusability and maintainability.


## Test Coverage
1.Contact Form
- Validation of empty fields
- Successful form submission

2.Shopping Cart
- Add to cart functionality
- Quantity updates
- Price calculation verification









