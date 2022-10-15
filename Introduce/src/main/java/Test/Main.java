package Test;

import Page.SearchPage;
import Page.SearchPageEbay;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {
    private WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Search search = new Search(driver);
        search.search1();
        SearchPage searchPage= new SearchPage(driver);
        searchPage.checkValidate();
        searchPage.extractData();
//        ArrayList<Object> o= new ArrayList<>();
//        o.add(searchPage);
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        SearchPageEbay searchPageEbay= new SearchPageEbay(driver);
        SearchEbay searchEbay= new SearchEbay(driver);
        searchEbay.search2();
        searchPageEbay.mention();
        searchPageEbay.extractEbay();
//        o.add(searchPageEbay);
//        System.out.println(o);
        driver.quit();


//        driver1.quit();
//      driver.quit();


    }

}
