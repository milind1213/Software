
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.AbstractComponent;

import java.time.Duration;
import java.time.Instant;

public class LandingPage extends AbstractComponent   {
	  WebDriver driver;
	  WebDriverWait wait;

	  public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
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
	  
	 
