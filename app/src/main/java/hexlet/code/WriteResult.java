package hexlet.code;

import java.util.List;
import java.util.Map;

public class WriteResult {
    public static String getResult(List<String> UnionlistKey, Map<String, Object> data1, Map<String, Object> data2) {
        var result = new StringBuilder("{\n");
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
        return result.toString();


    }
}
