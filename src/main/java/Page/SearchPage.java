package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchPage {

    private String title="";
    private String product="";
    private String price ="";
    private String link="";
    private WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver= driver;

    }
    public SearchPage(String title, String product, String price, String link){
        this.title= title;
        this.product=product;
        this.price= price;
        this.link=link;
    }

    @Override
    public String toString(){
        return "Name of Page: "+ this.title + " Name of product: "+ this.product +" Price: "+ this.price+ " Link: "+this.link;
    }
    public void extractData(){
        String title= driver.getTitle();
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement w: list){
             product = w.getText();
        }
        List<WebElement> list1 = driver.findElements(By.xpath("//span[@class='a-price']"));
        for (WebElement w: list1){
            price= w.getText();
        }
        List<WebElement> list2 = driver.findElements(By.xpath("//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        for (WebElement w: list2){
            link= w.getAttribute("href");
        }

        SearchPage searchPage= new SearchPage(title,product,price,link);
        System.out.println(searchPage);


    }
    public void checkValidate(){
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement w: list){
            String product = w.getText();
            String key ="iPhone 11";
            if(product.contains(key)){
                System.out.println("Mention product");;
            }else{
                System.out.println("Does not mention product");
            }

        }
    }

}
