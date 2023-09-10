package TestCases;

import ServicePages.PeopleGroverPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestAssignment2 extends BaseTest {
    String email = "a1@g.com";
    String password = "Automation@123";

    @Test
    public void assignment_2() {

        PeopleGroverPage applicant = new PeopleGroverPage(driver);
        log.debug("Landing on Home Page and clicking on login");

        log.debug("Entering valid EmailId[ " + email + " And Password " + password + "] ");
        applicant.login(email, password);
        log.debug("Successfully logged in with [ " + email + " And Password " + password + "] ");

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

}
