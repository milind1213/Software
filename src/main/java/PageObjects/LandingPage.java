
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.AbstractComponent;

public class LandingPage extends AbstractComponent   {
	  WebDriver driver;
	  WebDriverWait wait;

	  public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goTo(String url) {
		String defaultUrl = "https://basecopy5.staging.pg-test.com/v2/";
		if (url == null) {
			url = defaultUrl;
		}
		driver.get(url);
	}


}
	  
	 
