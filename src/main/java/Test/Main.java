package Test;

import Page.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    private WebDriver driver1;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.ebay.com/");
//        driver.manage().window().maximize();
        WebDriver driver1= new ChromeDriver();
        driver1.get("https://www.amazon.com/");
        driver1.manage().window().maximize();
        Search search = new Search(driver1);
        search.search1();
        SearchPage searchPage= new SearchPage(driver1);
        searchPage.extractData();
        searchPage.checkValidate();

    }

}
