package TestNG;

import com.aventstack.extentreports.reporter.FileUtil;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

public class JsonDataDriven {
   @Test
       public Object [] [] getData(){
           return new Object [] [] {{},{}};
       }
    }
