package com.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Base {
	public static WebDriver driver;
	public static Properties prop;
	
	public String PropFile="C:\\Users\\rafri\\eclipse-workspace\\AmazonTesting\\src\\main\\java\\com\\Configuration\\config.properties";
	//Constructor
	public Base() throws IOException {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(PropFile);
			prop.load(file);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	//Initialization
	public static void initialization()  {
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rafri\\eclipse-workspace\\AmazonTesting\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browsername.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\rafri\\eclipse-workspace\\AmazonTesting\\Drivers\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	

}

