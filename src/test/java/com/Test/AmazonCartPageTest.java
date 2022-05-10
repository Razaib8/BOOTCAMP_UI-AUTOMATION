package com.Test;

import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Page.AmazonCartPage;
import com.Page.HomePage;
import com.Utility.TestUtil;

public class AmazonCartPageTest extends Base{
	
	AmazonCartPage Amazoncartpage;
	HomePage Homepage;
	TestUtil testUtil;
	
	public AmazonCartPageTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		Amazoncartpage = new AmazonCartPage();
		Homepage = new HomePage ();
		testUtil = new TestUtil();
				
	}
	@Test
	public void CartLinkTest () throws IOException {
		Amazoncartpage.CartLink();
	}
	@Test
	public void SignInLinkTest () throws IOException {
		Amazoncartpage.SignInLink();
	}
	@Test
	public void SignUpLinkTest () throws IOException {
		Amazoncartpage.SignUpLink();
	}
	@Test
	public void AddToCartTest() throws IOException {
		Amazoncartpage.AddToCart();
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}

