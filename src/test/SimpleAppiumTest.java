package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * 
 * @author Feliks Rozenberg frozenbe@alumni.uwo.ca
 */
@SuppressWarnings("deprecation")
public class SimpleAppiumTest {

	private AppiumDriver<WebElement> driver;

	@Before
	public void setUp() throws Exception {
		// set up appium
		String appPath = System.getProperty("appPath");
		System.out.println("appPath: " + appPath);
		File app = new File(appPath);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("deviceName", "iPhone 6");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testSignInValidCreds(String userName, String password) throws Exception {

		Thread.sleep(3000);
		// Fill in and submit
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAScrollView[1]/UIATextField[1]"))
				.sendKeys(userName);
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAScrollView[1]/UIASecureTextField[1]"))
				.sendKeys(password);
		driver.findElement(MobileBy.AccessibilityId("Sign In")).click();
		Thread.sleep(3000);

		// Allow camera
		driver.switchTo().alert().accept();
		Thread.sleep(5000);

		// Switch tab
		driver.findElement(MobileBy.AccessibilityId("Sell")).click();
		Thread.sleep(5000);

		assertTrue(driver.findElement(MobileBy.AccessibilityId("Synthetic Free Listing")).isDisplayed());

	}

}
