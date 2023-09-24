package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static TestComponents.BaseTest.driver;

public class WindowHandles {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=0.8");
        WebDriver driver = new ChromeDriver();
        driver.get("https://star-preprod.homeservice-react.star.nobroker.in/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        String windowId = driver.getWindowHandle();

        driver.findElement(By.id("hsHomeTile")).click();

        driver.findElement(By.id("raHomeTile")).click();

        Set<String> windowsId = driver.getWindowHandles();
        System.out.println(windowsId);

        Iterator<String> it = windowsId.iterator();
         String  parent=it.next();
         String  child=it.next();
         System.out.println(parent +" = "+ child);


        List<String> list = new ArrayList(windowsId);
       /* String  par = list.get(0);
        String  child = list.get(1);
        System.out.println(par + "  " +child);

        driver.switchTo().window(par);
        System.out.println(driver.getTitle());

        driver.switchTo().window(child);
        System.out.println(driver.getTitle());*/


        for (String winid : list) {
            String title = driver.switchTo().window(winid).getTitle();
            System.out.println(title);
            if (title.equals("Rental Agreement by NoBroker")) {
                driver.close();
            }
        }

}

}