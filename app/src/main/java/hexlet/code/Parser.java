package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.HashMap;


public class Parser {

    private static HashMap<String, Object> replacementNullToStringNull(HashMap<String, Object> map) {
        var keys = map.keySet();
        for (var key : keys) {
            if (map.get(key) == null) {
                map.put(key, "null");
            }
        }
        return map;
    }

    public static HashMap<String, Object> getData(String content, String type) throws Exception {
        switch (type) {
            case "json":
                ObjectMapper mapperJson = new ObjectMapper();
                var resultJson = mapperJson.readValue(content, new TypeReference<HashMap<String, Object>>() {
                });
                return  replacementNullToStringNull(resultJson);
            case "yml":
                ObjectMapper mapperYml = new YAMLMapper();
                var resultYml = mapperYml.readValue(content, new TypeReference<HashMap<String, Object>>() {
                });
                return replacementNullToStringNull(resultYml);
            default:
                ObjectMapper mapperDef = new ObjectMapper();
                var resultYDef = mapperDef.readValue(content, new TypeReference<HashMap<String, Object>>() {
                });
                return replacementNullToStringNull(resultYDef);
        }
    }

}
