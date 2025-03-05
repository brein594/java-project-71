package hexlet.code.formatters;

import java.util.LinkedHashMap;

public class StylishFormatters {

    public static String getAnswer(LinkedHashMap<String, Object[]> data) {
        var result = new StringBuilder("{\n");
        var keys = data.keySet();
        for (var key : keys) {
            var currentValue = data.get(key);
            if (currentValue[0].equals("=")) {
                result.append("    ");
                result.append(key);
                result.append(": ");
                result.append(currentValue[1]);
                result.append(System.lineSeparator());
            } else if (currentValue[0].equals("+")) {
                result.append("  + ");
                result.append(key);
                result.append(": ");
                result.append(currentValue[1]);
                result.append(System.lineSeparator());
            } else if (currentValue[0].equals("-")) {
                result.append("  - ");
                result.append(key);
                result.append(": ");
                result.append(currentValue[1]);
                result.append(System.lineSeparator());
            } else {
                result.append("  - ");
                result.append(key);
                result.append(": ");
                result.append(currentValue[0]);
                result.append(System.lineSeparator());
                result.append("  + ");
                result.append(key);
                result.append(": ");
                result.append(currentValue[1]);
                result.append(System.lineSeparator());
            }
        }
        result.append("}");
        return result.toString();
    }
}
