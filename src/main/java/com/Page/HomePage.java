package com.Page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base;
import com.Utility.TestUtil;


public class HomePage extends Base {
	
	TestUtil testUtil = new TestUtil();
	
	//PAGE FACTORY OBJECT REPOSITORY
	@FindBy(id = "twotabsearchtextbox")
	WebElement Search_Box;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement Search_Button;
	
	@FindBy(partialLinkText = "Customer Service")
	WebElement Customer_Service_Link;
	
	@FindBy(xpath = "//a[@id='nav-cart']")
	WebElement cart_button;
	
	@FindBy(partialLinkText = "Conditions of Use")
	WebElement Conditions_of_Use_Link;
	
	//PAGE FACTORY INITIALIZATION
	public HomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
		}
	
	public void PageTitle() {
		String title = driver.getTitle();
		System.out.println("The page title is :" +title);
	}
	
	public void searchBoxFunction(String text) throws IOException {
		Search_Box.sendKeys(prop.getProperty("text"));
		Search_Button.click();
		testUtil.takeScreenShot("Amazon_Search_Validation");
	}
	
	public void customerServiceLink() throws IOException {
		Customer_Service_Link.click();
		String title = driver.getTitle();
		System.out.println("The given page title is : " +title);
		testUtil.takeScreenShot("Customer_Service_Validation");
	}

	public void ClickCartField() throws IOException {
		cart_button.click();
		String title = driver.getTitle();
		System.out.println("The given Page title is : " +title);
		testUtil.takeScreenShot("Cart_Field_Validation");
	}
	
	public void ConditionOfUseLink() throws IOException {
		Conditions_of_Use_Link.click();
		String title = driver.getTitle();
		System.out.println("The given Page title is : " +title);
		testUtil.takeScreenShot("Condition_of_Use_Validation");
	}
	
	

}
