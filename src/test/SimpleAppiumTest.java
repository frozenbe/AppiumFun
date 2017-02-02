package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
		capabilities.setCapability("platformVersion", "9.0");
		capabilities.setCapability("deviceName", "iPhone 6s");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testLaunch() throws Exception {

		Thread.sleep(3000);

		assertTrue(true);

	}

}
