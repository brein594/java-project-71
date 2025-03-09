package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import hexlet.code.formatters.JsonFormatter;

import java.util.LinkedHashMap;


public class Formatter {

    public static String format(LinkedHashMap<String, Object[]> data, String formatName)
            throws JsonProcessingException, Exception {
        return switch (formatName.toLowerCase()) {
            case "stylish" -> StylishFormatter.getAnswer(data);
            case "plain" -> PlainFormatter.getAnswer(data);
            case "json" -> JsonFormatter.getAnswer(data);
            default -> throw new Exception("Please enter format json/yaml/yml or no enter format");
        };
    }
}

