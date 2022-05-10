package com.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Page.HomePage;
import com.Utility.TestUtil;

public class HomePageTest extends Base {
	
	HomePage Homepage;
	TestUtil testutil;

	public HomePageTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void SetUp() throws IOException {
		initialization();
		Homepage = new HomePage();
		
	}
	@Test
	public void PageTitleTest() {
		Homepage.PageTitle();
	}
	@Test
	public void searchBoxFunctionTest() throws IOException {
		Homepage.searchBoxFunction(PropFile);
		Assert.assertEquals("Iphone Cases", "Iphone Cases");
	}
	@Test
	public void customerServiceLinkTest() throws IOException {
		Homepage.customerServiceLink();
		
	}
	@Test
	public void ClickCartFieldTest() throws IOException {
		Homepage.ClickCartField();
		
	}
	@Test
	public void ConditionOfUseLinkTest() throws IOException {
		Homepage.ConditionOfUseLink();
		
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}
