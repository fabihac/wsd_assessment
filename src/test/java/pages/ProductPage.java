package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    WebDriverWait wait;
    @FindBy(css = "h5[data-test='product-name']")
    List<WebElement> productNames;

    @FindBy(id = "quantity-input")
    WebElement txtQuantity;

    @FindBy( id = "btn-add-to-cart")
    WebElement btnAddToCart;

    @FindBy(id = "lblCartCount")
    WebElement navCartCount;

    @FindBy(css = "a[href='/checkout']")
    WebElement btnCheckout;

    @FindBy(css = "span[data-test='product-price']")
    public WebElement initialPrice;

    @FindBy(css = "td[data-test='cart-total']")
    public WebElement totalPrice;



    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void selectProduct(String productName) {
        for(WebElement pname: productNames){
            if(pname.getText().equals(productName)){
                pname.click();
                break;
            }
        }
    }
    public void productQuantity(int quantity){
        wait.until(ExpectedConditions.visibilityOf(txtQuantity));
        txtQuantity.clear();
        txtQuantity.sendKeys(String.valueOf(quantity));
    }

    public void  clickBtnAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
    }

    public String verifyCheckoutCount(){
        wait.until(ExpectedConditions.visibilityOf(navCartCount));
        return navCartCount.getText();

    }

    public void toastDisappeared(){
        By toastDisappeared = By.cssSelector("div.toast-message");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastDisappeared));

    }

    public void navigateCheckoutPage() {
        toastDisappeared();
        btnCheckout.click();

    }


    public double intialPriceAmount() {
        wait.until(ExpectedConditions.visibilityOf(initialPrice));
        String priceText = initialPrice.getText().replaceAll("[$]", "").trim();
        return Double.parseDouble(priceText);
    }
    public double totalPriceAmount() {
        wait.until(ExpectedConditions.visibilityOf(totalPrice));
        String priceText = totalPrice.getText().replaceAll("[$]", "").trim();
        return Double.parseDouble(priceText);
    }



}
