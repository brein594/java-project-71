package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonFormatters {
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

    public static String getAnswer(LinkedHashMap<String, Object[]> data) {
        var result = new StringBuilder("{");
        //for (var key : data.getSortUnionKey()) {
        var keys = data.keySet();
        for (var key : keys) {
            var currentValue = data.get(key);
            if (currentValue[0].equals("=")) {
                continue;
            } else if (currentValue[0].equals("+")) {
                result.append(String.format("\n    \"%s\": [ \"not_value\", %s ],", key,
                        complexValue(currentValue[1])));
            } else if (currentValue[0].equals("-")) {
                result.append(String.format("\n    \"%s\": [ %s, \"not_value\" ],", key,
                        complexValue(currentValue[1])));
            } else {
                result.append(String.format("\n    \"%s\": [ %s, %s ],", key, complexValue(currentValue[0]),
                        complexValue(currentValue[1])));
            }
        }
        var resultEnd = result.toString();
        return resultEnd.substring(0, resultEnd.length() - 1) + "\n}";
    }
}
