package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.time.Duration;

public class Setup {
    public WebDriver driver;

    @BeforeClass
    public void Setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicesoftwaretesting.com/");
    }
    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}
