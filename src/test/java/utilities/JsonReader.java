package utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import java.io.FileReader;

public class JsonReader {

    //This method is used to read the data from JSON file

    public static String getValueByJPath(String jsonPath, String jPath) {
        Object obj=null;
        try {
            obj=new JSONParser().parse(new FileReader(jsonPath));
            for (String s:jPath.split("/")) {
                if(!s.isEmpty()){
                    if(!(s.contains("[")||s.contains("]")))
                            obj= ((JSONObject)obj).get(s);
                    else if(s.contains("[")||s.contains("]"))
            obj= ((JSONArray)((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]","")));

                }
            }
        }catch (Exception e) {
            Assert.fail("*****Error reading data from JSON file***** : "+e.toString());
        }
        return obj.toString();
    }


}
