package TestCases;

import ServicePages.PeopleGroverPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TestAssignment1 extends BaseTest {
    String nameDate = "Milind G 09 Sep 2023";
    String totalExp = "Total Year Of Experience-5";
    String expectedResponse = "You'll get an email when Bill responds.";
    String expectedJobHelpMessage = "You reached out to Bill for help with a job!";

    @Test(dataProvider = "getData")
    public void assignment_1(HashMap<String, String> input) throws IOException, InterruptedException{

        PeopleGroverPage applicant = new PeopleGroverPage(driver);
        log.debug("Landing on Home Page and clicking on login");

        log.debug("Entering valid EmailId[ " + input.get("email") + " And Password " + input.get("password") + "] ");
        applicant.login(input.get("email"), input.get("password"));
        log.debug("Successfully logged in with[ " + input.get("email") + " And Password " + input.get("password") + "] ");

        log.debug("Selecting Carrier options from Dropdowns");
        applicant.selectJobs("Jobs");
      
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
