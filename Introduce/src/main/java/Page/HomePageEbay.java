package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageEbay {
    private WebDriver driver;
    public HomePageEbay(WebDriver driver){
        this.driver= driver;
    }
    public void searchIPage(String search){
        driver.findElement(By.id("gh-ac-box2")).sendKeys(search);

    }


}
