package page;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchPageAmazon {

    String title = "";
    String productName = "";
    float price;
    String link = "";
    private WebDriver driver;

    public List<Product> extractData() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Product> listProducts = new ArrayList<>();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String productNameXpath = "//*[(@class='a-size-medium a-color-base a-text-normal')]";
        String priceXpath = "//span[@class='a-offscreen']";
        String linkXpath = "//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
        for (int i = 0; i < products.size(); i++) {
            title = "www.amazon.com";
            try {
                productName = products.get(i).findElement(By.xpath(productNameXpath)).getText();
            } catch (NoSuchElementException e) {
                productName = "null";
            }
            try {
                price = Float.parseFloat(products.get(i).findElement(By.xpath(priceXpath)).getAttribute("innerHTML"));
            } catch (NoSuchElementException e) {
                price = 0;
            }
            try {
                link = products.get(i).findElement(By.xpath(linkXpath)).getAttribute("href");
            } catch (NoSuchElementException e) {
                link = "null";
            }
            Product product = new Product(title, productName, price, link);
            listProducts.add(product);

        }

        return listProducts;


    }


}
