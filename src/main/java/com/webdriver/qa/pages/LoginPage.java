package com.webdriver.qa.pages;

import com.webdriver.qa.base.TestBase;
import com.webdriver.qa.util.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;


public class LoginPage extends TestBase {

    @FindBy(id = "userEmail")
    protected WebElement userEmail;

    @FindBy(id = "userPassword")
    protected WebElement userPassword;

    @FindBy(id = "login")
    protected WebElement loginButton;

    @FindBy(id = "loginForm-error-message")
    protected WebElement loginFormErrorMsg;
    

    public LoginPage()
    {
        PageFactory.initElements(driver, this);
        
    }
    
    public void setLoginDataAndClick(String userName, String userPass) {
    	userEmail.clear();
    	userEmail.sendKeys(userName);
    	userPassword.clear();
    	userPassword.sendKeys(userPass);
    	loginButton.click();
    }
    
    public void validateInvalidLogin(String invalidLoginMsg) {

    	Utils.waitForWebElement(loginFormErrorMsg, driver);
    	assertEquals(loginFormErrorMsg.getText(),invalidLoginMsg,"Presence of different error message instead of expected message.");
    }
    
    
}
