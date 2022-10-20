package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePageAmazon {
    private WebDriver driver;

    public HomePageAmazon(WebDriver driver) {
        this.driver = driver;
    }
    public void searchPage(String search) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }
}
