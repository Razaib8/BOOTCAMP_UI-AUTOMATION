package com.Page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Base.Base;
import com.Utility.TestUtil;

public class RegisterationPage extends Base {
	
	TestUtil testUtil;
	
	//PAGE FACTORY OBJECT REPOSITORY
	
	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	WebElement SignIn_Link;
	
	@FindBy(xpath = "//*[@id='auth-create-account-link']")
	WebElement CreateAccount_Button;
	
	 @FindBy(id = "ap_customer_name")
	 WebElement Your_Name;
	 
	 @FindBy(id = "ap_email")
	 WebElement Phone_Email;
	 
	 @FindBy(id = "ap_password")
	 WebElement Pass_word;
	 
	 @FindBy(id = "ap_password_check")
	 WebElement Password_Check;
	 
	 @FindBy(id = "continue")
	 WebElement Continue_Button;

	public RegisterationPage() throws IOException {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		
	}
	public void PageTitle() throws IOException {
		SignIn_Link.click();
		String title = driver.getTitle();
		Assert.assertEquals(title,"Amazon Sign-In");
		System.out.println("The present Page title is : " +title);
		testUtil.takeScreenShot("SIgnIn_PAge_Validation");
		CreateAccount_Button.click();
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Amazon Registration");
		System.out.println("The Present Page title is : " +title1);
		testUtil.takeScreenShot("Registration_Page_Validation");
	}
	
	public void RegisterNewUser (String Yourname, String Mobilenumber_Email, String Password, String Re_enterPassword ) {
		Your_Name.sendKeys(Yourname);
		Phone_Email.sendKeys(Mobilenumber_Email);
		Pass_word.sendKeys(Password);
		Password_Check.sendKeys(Re_enterPassword);
		Continue_Button.click();

}
}
