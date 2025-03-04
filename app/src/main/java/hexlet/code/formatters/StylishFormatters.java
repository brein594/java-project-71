package hexlet.code.formatters;

import hexlet.code.SaveDiffer;

public class StylishFormatters {

    public static String getAnswer(SaveDiffer data) {
        var result = new StringBuilder("{\n");
        for (var key : data.getSortUnionKey()) {
            var currentValue = data.getChangesValue().get(key);
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
