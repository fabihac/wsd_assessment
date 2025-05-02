package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ContactPage {
    private WebDriverWait wait;

    @FindBy(css ="a[routerlink='/contact']" )
    WebElement btnContactLink;

    @FindBy(id = "first_name")
    WebElement txtFirstName;

    @FindBy(id = "last_name")
    WebElement txtLastName;

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "subject")
    WebElement dropdownSubject;

    @FindBy(id = "message")
    WebElement txtMessage;

    @FindBy(css = "[data-test='contact-submit']")
    WebElement btnSubmitButton;

    @FindBy(className = "alert-success")
    WebElement getSuccessMessage;

    @FindBy(className = "alert-danger")
    List<WebElement> errorAlert;


    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));

    }

    public void goToContactPage() {
        wait.until(ExpectedConditions.elementToBeClickable(btnContactLink)).click();
    }

    public void fillContactForm(String firstName, String lastName, String email, String message) {
        this.txtFirstName.sendKeys(firstName);
        this.txtLastName.sendKeys(lastName);
        this.txtEmail.sendKeys(email);
        this.txtMessage.sendKeys(message);

    }
    public void selectDropdownSubject(String subject) {
        Select dropdown = new Select(dropdownSubject);
        dropdown.selectByVisibleText(subject);
    }

    public void clickSubmitButton() {
        btnSubmitButton.click();
    }

    public String successMessageText() {
        return getSuccessMessage.getText();
    }

    public boolean areErrorAlertPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(errorAlert));
            return errorAlert.stream().anyMatch(WebElement::isDisplayed);
        }
        catch (Exception e) {
            return false;
        }

    }



}

