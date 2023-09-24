package TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestAssignment3 {

    @Test(dataProvider = "getData")
    public void m1(String m, String m2, String m3) {
        System.out.println("1 =" + m + " 2" + m2 + " 3" + m3);
    }

    @Test(dataProvider = "getData2")
    public void m2(HashMap<Object, Object> input) {
        System.out.println("  1 =" + input.get("name") + "  2  " + input.get("Location") + "  3  " + input.get("Work"));
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"MILIND", "GHONGADE", "MR"}, {"WADASD", "AFSDFDS", "AFASDF"}};
    }

    @DataProvider
    public Object[][] getData2() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", "Milind");
        map.put("Location", "Bangalore");
        map.put("Work", "IT");
        return new Object[][]{{map}};
    }
}
