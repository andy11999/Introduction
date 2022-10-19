package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageEbay {
    private WebDriver driver;
    public HomePageEbay(WebDriver driver){
        this.driver= driver;
    }
    public void searchPage(String search){
        driver.get("www.ebay.com");
        driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys(search);
        driver.findElement(By.xpath("//input[@value='Search']")).click();

    }
}
