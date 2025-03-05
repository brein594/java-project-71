package hexlet.code;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


@Getter
public class SaveDiffer {
    /*
    private ArrayList<String> sortUnionKey;
    private HashMap<String, Object[]> changesValue;

    SaveDiffer(ArrayList<String> sortUnionKey, HashMap<String, Object> data1, HashMap<String, Object> data2) {
        this.sortUnionKey = sortUnionKey;
        this.changesValue = buildChangesValue(data1, data2);
    */
    public static LinkedHashMap<String, Object[]> buildChangesValue(ArrayList<String> list,
                                                                    HashMap<String, Object> data1,
                                                                    HashMap<String, Object> data2) {
        var result = new LinkedHashMap<String, Object[]>();
        for (var key : list) {
            Object[] currentValue = new Object[2];
            if (data1.getOrDefault(key, null) != null) {
                if (data2.getOrDefault(key, null) != null) {
                    if (data1.get(key).equals(data2.get(key))) {
                        currentValue[0] = "=";
                        currentValue[1] = data1.get(key);
                    } else {
                        currentValue[0] = data1.get(key);
                        currentValue[1] = data2.get(key);
                    }
                } else {
                    currentValue[0] = "-";
                    currentValue[1] = data1.get(key);
                }
            } else {
                currentValue[0] = "+";
                currentValue[1] = data2.get(key);
            }
            result.put(key, currentValue);
        }
        return result;
    }
}
