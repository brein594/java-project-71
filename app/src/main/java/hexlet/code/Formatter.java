package hexlet.code;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String getResult(List<String> UnionlistKey, Map<String, Object> data1, Map<String, Object> data2, String formatName) {
        var result = new StringBuilder();
        if (formatName.equals("stylish")) {
            result.append("{\n");
            for (var key : UnionlistKey) {
                if (data1.getOrDefault(key, null) != null) {
                    if (data2.getOrDefault(key, null) != null) {
                        if (data1.get(key).equals(data2.get(key))) {
                            result.append("  ");
                            result.append(key);
                            result.append(": ");
                            result.append(data1.get(key));
                            result.append(System.lineSeparator());
                        } else {
                            result.append("- ");
                            result.append(key);
                            result.append(": ");
                            result.append(data1.get(key));
                            result.append(System.lineSeparator());
                            result.append("+ ");
                            result.append(key);
                            result.append(": ");
                            result.append(data2.get(key));
                            result.append(System.lineSeparator());
                        }
                    } else {
                        result.append("- ");
                        result.append(key);
                        result.append(": ");
                        result.append(data1.get(key));
                        result.append(System.lineSeparator());
                    }
                } else if (data2.getOrDefault(key, null) != null) {
                    result.append("+ ");
                    result.append(key);
                    result.append(": ");
                    result.append(data2.get(key));
                    result.append(System.lineSeparator());
                } else {
                    result.append(System.lineSeparator());
                }
            }
            result.append("}");
        }
        //return result.toString();

        if (formatName.equals("plain")) {
            for (var key : UnionlistKey) {
                if (data1.getOrDefault(key, null) != null) {
                    if (data2.getOrDefault(key, null) != null) {
                        if (!data1.get(key).equals(data2.get(key))) {
                            result.append("Property '");
                            result.append(key);
                            result.append("' was updated. From ");
                            result.append(data1.get(key));
                            result.append(" to ");
                            result.append(data2.get(key));
                            result.append(System.lineSeparator());
                        }
                    } else {
                        result.append("Property '");
                        result.append(key);
                        result.append("' was removed");
                        result.append(System.lineSeparator());
                    }
                } else if (data2.getOrDefault(key, null) != null) {
                    result.append("Property ");
                    result.append(key);
                    result.append("' was added with value: '");
                    result.append(data2.get(key));
                    result.append("'");
                    result.append(System.lineSeparator());
                } else {
                    result.append(System.lineSeparator());
                }
            }

        }
        return result.toString();
    }
}
