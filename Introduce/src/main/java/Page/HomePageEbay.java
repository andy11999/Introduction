package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePageEbay {
    private WebDriver driver;
    public HomePageEbay(WebDriver driver){
        this.driver= driver;
    }
    public void searchIPage(String search){
        driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys(search);
        driver.findElement(By.xpath("//input[@value='Search']")).click();
//        driver.findElement(By.xpath("//button[@class='x-flyout__button']")).click();
//        Select dropC= new Select(driver.findElement(By.xpath("//select[@id='s0-51-12-5-4[0]-42-0-7-13-select']")));
//        dropC.selectByVisibleText("Austria - AUT");
//        driver.findElement(By.xpath("//input[@value='Go']")).click();

    }


}
