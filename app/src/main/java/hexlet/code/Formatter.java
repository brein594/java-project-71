package hexlet.code;

import hexlet.code.formatters.PlainFormatters;
import hexlet.code.formatters.StylishFormatters;
import hexlet.code.formatters.JsonFormatters;


public class Formatter {
/*
    public static String getStilishResponse(List<String> unionListKey, Map<String, Object> data1,
                                            Map<String, Object> data2, String formatName) {
        String result;
        if (formatName.equals("plain")) {
            result = PlainFormatters.getAnswer(unionListKey, data1, data2);
        } else if (formatName.equals("json")) {
            result = JsonFormatters.getAnswer(unionListKey, data1, data2);
        } else {
            result = StylishFormatters.getAnswer(unionListKey, data1, data2);
        }
        return result;
    }
*/
    public static String getStilishResponse1(SaveDiffer data, String formatName) {  //исправить
        String result;
        if (formatName.equals("plain")) {
            result = PlainFormatters.getAnswerV1(data);
        } else if (formatName.equals("json")) {
            result = JsonFormatters.getAnswerV1(data);
        } else {
            result = StylishFormatters.getAnswerV1(data);
        }
        return result;
    }

}

