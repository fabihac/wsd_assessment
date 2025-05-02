package testrunner;

import config.Setup;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

import java.time.Duration;

public class ProductPageRunner extends Setup {
    ProductPage productPage;

    @Test(priority = 1, description = "Adding Product ")
    public void navigateToProductPage(){
        productPage = new ProductPage(driver);
        productPage.selectProduct("Combination Pliers");
    }
    @Test(priority = 2, description = "Adding Product to cart ")
        public void addProductToCart(){
            productPage = new ProductPage(driver);
            productPage.productQuantity(3);
            productPage.clickBtnAddToCart();

            String count = productPage.verifyCheckoutCount();
            System.out.println("Checkout Count is="+count);
    }

    @Test(priority = 3, description = "Adding Product to cart ")
    public void nevigateToCart(){
            productPage = new ProductPage(driver);
            productPage.navigateCheckoutPage();

            double initialamount = productPage.intialPriceAmount();
            double totalAmount = productPage.totalPriceAmount();

            Assert.assertEquals(totalAmount,initialamount * 3);
            System.out.println("Total Amount is="+totalAmount);
            System.out.println("Initial Amount is="+initialamount*3);



        }





    }


