package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseSetup {
    private WebDriver driver;
    static String driverPath ="resources\\drivers\\";

    public WebDriver getDriver() {
        return driver;
    }
    @Parameters({"appURL" })
    @BeforeMethod
    private static WebDriver initChromeDriver(String appURL){
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver_32.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }


}
