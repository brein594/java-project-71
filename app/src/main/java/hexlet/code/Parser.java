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
        var result = switch (type) {
            case "stylish", "json" -> {
                ObjectMapper mapperDef = new ObjectMapper();
                yield mapperDef.readValue(content, new TypeReference<HashMap<String, Object>>() {
                });
            }
            case "yml", "yaml" -> {
                ObjectMapper mapperYml = new YAMLMapper();
                yield mapperYml.readValue(content, new TypeReference<HashMap<String, Object>>() {
                });
            }
            default -> throw new Exception("Please enter format json/yaml/yml or no enter format");
        };
        return replacementNullToStringNull(result);
    }

}
