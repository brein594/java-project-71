package hexlet.code;

import hexlet.code.formatters.PlainFormatters;
import hexlet.code.formatters.StylishFormatters;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String getStilishResponse(List<String> unionListKey, Map<String, Object> data1,
                                            Map<String, Object> data2, String formatName) {
        String result;
        if (formatName.equals("plain")) {
            result = PlainFormatters.getAnswer(unionListKey, data1, data2);
        } else {
            result = StylishFormatters.getAnswer(unionListKey, data1, data2);
        }
        return result;

    }
}

