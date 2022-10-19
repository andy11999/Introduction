package testcase;

import model.Product;
import org.testng.annotations.Test;
import page.HomePageAmazon;
import page.HomePageEbay;
import core.BaseSetup;
import org.openqa.selenium.WebDriver;
import page.SearchPageAmazon;
import page.SearchPageEbay;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchIphoneTest extends BaseSetup {
    private WebDriver driver;

    @Test
    public void search1(){
        SearchPageAmazon searchPageAmazon = new SearchPageAmazon();
        SearchPageEbay searchPageEbay= new SearchPageEbay();
        HomePageAmazon homePageAmazon = new HomePageAmazon(driver);
        homePageAmazon.searchPage("iPhone 11");
        homePageAmazon.searchPage("iPhone11");
        List<Product> listProductAmazon= searchPageAmazon.extractData() ;
        List<Product> listProductEbay= searchPageEbay.extractData();
        listProductEbay.addAll(listProductAmazon);
        List<Product> sortedProduct = listProductEbay.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
        for (int i = 0; i < sortedProduct.size(); i++) {
            System.out.println(sortedProduct.get(i));
            if(sortedProduct.get(i).getProductName().contains("iPhone 11")){
                System.out.println("Mention Product");
            }else{
                System.out.println("Does not mention product");
            }
        }


    }




}
