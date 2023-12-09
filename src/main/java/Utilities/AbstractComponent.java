package Utilities;
  import java.text.DateFormat;
  import java.text.SimpleDateFormat;
  import java.time.Duration;
  import java.util.*;
  import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
  import org.openqa.selenium.*;
  import org.openqa.selenium.NoSuchElementException;
  import org.openqa.selenium.interactions.Actions;
  import org.openqa.selenium.interactions.Coordinates;
  import org.openqa.selenium.interactions.Locatable;
  import org.openqa.selenium.logging.LogEntry;
  import org.openqa.selenium.logging.LogType;
  import org.openqa.selenium.support.FindBy;
  import org.openqa.selenium.support.PageFactory; import
  org.openqa.selenium.support.ui.ExpectedConditions;
  import org.openqa.selenium.support.ui.Select;
  import org.openqa.selenium.support.ui.WebDriverWait;
  import org.testng.Assert;
  import static org.apache.commons.compress.harmony.pack200.PackingUtils.log;

  public class AbstractComponent {

  WebDriver driver;
  public AbstractComponent(WebDriver driver) {
  this.driver = driver;
  PageFactory.initElements(driver, this);

  }public void scrollToElement(WebDriver driver, By locator, int yOffset) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		js.executeScript("window.scrollBy(0, arguments[0]);", yOffset);
	}

	public void waitForElementToBeClickable(WebDriver driver, By by, int seconds) {
	    try {
	        new WebDriverWait(driver, Duration.ofSeconds(seconds))
	            .until(ExpectedConditions.elementToBeClickable(by));
	    } catch (Exception e) {
	        System.err.println("Waited for element [" + by.toString() + "] to be clickable for " + seconds + " seconds");
	    }
	}
	 public static void scrollToElementAndClick(WebDriver driver,WebElement element) {
	        scrollToElement(driver, element);
	        element.click();
	    }

	    private static void scrollToElement(WebDriver driver, WebElement element) {
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", element);
	    }

	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToAppear(WebElement ele, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void selectDropdownOptionByText(WebDriver driver, By dropdownLocator, String optionText) {
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		select.selectByVisibleText(optionText);
	}

	protected void waitForElementDisplay(WebElement ele, int seconds) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			System.err.println("Waited for element [" + ele + "] for " + seconds + " seconds");
		}
	}

	 public void waitForElementPresence(WebDriver driver,By by, int seconds) {
	        try {
	            new WebDriverWait(driver, Duration.ofSeconds(seconds))
	                    .until(ExpectedConditions.presenceOfElementLocated(by));
	        } catch (Exception e) {
	            System.err.println("Waited for element [" + by.toString() + "] presence for " + seconds + " seconds");
	        }
	    }

	    public void waitForElementVisibility(WebDriver driver , By by, int seconds) {
	        try {
	            new WebDriverWait(driver, Duration.ofSeconds(seconds))
	                    .until(ExpectedConditions.visibilityOfElementLocated(by));
	        } catch (Exception e) {
	            System.err.println("Waited for element [" + by.toString() + "] visibility for " + seconds + " seconds");
	        }
	    }

	    public void waitForElementToBeClickable(By by, int seconds) {
	        try {
	            new WebDriverWait(driver, Duration.ofSeconds(seconds))
	                    .until(ExpectedConditions.elementToBeClickable(by));
	        } catch (Exception e) {
	            System.err.println("Waited for element [" + by.toString() + "] to be clickable for " + seconds + " seconds");
	        }
	    }
	    
	protected void waitForElementDisplay(WebDriver driver, By locator, int seconds) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(seconds))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			System.err.println("Waited for element located by [" + locator + "] for " + seconds + " seconds");
		}
	}

	public void waitFor(int i) {
		try {
			Thread.sleep(1000 * i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getText(By locator) {
		try {
			waitFor(2);
			return driver.findElement(locator).getText();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to get String for element [" + locator + "]");
		}
		return null;
	}

	public boolean isTextInPage(String text) {
		try {
			return driver.getPageSource().contains(text);
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForNBLoad(int seconds) {
		try {
			for (int i = 0; i < seconds / 2; i++) {
				waitFor(1);
				if (!driver.getPageSource().contains("Loading..."))
					break;
				else
					System.out.println("Loading...");
			}

		} catch (Exception e) {
			System.err.println("Loading error");
		}

	}

	public boolean isTextPresent(WebDriver driver, String actualText) {
		return actualText.contains(actualText);
	}

	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void clickElementWithText(String textVal) {
		String xpath = String.format("//*[text()='%s' or contains(text(),'%s')]", textVal, textVal);
//	        waitFor(2);
		click(By.xpath(xpath));
	}

	public void clearElement(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		element.clear();
	}

	public void javascriptClick(By locators) {
		try {
			waitFor(1);
			WebElement element = driver.findElement(locators);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			waitFor(1);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to click on element [" + locators + "] ");
		}
	}

	public void sendKeys(By locator, String text) {
		try {
			waitFor(1);
			WebElement element = driver.findElement(locator);
			drawBorder(driver, element);
			element.sendKeys(text);
			waitFor(1);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to send keys to element [" + locator + "]");
		}
	}

	public void sendKeys(WebElement element, String text) {
		try {
			waitFor(2);
			drawBorder(driver, element);
			element.sendKeys(text);
			waitFor(1);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to send keys to element");
		}
	}

	public void click(By locator) {
		try {
			waitFor(2);
			WebElement element = driver.findElement(locator);
			drawBorder(driver, element);
			element.click();
			waitFor(1);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to click on element [" + locator + "]");
		}
	}

	public void doubleClick(By locator) {
		try {
			waitFor(2);
			WebElement element = driver.findElement(locator);
			drawBorder(driver, element);

			Actions actions = new Actions(driver);
			actions.doubleClick(element).build().perform();

			waitFor(1);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to double click on element [" + locator + "]");
		}
	}

	public void click(WebElement element) {
		try {
			waitFor(2);
			drawBorder(driver, element);
			element.click();
			waitFor(1);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to click on element");
		}
	}

	public static void drawBorder(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void scrollIntoView(WebDriver driver, By locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollIntoView(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Failed to scroll to element.");
		}
	}

	public void switchToChildWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);

				// closing child window
				driver.switchTo().window(parentWindow); // cntrl to parent window
				driver.close();
				driver.switchTo().window(windowHandle);
				System.out.println("closing Parent window and control on the new open window");
			}
		}
	}

	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -1750)");
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
	}

	

	private boolean isElementAtTop(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long elementPosition = (Long) js.executeScript("return arguments[0].getBoundingClientRect().top", element);
		return elementPosition >= 0;
	}

	public void scrollUpto(By elementLocator) {
		try {
			WebElement element = driver.findElement(elementLocator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail("Element not found: " + elementLocator);
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail("Failed to scroll to element: " + elementLocator);
		}
	}

	public boolean isElementPresent(By by) {
	    try {
	        // Check if the element is present in the DOM
	        driver.findElement(by);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	


	
	protected void scrollClick(By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", element);
		waitFor(1);
		js.executeScript("arguments[0].click();", element);
	}

	protected WebElement waitForElementClickable(WebElement webElement, int timeoutSeconds) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
					.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			System.err.println(
					"Waited for element [" + webElement + "] to be clickable for " + timeoutSeconds + " seconds");
		}
		return webElement;
	}

	public void waitForOverlayToDisappear(By overlayElement, int timeoutSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayElement));
		} catch (Exception e) {
			System.err.println("Overlay did not disappear within " + timeoutSeconds + " seconds.");
		}
	}

	public void log(String message) {
		Date timestamp = new Date();
		String formattedMessage = "[" + timestamp + "] " + message;
		System.out.println(formattedMessage);
	}

	public static String generateRandomText(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static String generateRandomMobileNumber() {
		return "987" + RandomStringUtils.randomNumeric(4) + "000";
	}

	public static String generateRandomTestMobileNumber() {
		return "1" + RandomStringUtils.randomNumeric(9);
	}

	public static String generateRandomAmount() {
		return RandomStringUtils.randomNumeric(5);
	}

	public static String generateRandomDigit() {
		return RandomStringUtils.randomNumeric(1);
	}

	public static String generateRandomDigits(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public static String generateRandomAlphabets(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static String generateRandomName() {
		return RandomStringUtils.randomAlphanumeric(5);
	}

	public static String generateRandomNameForSSN() {
		return RandomStringUtils.randomAlphabetic(5);
	}

	public static String generateRandomNameForPayRent() {
		return RandomStringUtils.randomAlphanumeric(5).concat("_Test _Automation");
	}

	public static String generateRandomEmail() {
		return RandomStringUtils.randomNumeric(4) + "@gmail.com";
	}

    

      public void openNewWindowsTab(String url) {

          ((JavascriptExecutor) driver).executeScript("window.open()");
          ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
          System.out.println("After Opening " + tabs.size());
          driver.switchTo().window(tabs.get(1));
          driver.get(url);
      }

      public String getFutureDate(int days, String format) {
          Date date = DateUtils.addDays(new Date(), days);
          SimpleDateFormat sdf = new SimpleDateFormat(format);
          return sdf.format(date);
      }


  }




