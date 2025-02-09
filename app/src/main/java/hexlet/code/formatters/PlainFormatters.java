package hexlet.code.formatters;

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

    public static String getAnswer(List<String> unionListKey, Map<String, Object> data1, Map<String, Object> data2) {
        var result = new StringBuilder();
        for (var key : unionListKey) {
            if (data1.getOrDefault(key, null) != null) {
                if (data2.getOrDefault(key, null) != null) {
                    if (!data1.get(key).equals(data2.get(key))) {
                        if (result.length() != 0 ) {result.append(System.lineSeparator());}
                        result.append("Property '");
                        result.append(key);
                        result.append("' was updated. From ");
                        result.append(complexValue(data1.get(key)));
                        result.append(" to ");
                        result.append(complexValue(data2.get(key)));
                        //result.append(System.lineSeparator());
                    } else {
                        continue;
                    }
                } else {
                    if (result.length() != 0 ) {result.append(System.lineSeparator());}
                    result.append("Property '");
                    result.append(key);
                    result.append("' was removed");
                    //result.append(System.lineSeparator());
                }
            } else {
                if (data2.getOrDefault(key, null) != null) {
                    if (result.length() != 0 ) {result.append(System.lineSeparator());}
                    result.append("Property '");
                    result.append(key);
                    result.append("' was added with value: ");
                    result.append(complexValue(data2.get(key)));
                    //result.append(System.lineSeparator());
                } else {
                    continue;
                }
            }//else {
            //  result.append(System.lineSeparator());
            // }
            //result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
