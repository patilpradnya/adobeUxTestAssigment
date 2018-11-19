package com.webdriver.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static void waitForWebElement(WebElement element, WebDriver driver) {

        try{
        	 WebDriverWait wait = new WebDriverWait(driver, Timeouts.IMPLICIT_WAIT);
        	 wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Element not found on page.");
        }

    }
}
