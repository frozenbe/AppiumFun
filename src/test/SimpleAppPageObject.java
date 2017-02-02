package test;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * A sample to show how to write page object classes
 * *
 * @author Feliks Rozenberg
 * frozenbe@alumni.uwo.ca
 *
 */
public class SimpleAppPageObject {
	
	@iOSFindAll({ @iOSFindBy(accessibility = "Map") })
	public WebElement mapElement;


}
