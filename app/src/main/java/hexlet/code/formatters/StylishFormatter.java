package hexlet.code.formatters;

import java.util.LinkedHashMap;

public class StylishFormatter {

    public static String getAnswer(LinkedHashMap<String, Object[]> data) {
        var result = new StringBuilder("{\n");
        var keys = data.keySet();
        for (var key : keys) {
            var currentValue = data.get(key);
            if (currentValue[0].equals("=")) {
                result.append(String.format("    %s: %s\n", key, currentValue[1]));
            } else if (currentValue[0].equals("+")) {
                result.append(String.format("  + %s: %s\n", key, currentValue[1]));
            } else if (currentValue[0].equals("-")) {
                result.append(String.format("  - %s: %s\n", key, currentValue[1]));
            } else {
                result.append(String.format("  - %s: %s\n  + %s: %s\n", key, currentValue[0], key, currentValue[1]));
            }
        }
        result.append("}");
        return result.toString();
    }
}

