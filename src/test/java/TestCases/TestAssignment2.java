package TestCases;

import ServicePages.PeopleGroverPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TestAssignment2 extends BaseTest {
    @Test(dataProvider = "getData")
    public void assignment_2(HashMap<String, String> input) throws IOException, InterruptedException{

        PeopleGroverPage applicant = new PeopleGroverPage(driver);
        log.debug("Landing on Home Page and clicking on login");

        log.debug("Entering valid EmailId[ " + input.get("email") + " And Password " + input.get("password") + "] ");
        applicant.login(input.get("email"), input.get("password"));
        log.debug("Successfully logged in with[ " + input.get("email") + " And Password " + input.get("password") + "] ");

        log.debug("Selecting Carrier options from Dropdowns");
        applicant.selectJobs("Career Paths");
        log.debug("Selected [ Career Paths ] options from Dropdowns");

        log.debug("Selecting 3 Job Titles from inspiration Section and storing in List");
        applicant.selectInspirationForYouCareers();
        log.debug("Performed Click and Back Action Using Loops");

        log.debug("Performed Click and Back Action Using Loops");
        List<String> recentlyViewedCareers = applicant.getRecentlyViewedCareers();
        List<String> expectedCareers = List.of("Legal Consultants", "Test Engineer in SDET", "Krittikaa Testing");

        log.debug("Validating [" + expectedCareers + " = " + recentlyViewedCareers + "]  ");
        Assert.assertEquals(expectedCareers, recentlyViewedCareers);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/resources/TestData/loginCredentials.json");
        if (data.size() >= 2) {
            return new Object[][] { { data.get(0) }, { data.get(1) } };
        } else if (data.size() == 1) {
            return new Object[][] { { data.get(0) } };
        } else {
            throw new IllegalArgumentException("Insufficient data in the JSON file.");
        }
    }
}
