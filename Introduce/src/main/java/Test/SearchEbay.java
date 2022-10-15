package Test;

import Page.HomePageEbay;
import org.openqa.selenium.WebDriver;

public class SearchEbay {
    private  WebDriver driver;
    public HomePageEbay homePageEbay;
    public SearchEbay(WebDriver driver) {
        this.driver = driver;
    }

    public void search2(){
        homePageEbay= new HomePageEbay(driver);
        homePageEbay.searchIPage("iPhone 11");

    }
}
