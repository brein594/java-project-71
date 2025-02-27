package hexlet.code.formatters;

import hexlet.code.SaveDiffer;

public class StylishFormatters {
    /*
        public static String getAnswer(List<String> unionListKey, Map<String, Object> data1,
                                        Map<String, Object> data2) {
            var result = new StringBuilder("{\n");
            for (var key : unionListKey) {
                if (data1.getOrDefault(key, null) != null) {
                    if (data2.getOrDefault(key, null) != null) {
                        if (data1.get(key).equals(data2.get(key))) {
                            result.append("    ");
                            result.append(key);
                            result.append(": ");
                            result.append(data1.get(key));
                            result.append(System.lineSeparator());
                        } else {
                            result.append("  - ");
                            result.append(key);
                            result.append(": ");
                            result.append(data1.get(key));
                            result.append(System.lineSeparator());
                            result.append("  + ");
                            result.append(key);
                            result.append(": ");
                            result.append(data2.get(key));
                            result.append(System.lineSeparator());
                        }
                    } else {
                        result.append("  - ");
                        result.append(key);
                        result.append(": ");
                        result.append(data1.get(key));
                        result.append(System.lineSeparator());
                    }
                } else if (data2.getOrDefault(key, null) != null) {
                    result.append("  + ");
                    result.append(key);
                    result.append(": ");
                    result.append(data2.get(key));
                    result.append(System.lineSeparator());
                } else {
                    result.append(System.lineSeparator());
                }
            }
            result.append("}");
            return result.toString();
        }
    */
    public static String getAnswerV1(SaveDiffer data) { //исправить
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
