package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DataDriven {
    @Test(dataProvider = "testdata")
    public void dataTest(String name, int age, String mail) {
        System.out.println(name + " " + age + " " + mail);
    }

    @Parameters({ "URL", "API Keys" }) // Corrected parameter name
    @Test
    public void parameterTest(String url, String key) {
        System.out.println(url + " " + key);
    }

    @Test(dataProvider = "userdata")
    public void dataTests(String user , String pass){
        System.out.println(user + " " + pass);
    }

    @DataProvider(name="userdata")
    public Object provideData(){
        Object [][] data = new Object [3][2];
        data[0][0]="first@g.com";
        data[0][1]="pass";
        data[1][0]="second@g.com";
        data[1][1]="pass";
        data[2][0]="third@g.com";
        data[2][1]="first@g.com";
        return data;
    }

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        return new Object[][] { { "Milind ", 30, "g@g.com" }, { "Ravi", 22, "r@g.com" }, { "Mohit", 23, "m@g.com" } };
    }

    @Test(dataProvider = "abc")
    public void  dts(HashMap<Object,Object>input){
        System.out.println(input.get("Name"));
        System.out.println(input.get("Age"));
        System.out.println(input.get("City"));
        System.out.println(input.get("Grade"));
    }

    @DataProvider(name="abc")
    public Object[][] abc(){
        HashMap<Object,Object> map = new HashMap<>();
        map.put("Name","Milind");
        map.put("Age",23);
        map.put("City","Pune");
        map.put("Grade",'A');

        HashMap<Object, Object> map2 = new HashMap<>();
        map2.put("Name", "John");
        map2.put("Age", 30);
        map2.put("City", "New York");
        map2.put("Grade", 'B');

        HashMap<Object, Object> map3 = new HashMap<>();
        map3.put("Name", "Alice");
        map3.put("Age", 25);
        map3.put("City", "London");
        map3.put("Grade", 'C');

        return new Object [][] {{map},{map2},{map2}};
    }







}
