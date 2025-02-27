package hexlet.code;

import hexlet.code.formatters.PlainFormatters;
import hexlet.code.formatters.StylishFormatters;
import hexlet.code.formatters.JsonFormatters;


public class Formatter {

    public static String getStilishResponse(SaveDiffer data, String formatName) {  //исправить
        String result;
        if (formatName.equals("plain")) {
            result = PlainFormatters.getAnswer(data);
        } else if (formatName.equals("json")) {
            result = JsonFormatters.getAnswer(data);
        } else {
            result = StylishFormatters.getAnswer(data);
        }
        return result;
    }

}

