package TestComponents;
import PageObjects.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

public class BaseTest {
   public static WebDriver driver;
    public LandingPage landingPage;
    static Properties prop = new Properties();
    protected static final Logger log = Logger.getLogger(BaseTest.class);

    @BeforeClass(alwaysRun = true)
    public void initializeDriver() throws IOException {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/ConfigDirectory/log4j.properties");
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/ConfigDirectory/Config.properties");
        prop.load(fis);
        String browserName = System.getProperty("browser") != null ?
                System.getProperty("browser") : prop.getProperty("browser");
        if (browserName.contains("chrome")) {
            log.debug("[ Chrome Browser Launched ]");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (browserName.contains("headless")) {
                options.addArguments("headless");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("autofill.profile_enabled", false);
                prefs.put("profile.default_content_setting_values.notifications", 2);
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.setExperimentalOption("prefs", prefs);
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            } else {
                options.addArguments("--force-device-scale-factor=0.8");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() {
        landingPage = new LandingPage(driver);
        log.debug("[ Navigated to: " + prop.getProperty("url") + "]");
        landingPage.goTo(prop.getProperty("url"));
        return landingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
     log.debug("[ Test Execution Completed ]");
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

    protected void log(String message) {
        Date timestamp = new Date();
        String formattedMessage = "[" + timestamp + "] " + message;
        System.out.println(formattedMessage);
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(filePath), String.valueOf(StandardCharsets.UTF_8));
        ObjectMapper objMapper = new ObjectMapper();
        List<HashMap<String, String>> data = objMapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;
    }

    public static String generateRandomMobileNumber() {

        return "9453" + RandomStringUtils.randomNumeric(4) + "000";
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

    public static String generateRandomDigits(int length)  {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String generateRandomAlphabets(int length)  {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String generateRandomName() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    public static String generateRandomNameForSSN()  {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String generateRandomNameForPayRent()  {
        return RandomStringUtils.randomAlphanumeric(5).concat("_Test _Automation");
    }

    public static String generateRandomEmail()  {
        return RandomStringUtils.randomNumeric(4) + "@gmail.com";
    }

    public static HashMap<String, HashMap<String, Integer>> EXTENT_METHOD_COUNT = new HashMap<>();
    public static String suiteCount = "", proj = "";

    public static String generateRandomText(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
    public void waitFor(int i) {
        try {
            Thread.sleep(1000 * i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public WebElement getRandomValueFromGivenList(List<WebElement> givenList) {
        int l = givenList.size();
        Random rand = new Random(); // Declare and initialize the Random object
        WebElement randomElement = givenList.get(rand.nextInt(l));
        while (randomElement.getText().equalsIgnoreCase("select")) {
            randomElement = givenList.get(rand.nextInt(l));
        }
        return randomElement;
    }

    public int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

}

