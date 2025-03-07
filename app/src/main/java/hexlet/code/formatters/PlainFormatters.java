package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlainFormatters {

    private static String complexValue(Object value) {
        if (value.equals("null")) {
            return "null";
        }
        if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }

    public static String getAnswer(LinkedHashMap<String, Object[]> data) {
        var result = new StringBuilder();
        //for (var key : data.getSortUnionKey()) {
        var keys = data.keySet();
        for (var key : keys) {
            var currentValue = data.get(key);
            if (currentValue[0].equals("=")) {
                continue;
            } else if (currentValue[0].equals("+")) {
                if (result.length() != 0) {
                    result.append(System.lineSeparator());
                }
                result.append(String.format("Property '%s' was added with value: %s", key,
                        complexValue(currentValue[1])));
            } else if (currentValue[0].equals("-")) {
                if (result.length() != 0) {
                    result.append(System.lineSeparator());
                }
                result.append(String.format("Property '%s' was removed", key));
            } else {
                if (result.length() != 0) {
                    result.append(System.lineSeparator());
                }
                result.append(String.format("Property '%s' was updated. From %s to %s", key,
                        complexValue(currentValue[0]), complexValue(currentValue[1])));
            }
        }
        return result.toString();
    }

}
