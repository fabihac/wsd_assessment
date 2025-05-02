package testrunner;

import com.github.javafaker.Faker;
import config.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;

public class ContactPageRunner extends Setup {
    Faker faker = new Faker();
    ContactPage contactPage;

    @Test(priority = 1, description = "Checking Empty form")
    public void emptyFormSubmission() {
        contactPage = new ContactPage(driver);
        contactPage.goToContactPage();
        contactPage.clickSubmitButton();

        Assert.assertTrue(contactPage.areErrorAlertPresent(), "Error page are displayed");
        System.out.println("Empty form submission");
    }

    @Test(priority = 2, description = "Filling credential")
    public void complepleRegistration() {
        contactPage = new ContactPage(driver);
        contactPage.goToContactPage();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String message = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        contactPage.selectDropdownSubject("Webmaster");
        contactPage.fillContactForm(firstName, lastName, email, message);
        contactPage.clickSubmitButton(); //submitting form

    }
    @Test(priority = 3, description = "Verify Sucsess message")
    public void verifySuccessMessage() {
        contactPage = new ContactPage(driver);
        Assert.assertEquals(contactPage.successMessageText(), "Thanks for your message! We will contact you shortly.");
        System.out.println("Success message is: "+contactPage.successMessageText());
    }


}
