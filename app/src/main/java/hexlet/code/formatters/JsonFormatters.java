package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class JsonFormatters {
    private static String complexValue(Object value) {
        if (value.equals("null")) {
            return "null";
        }
        if (value instanceof Map) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "\"" + value + "\"";
        }
        return value.toString();
    }

    public static String getAnswer(List<String> unionListKey, Map<String, Object> data1, Map<String, Object> data2) {
        var result = new StringBuilder("{");
        for (var key : unionListKey) {
            if (data1.getOrDefault(key, null) != null) {
                if (data2.getOrDefault(key, null) != null) {
                    if (!data1.get(key).equals(data2.get(key))) {
                        result.append(System.lineSeparator());
                        result.append("    \"");
                        result.append(key);
                        result.append("\": [ ");
                        result.append(complexValue(data1.get(key)));
                        result.append(", ");
                        result.append(complexValue(data2.get(key)));
                        result.append(" ],");
                    }
                } else {
                    result.append(System.lineSeparator());
                    result.append("    \"");
                    result.append(key);
                    result.append("\": ");
                    result.append("[ ");
                    result.append(complexValue(data1.get(key)));
                    result.append(", \"not_value\" ],");
                }
            } else if (data2.getOrDefault(key, null) != null) {
                result.append(System.lineSeparator());
                result.append("    \"");
                result.append(key);
                result.append("\": ");
                result.append("[ \"not_value\", ");
                result.append(complexValue(data2.get(key)));
                result.append(" ],");
            } else {
                result.append(System.lineSeparator());
            }
        }
        var resultEnd = result.toString();
        return resultEnd.substring(0, resultEnd.length() - 1) + "\n}";
    }
}
