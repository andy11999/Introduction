package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePageEbay {
    private final WebDriver driver;

    public HomePageEbay(WebDriver driver) {
        this.driver = driver;
    }
    public void searchPage(String search) {
        driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys(search);
        driver.findElement(By.xpath("//input[@value='Search']")).click();

    }
}
