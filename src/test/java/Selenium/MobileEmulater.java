/*
package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;


   import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class MobileEmulater {
        public static void main(String[] args) {
            // Setup WebDriverManager for Chrome
            WebDriverManager.chromedriver().setup();

            // Create ChromeOptions for mobile emulation
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=375,812"); // Set the desired viewport size (iPhone X)

            // Start ChromeDriver with ChromeOptions
            ChromeDriver driver = new ChromeDriver(options);

           DevTools devTools = driver.getDevTools();
            devTools.createSession();

         //   Enable mobile emulation
            devTools.send("Emulation.setDeviceMetricsOverride",
            "{\"width\":375,\"height\":812,\"deviceScaleFactor\":3.0,\"mobile\":true}");

            // Navigate to a website
            driver.get("https://example.com");

        }
    }

*/
