package hexlet.code.formatters;

import hexlet.code.SaveDiffer;

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

    public static String getAnswer(SaveDiffer data) {
        var result = new StringBuilder("{");
        for (var key : data.getSortUnionKey()) {
            var currentValue = data.getChangesValue().get(key);
            if (currentValue[0].equals("=")) {
                continue;
            } else if (currentValue[0].equals("+")) {
                result.append(System.lineSeparator());
                result.append("    \"");
                result.append(key);
                result.append("\": ");
                result.append("[ \"not_value\", ");
                result.append(complexValue(currentValue[1]));
                result.append(" ],");
            } else if (currentValue[0].equals("-")) {
                result.append(System.lineSeparator());
                result.append("    \"");
                result.append(key);
                result.append("\": ");
                result.append("[ ");
                result.append(complexValue(currentValue[1]));
                result.append(", \"not_value\" ],");
            } else {
                result.append(System.lineSeparator());
                result.append("    \"");
                result.append(key);
                result.append("\": [ ");
                result.append(complexValue(currentValue[0]));
                result.append(", ");
                result.append(complexValue(currentValue[1]));
                result.append(" ],");
            }
        }
        var resultEnd = result.toString();
        return resultEnd.substring(0, resultEnd.length() - 1) + "\n}";
    }
}
