package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;


public class SearchPage {

    private String title = "";
    private String product = "";
    private float price;
    private String link = "";
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;

    }

    public SearchPage(String title, String product, float price, String link) {
        this.title = title;
        this.product = product;
        this.price = price;
        this.link = link;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Name of Page: " + this.title + " Name of product: " + this.product + " Price: " + this.price + " Link: " + this.link;
    }
    public void extractData() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        ArrayList<SearchPage> s = new ArrayList<>();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> x = driver.findElements(By.xpath("//*[(@class='a-size-medium a-color-base a-text-normal')]"));
        SearchPage searchPage = null;
        for (int i = 0; i < x.size(); i++) {
            title = "https://amazon.com";
            String t = "//div[@data-index=" + (i + 2) + "]//span[@class='a-size-medium a-color-base a-text-normal']";
            List<WebElement> q = driver.findElements(By.xpath(t));
            {
                if (q.size() > 0) {
                    product = driver.findElement(By.xpath(t)).getText();
                } else {
                    product = "null";
                }
            }
            String xpath = "//div[@data-index=" + (i + 2) + "]//span[@class='a-price']//span[@class='a-offscreen']";
            List<WebElement> prdList = driver.findElements(By.xpath(xpath));
            if (prdList.size() > 0) {
                String prdPrice = driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
                price = Float.parseFloat(prdPrice.replace("$", "").replace(",", ""));

            } else {
                price = 0;
//                System.out.println("No price of prd");
            }

            String xpathLink = "//div[@data-index=" + (i + 2) + "]//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
            List<WebElement> linlLst = driver.findElements(By.xpath(xpathLink));
            if (linlLst.size() > 0) {
                link = driver.findElement(By.xpath(xpathLink)).getAttribute("href");
            } else {
                link = "null";
            }
            searchPage = new SearchPage(title, product, price, link);
            System.out.println(searchPage);

        }


    }

    public void checkValidate() {
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement w : list) {
            String product = w.getText();
            String key = "iPhone 11";
            if (product.contains(key)) {
                System.out.println("Mention product");
                System.out.println(w.getText());
            } else {
                System.out.println("Does not mention product");
            }

        }
    }

}
