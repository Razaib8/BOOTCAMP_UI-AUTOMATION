package com.Page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base;
import com.Utility.TestUtil;

public class SignInPage extends Base {
	
	TestUtil testUtil = new TestUtil();
	
	//PAGE FACTORY OBJECT REPOSITORY
	
	@FindBy(id = "nav-link-accountList")
	WebElement SignIn_Source;
	
	@FindBy(id = "ap_email")
	WebElement Email_Phone;
	
	@FindBy(id = "continue")
	WebElement Continue_Button;
	
	@FindBy(id = "ap_password")
	WebElement Pass_word;
	
	@FindBy(id = "auth-signin-button")
	WebElement Sign_In;
	
	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	WebElement My_Account;
	
	@FindBy(id = "nav-item-signout")
	WebElement Sign_Out;
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement Validate_Login;

	// PAGE FACTORY INITIALIZATION
	public SignInPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public void SignInField() throws IOException {
		SignIn_Source.click();
		testUtil.takeScreenShot("UserName_Page_Validation");
		
		
	}
	
	public void UserIDPhone(String username) throws IOException {
		SignIn_Source.click();
		Email_Phone.sendKeys(prop.getProperty("username"));
		testUtil.takeScreenShot("Entering_Username_Validation");
		Continue_Button.click();
		testUtil.takeScreenShot("Enter_Password_Page_Validation");
	}
	
	public void PasswordField(String password) throws IOException {
		SignIn_Source.click();
		Email_Phone.sendKeys(prop.getProperty("username"));
		Continue_Button.click();
		Pass_word.sendKeys(prop.getProperty("password"));
		testUtil.takeScreenShot("Entering_Password_Validation");
		Sign_In.click();
		testUtil.takeScreenShot("SignedIn_Page_Validation");
		String text = Validate_Login.getText();
		System.out.println("The Login name visible is : " +text);
	}
	 
	public void SignOut() throws IOException {
		SignIn_Source.click();
		Email_Phone.sendKeys(prop.getProperty("username"));
		Continue_Button.click();
		Pass_word.sendKeys(prop.getProperty("password"));
		Sign_In.click();
		Actions action = new Actions(driver);
		action.moveToElement(My_Account).click(Sign_Out).build();
		testUtil.takeScreenShot("Signed_Out_Validation");
	}

}
