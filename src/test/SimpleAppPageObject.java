package test;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * A sample to show how to write page object classes *
 * 
 * @author Feliks Rozenberg frozenbe@alumni.uwo.ca
 *
 */
public class SimpleAppPageObject {

	@iOSFindAll({ @iOSFindBy(accessibility = "Map") })
	public WebElement mapElement;

	@iOSFindAll({ @iOSFindBy(accessibility = "sorting") })
	public WebElement sortingElement;
	
	@iOSFindAll({ @iOSFindBy(accessibility = "By name") })
	public WebElement sortingByName;
	
	@iOSFindAll({ @iOSFindBy(accessibility = "Google Maps") })
	public WebElement googleMaps;
	
	
	

}
