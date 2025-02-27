package hexlet.code.formatters;

import hexlet.code.SaveDiffer;

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

    public static String getAnswer(SaveDiffer data) { //исправить
        var result = new StringBuilder();
        for (var key : data.getSortUnionKey()) {
            var currentValue = data.getChangesValue().get(key);
            if (currentValue[0].equals("=")) {
                continue;
            } else if (currentValue[0].equals("+")) {
                if (result.length() != 0) {
                    result.append(System.lineSeparator());
                }
                result.append("Property '");
                result.append(key);
                result.append("' was added with value: ");
                result.append(complexValue(currentValue[1]));
            } else if (currentValue[0].equals("-")) {
                if (result.length() != 0) {
                    result.append(System.lineSeparator());
                }
                result.append("Property '");
                result.append(key);
                result.append("' was removed");
            } else {
                if (result.length() != 0) {
                    result.append(System.lineSeparator());
                }
                result.append("Property '");
                result.append(key);
                result.append("' was updated. From ");
                result.append(complexValue(currentValue[0]));
                result.append(" to ");
                result.append(complexValue(currentValue[1]));
            }
        }
        return result.toString();
    }

}
