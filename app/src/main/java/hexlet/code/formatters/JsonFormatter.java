package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonFormatter {
    private static String complexValue(Object value) {
        if (value.equals("null")) {
            return "null";
        }
        if (value instanceof Map) {
            return "complex_value";
        }
        if (value instanceof String) {
            return "\"" + value + "\"";
        }
        return value.toString();
    }

    public static String getAnswer(LinkedHashMap<String, Object[]> data)  throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jacksonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        return jacksonData;
    }
}
