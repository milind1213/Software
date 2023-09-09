package TestCases;

import ServicePages.PeopleGroverPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssignment1 extends BaseTest {
    String email = "p14@g.com";
    String password = "Automation@123";

    @Test
    public void assignment_1() {
        String nameDate = "Milind G 09 Sep 2023";
        String totalExp = "Total Year Of Experience-5";
        String expectedResponse = "You'll get an email when Bill responds.";
        String expectedJobHelpMessage = "You reached out to Bill for help with a job!";
        // ==============================================================================
        PeopleGroverPage applicant = new PeopleGroverPage(driver);
        log.debug("Landing on Home Page and clicking on login");

        log.debug("Entering valid EmailId[ " + email + " And Password " + password + "] ");
        applicant.login(email, password);
        log.debug("Successfully logged in with [ " + email + " And Password " + password + "] ");

        log.debug("Selecting Carrier options from Dropdowns");
        applicant.selectJobs("Jobs");
        log.debug("selected 'Jobs' Options from Carrier dropdowns");
        applicant.JobInquiryAndSendMessage(nameDate, totalExp);

        String actualToastMessage = applicant.validatingToastMessage();
        log.debug("Validating [" + actualToastMessage + "] Message ");
        Assert.assertEquals(actualToastMessage, "Message sent.");

        String actualMessageResponse = applicant.sentMessageResponse();
        log.debug("Validating Sent [" + expectedResponse + "] Response");
        Assert.assertEquals(actualMessageResponse, expectedResponse);
        waitFor(2);
        log.debug("Clicking on 'Keep the Convo Going!' Button");
        applicant.click_keepConvoGoingBtn();

        String inboxJobHelpMessage = applicant.validatingInboxJobHelpMessage();
        log.debug("Validating in inbox [" + expectedJobHelpMessage + "] Message");
        Assert.assertEquals(inboxJobHelpMessage, expectedJobHelpMessage);

        String inboxText = applicant.inboxTextMessage();
        log.debug("Validating sent [" + nameDate + " " + totalExp + "] ");
        Assert.assertEquals(inboxText, nameDate, totalExp);

        log.debug(" Printing the Others Similar User Details");
        applicant.profileDetails();
    }

}
