# Software Testing Automation Framework
### This framework implements automated tests for the Practice Software Testing website using Java, Selenium WebDriver and TestNG.

## Project Structure
src/
  test/
    java/
      com/
        practice/
          config/      # Configuration and driver management
          pages/       # Page Object Models
          testrunner/       # 
          utils/       # 
    resources/
      suite.xml/        # 
    


### Setup
1.Prerequisites:
- Java JDK 11 or higher
- Gradle
- Chrome

2.Dependencies (add to suite.xml):
-Selenium WebDriver
-TestNG
-WebDriverManager

### Running Tests
Via TestNG:
-Run the TestNG XML configuration file

### Design Choices
1.Page Object Model (POM)
2.Separates test logic from page interactions


### Test Coverage
1.Contact Form
-Validation of empty fields
-Successful form submission

2.Shopping Cart
-Add to cart functionality
-Quantity updates
-Price calculation verification









