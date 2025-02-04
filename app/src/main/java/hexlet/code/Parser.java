package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.HashMap;


public class Parser {

    public static HashMap<String, Object> getData(String content, String type) throws Exception {
        switch (type) {
            case "json":
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(content, new TypeReference<HashMap<String, Object>>(){});
            case "yml":
                ObjectMapper mapper1 = new YAMLMapper();
                return mapper1.readValue(content, new TypeReference<HashMap<String, Object>>(){});
            default:
                ObjectMapper mapper3 = new ObjectMapper();
                return mapper3.readValue(content, new TypeReference<HashMap<String, Object>>(){});
        }
    }
/*
    public static HashMap<String, Object> getData(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<HashMap<String, Object>>(){});
    }
*/


/*
    public static HashMap<String, Object> getDataYml(String content) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(content, new TypeReference<HashMap<String, Object>>(){});
    }
*/

}
