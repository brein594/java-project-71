package hexlet.code;

import hexlet.code.formatters.PlainFormatters;
import hexlet.code.formatters.StylishFormatters;
import hexlet.code.formatters.JsonFormatters;

import java.util.LinkedHashMap;


public class Formatter {

    public static String format(LinkedHashMap<String, Object[]> data, String formatName) {
        String result;
        switch (formatName.toLowerCase()) {
            case "plain":
                result = PlainFormatters.getAnswer(data);
                break;
            case "json":
                result = JsonFormatters.getAnswer(data);
                break;
            default:
                result = StylishFormatters.getAnswer(data);
        }
        return result;
    }
}

