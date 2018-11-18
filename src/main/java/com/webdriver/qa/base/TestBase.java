package com.webdriver.qa.base;

import com.webdriver.qa.util.Timeouts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    static Properties prop;

    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/webdriver/qa/config/config.properties");
            prop.load(fis);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    
    public static void init() {
        String browser = prop.getProperty("browser");
        if(browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver");
            driver = new ChromeDriver();

        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Timeouts.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Timeouts.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        
    }
}
