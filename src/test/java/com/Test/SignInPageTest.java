package com.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Page.HomePage;
import com.Page.SignInPage;
import com.Utility.TestUtil;

public class SignInPageTest extends Base {
	
	HomePage Homepage;
	SignInPage SignInpage;
	TestUtil testUtil;
	
	public SignInPageTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setUp () throws IOException {
		initialization();
		SignInpage = new SignInPage();
		testUtil = new TestUtil();
		Homepage = new HomePage();  
	}
	
	
	@Test (priority=1)
	public void SignInFieldTest() throws IOException {
		SignInpage.SignInField();
		String title = driver.getTitle();
		System.out.println("The title of the present Page is : " +title);
		Assert.assertEquals(title , "Amazon Sign-In");
	}
	@Test (priority=2)
	public void UserIDPhoneTest() throws IOException {
		SignInpage.UserIDPhone(PropFile);
		String title = driver.getTitle();
		System.out.println("The title of the present Page is : " +title);
		Assert.assertEquals(title, "Amazon Sign-In");
	}
	@Test (priority=3)
	public void PasswordFieldTest() throws IOException {
		SignInpage.PasswordField(PropFile);
		String title = driver.getTitle();
		System.out.println("The title of the present Page is : " +title);
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}
	@Test (priority=4)
	public void SignOutTest () throws IOException {
		SignInpage.SignOut();
		String title = driver.getTitle();
		System.out.println("The title of the present Page is : " +title);
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}


}
