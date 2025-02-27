package hexlet.code;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;


@Getter
public class SaveDiffer {
    private ArrayList<String> sortUnionKey;
    private HashMap<String, Object[]> changesValue;

    SaveDiffer(ArrayList<String> sortUnionKey, HashMap<String, Object> data1, HashMap<String, Object> data2) {
        this.sortUnionKey = sortUnionKey;
        this.changesValue = bildChangesValue(data1, data2);
    }

    private HashMap<String, Object[]> bildChangesValue(HashMap<String, Object> data1, HashMap<String, Object> data2) {
        var result = new HashMap<String, Object[]>();
        for (var key : sortUnionKey) {
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
