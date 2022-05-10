package com.Test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Page.HomePage;
import com.Page.RegisterationPage;
import com.Page.SignInPage;
import com.Utility.TestUtil;

public class RegistrationPageTest extends Base {
	
	HomePage Homepage;
	SignInPage SigninPage;
	TestUtil testUtil;
	RegisterationPage registrationPage;
	public static String SheetName = "AmazonRegData";

	public RegistrationPageTest() throws IOException {
	}	@BeforeMethod
		public void SetUp () throws IOException {
			initialization();
			Homepage = new HomePage();
			SigninPage = new SignInPage();
			testUtil = new TestUtil();
			registrationPage = new RegisterationPage();
		}
		@Test
		public void PageTitleTest() throws IOException {
			registrationPage.PageTitle();
			
	}
		@DataProvider
		public Object[][] getAmazonRegData() {
			Object[][] datas = TestUtil.getAmazonRegData(SheetName);
			return datas;
		}
		@Test(dataProvider = "getAmazonRegData")
		public void RegisterNewUserTest (String Yourname, String Mobilenumber_Email, String Password, String Re_enterPassword ) {
			registrationPage.RegisterNewUser(Yourname, Mobilenumber_Email, Password, Re_enterPassword);
		}
	
	

}
