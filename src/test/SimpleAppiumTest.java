package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * A simple appium test for the open source maps app which can be downloaded
 * from the following link: https://github.com/vanyaland/Californication
 * 
 * @author Feliks Rozenberg frozenbe@alumni.uwo.ca
 */
@SuppressWarnings("deprecation")
public class SimpleAppiumTest {

	private AppiumDriver<WebElement> driver;
	private SimpleAppPageObject simpleAppPageObject;

	@Before
	public void setUp() throws Exception {
		// set up appium
		// Provide the path to the maps app
		String appPath = System.getProperty("appPath");
		System.out.println("appPath: " + appPath);
		File app = new File(appPath);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "9.1");
		capabilities.setCapability("deviceName", "iPhone 6s");
		capabilities.setCapability("app", app.getAbsolutePath());

		simpleAppPageObject = new SimpleAppPageObject();
		driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testLaunchMap() throws Exception {

		simpleAppPageObject.mapElement.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		assertTrue(true);

	}

}
