package Test;

import Page.HomePageAmazon;
import Page.HomePageEbay;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search{
    private  WebDriver driver;
    public Search(WebDriver driver){
        this.driver= driver;
    }
    public HomePageAmazon homePageAmazon;


    public void search1(){
        homePageAmazon= new HomePageAmazon(driver);
        homePageAmazon.searchPage("iPhone 11");

    }



}
