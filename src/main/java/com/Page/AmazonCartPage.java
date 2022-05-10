package com.Page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Base.Base;
import com.Utility.TestUtil;

public class AmazonCartPage extends Base {
	
	TestUtil testUtil;
	//PAGE FACTORY OBJECT REPOSITORY
	
	@FindBy(id = "nav-cart-count-container")
	WebElement Cart_Link;
	
	@FindBy(partialLinkText = "Sign in to your account")
	WebElement Signin_Button;
	
	@FindBy(partialLinkText = "Sign up now")
	WebElement Signup_Button;
	
	@FindBy(id = "add-to-cart-button")
	WebElement AddToCart_Button;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement Search_Box;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement Search_Button;
	
	@FindBy(partialLinkText = "Razstorm Unique")
	WebElement Selected_item;
	
	// PAGE FACTORY INITIALIZATION

	public AmazonCartPage() throws IOException {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}

	public void CartLink () throws IOException {
		Cart_Link.click();
		String title = driver.getTitle();
		System.out.println("The Present Page Title is : " +title);
		testUtil.takeScreenShot("Cart_MainPage_Validation");
		Assert.assertEquals(title,"Amazon.com Shopping Cart");
	}
	
	public void SignInLink () throws IOException {
		Cart_Link.click();
		Signin_Button.click();
		String title = driver.getTitle();
		System.out.println("The Present Page Title is : " +title);
		testUtil.takeScreenShot("Cart_SignInPage_Validation");
		Assert.assertEquals(title, "Amazon Sign-In");
	}
	
	public void SignUpLink () throws IOException {
		Cart_Link.click();
		Signup_Button.click();
		String title = driver.getTitle();
		System.out.println("The Present Page Title is : " +title);
		testUtil.takeScreenShot("Cart_SignUpPage_Validation");
		Assert.assertEquals(title, "Amazon Registration");
	}
	
	public void AddToCart () throws IOException {
		Search_Box.sendKeys(prop.getProperty("text"));
		Search_Button.click();
		Selected_item.click();
		AddToCart_Button.click();
		String title = driver.getTitle();
		System.out.println("The Present Page Title is : " +title);
		testUtil.takeScreenShot("AddToCart_Validation");
		Assert.assertEquals(title, "Amazon.com Shopping Cart");
	}
}


