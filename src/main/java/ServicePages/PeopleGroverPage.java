package ServicePages;

import Utilities.AbstractComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.sun.activation.registries.LogSupport.log;

public class PeopleGroverPage extends AbstractComponent {
    static WebDriver driver;

    public PeopleGroverPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@class,'arge__t0EME')]")
    WebElement signUp;
    @FindBy(id = "email")
    WebElement emailText;
    @FindBy(id = "password")
    WebElement passwordText;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;
    @FindBy(id = "navlist-ele-1")
    WebElement carrier;
    @FindBy(css = ".fr-element.fr-view")
    WebElement messageTexts;
    private By jobTitle = By.xpath("(//*[@class='ant-card-body'])[1]");
    private By askQuestionBtn = By.xpath("//button[contains(text(),'Ask a Question')]");
    private By messageText = By.cssSelector(".fr-element.fr-view");
    private By sendBtn = By.xpath("//span[contains(text(),'Send')]");
    private By keepConvoGoingBtn = By.xpath("//*[text()='Keep the Convo Going!']");
    private By viewProfile = By.xpath("//button[@class='ant-btn btn-link']");

    public void login(String email, String password) {
        signUp.click();
        waitForElementDisplay(emailText, 2);
        sendKeys(emailText, email);
        sendKeys(passwordText, password);
        click(submitBtn);
    }

    public void profileDetails() {
        log("Clicking on View Profile button");
        click(viewProfile);

        log("Clicking on Users Profile photo");
        click(By.xpath("//button[contains(@class,'profile-link')]//img"));
        waitFor(2);

        List<WebElement> otherUsers = driver.findElements(By.xpath("//div[@class='ant-spin-container']//div[2]"));
        for(int i=0;i<otherUsers.size();i++){
            String nameDesignation = otherUsers.get(i).getText();
            System.out.println(" Name and Designation :"+ nameDesignation);
        }
    }

    public void selectJobs(String jobs) {
        waitForElementDisplay(carrier, 2);
        carrier.click();
        List<WebElement> carrierList = driver.findElements(By.xpath("//ul[@class='productsList']//p[1]"));
        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                for (WebElement el : carrierList) {
                    if (el.getText().contains(jobs)) {
                        el.click();
                        return;
                    }
                }
            } catch (StaleElementReferenceException e) {
                carrierList = driver.findElements(By.xpath("//ul[@class='productsList']//p[1]"));
            }
        }
    }

    public void JobInquiryAndSendMessage(String nameDate, String totalExp) {
        log("Clicking on Job Title");
        click(jobTitle);
        waitForElementDisplay(askQuestionBtn, 2);

        log("Clicking on Ask Question Button");
        scrollDoubleClick(askQuestionBtn);
        waitFor(2);

        log("Waiting for Message Text Element to Display");
        waitForElementDisplay(messageText, 2);

        log("Scrolling and Clicking on TextBox");
        scrollToElementAndClick(messageTexts);

        log("Entering the Text '" + nameDate + " " + totalExp + " into the TextBox");
        sendKeys(messageText, nameDate);

        log("Performing Enter Action ");
        messageTexts.sendKeys(Keys.ENTER);

        sendKeys(messageText, totalExp);
        log("Clicking on Send Button");
        click(sendBtn);
    }

    public void click_keepConvoGoingBtn() {
        try {
            waitForElementDisplay(keepConvoGoingBtn, 2);
            scrollClick(keepConvoGoingBtn);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    public String sentMessageResponse() {
        try {
            WebElement textRes = driver.findElement(By.cssSelector(".messageSentDisplay__buI4n"));
            return textRes.getText();
        } catch (NoSuchElementException e) {
            return "Element not found";
        }
    }

    public String validatingToastMessage() {
        try {
            WebElement toastMsg = driver.findElement(By.cssSelector(".ant-notification-notice-content"));
            waitForElementDisplay(toastMsg, 3);
            return toastMsg.getText();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return "Element not found";
        }
    }

    public String validatingInboxJobHelpMessage() {
        try {
            WebElement inboxJobHelpMessage = driver.findElement(By.cssSelector(".info-title"));
            return inboxJobHelpMessage.getText();
        } catch (NoSuchElementException e) {
            return "Element not found";
        }
    }

    public String inboxTextMessage() {
        WebElement inboxText = driver.findElement(By.cssSelector("div.rich-text.ql-editor p"));
        return inboxText.getText();
    }


    public void selectInspirationForYouCareers() {
        By backNavigation = By.xpath("//span[text()='Career Paths']");

        List<String> selectedCareers = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            try {
                String careerPathXPath = "//h2[contains(text(),'Inspiration for you')]//following::div[@class='career-card__title'] [" + i + "]";
                WebElement careerPath = driver.findElement(By.xpath(careerPathXPath));
                String careerName = careerPath.getText();
                System.out.println("Selected Career: " + careerName);
                selectedCareers.add(careerName);
                careerPath.click();
                click(backNavigation);
            } catch (NoSuchElementException e) {
                System.err.println("NoSuchElementException: The career path element was not found.");
            }
        }
        driver.navigate().refresh();
    }

    public List<String> getRecentlyViewedCareers() {
        List<WebElement> recentViewCarrirList = driver.findElements(By.xpath("//div[@class='Carousel-module_slider__XQtIN']//div[@class='career-card__title']"));
        List<String> recentlyViewedCareers = new ArrayList<>();
        for (int i = 0; i < Math.min(recentViewCarrirList.size(), 3); i++) {
            try {
                WebElement element = recentViewCarrirList.get(i);
                String careerTitle = element.getText();
                recentlyViewedCareers.add(careerTitle);
                System.out.println("Recent Viewed Career: " + careerTitle);
            } catch (NoSuchElementException e) {
                System.err.println("NoSuchElementException: The career path element was not found.");
            }
        }
        return recentlyViewedCareers;
    }

}

