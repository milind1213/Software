package Programes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ReadDataFiles {
 public List<HashMap<String, String>> getJsonDataToMap(String property) throws IOException {
     // Read Json TO String
     String contentJson  = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"resources/TestData/loginCredentials.json"));
     // String to Hashmap  -  jackson DataBind
     ObjectMapper mapper = new ObjectMapper();
    List<HashMap<String,String >> data =  mapper.readValue(contentJson,new TypeReference<List<HashMap<String,String>>>() {
            });
    return data;
 }

}
