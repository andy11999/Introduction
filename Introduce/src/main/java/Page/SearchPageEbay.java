package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPageEbay {
    private String title = "";
    private String product = "";
    private float price;
    private String link = "";
    private WebDriver driver;

    public SearchPageEbay(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPageEbay(String title, String product, float price, String link) {
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
    public void extractEbay() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<SearchPageEbay> s = new ArrayList<>();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        ArrayList<SearchPageEbay> e = new ArrayList<>();
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='s-item__title']"));
        SearchPageEbay searchPageEbay = null;
        for (int i = 0; i < list.size(); i++) {
            title = ("https://ebay.com");
            String ppath = "/html[1]/body[1]/div[8]/div[4]/div[2]/div[1]/div[2]/ul[1]/li[" + (i + 2) + "]/div[1]/div[2]/a[1]/div[1]/span[1]";
            List<WebElement> l = driver.findElements(By.xpath(ppath));
            if (l.size() > 0) {
                product = driver.findElement(By.xpath(ppath)).getText();
//                System.out.println(product);
            } else {
                product = "null";
            }
            String xpath = "/html[1]/body[1]/div[8]/div[4]/div[2]/div[1]/div[2]/ul[1]/li[" + (i + 2) + "]/div[1]/div[2]/div[3]/div[1]/span[1]";
            List<WebElement> listP = driver.findElements(By.xpath(xpath));
            if (listP.size() > 0) {
                String p = driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
                if (p.contains("<span class=\"DEFAULT\"> to </span>")) {
                    if (p.contains(" VND")) {
                        String y = p.replace("<span class=\"DEFAULT\"> to </span>", " ").replace(" VND", "").replace(",", "");
                        String[] z = y.split(" ");
                        Float w1 = Float.parseFloat(z[1]) / 23000;
                        price = w1;
                    } else {
                        String y = p.replace("<span class=\"DEFAULT\"> to </span>", " ").replace("$", "").replace(",", "");
                        String[] z = y.split(" ");
                        Float w1 = Float.parseFloat(z[1]);
                        price = w1;
                    }

                } else {
                    if (p.contains(" VND")) {
                        price = Float.parseFloat(p.replace(" VND", "").replace(",", ""));
                    }else{
                        price = Float.parseFloat(p.replace("$", "").replace(",", ""));
                    }
                }
            } else {
                price = 0;
            }
//            System.out.println(price);
            String lpath = "/html[1]/body[1]/div[8]/div[4]/div[2]/div[1]/div[2]/ul[1]/li[" + (i + 2) + "]/div[1]/div[2]/a[1]";
            List<WebElement> lp = driver.findElements(By.xpath(lpath));
            if (lp.size() > 0) {
                link = driver.findElement(By.xpath(lpath)).getAttribute("href");
            } else {
                link = "null";
            }
//            System.out.println(link);
            searchPageEbay = new SearchPageEbay(title, product, price, link);
            System.out.println(searchPageEbay);
        }


    }

    public void mention(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='s-item__title']"));
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
