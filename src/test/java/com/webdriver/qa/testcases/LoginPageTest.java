package com.webdriver.qa.testcases;


import org.testng.annotations.*;
import com.webdriver.qa.base.TestBase;
import com.webdriver.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
	}
	@DataProvider(name = "InvalidLogin")
	public Object[][] provideInvalidLogins()
	{
		return new Object[][] { {"foo@gmail.com","bar123","Invalid email or password, or your account may be locked."}, // non-existing user
								{"foo@bar.com","bar","Invalid email or password, or your account may be locked."} // invalid email id
								};
	}
	
	
	/* Test case 1 : Login with invalid user name and password and validate error message.
	 * Steps :
	 * 
	 *  1. Go to Login page.
	 *  2. Enter invalid User Name and Password.
	 *  3. Hit Login.
	 *  
	 *  Expected :  Following error message is displayed : Invalid email or password, or your account may be locked.
	 */
	
	@Test(dataProvider = "InvalidLogin")
	public void verifyInvalidLogin(String username, String password, String errorMsg)
	{		
		loginPage.setLoginDataAndClick(username, password);
		loginPage.validateInvalidLogin(errorMsg);		
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

	
}
