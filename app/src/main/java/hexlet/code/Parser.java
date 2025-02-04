package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.HashMap;


public class Parser {

    public static HashMap<String, Object> getData(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        var result = mapper.readValue(content, new TypeReference<HashMap<String, Object>>(){});
        return result;
    }


    public static HashMap<String, Object> getDataYml(String content) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        var result = mapper.readValue(content, new TypeReference<HashMap<String, Object>>(){});
        return result;
    }

}
