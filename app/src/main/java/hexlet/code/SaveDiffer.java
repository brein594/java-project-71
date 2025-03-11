package hexlet.code;

import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Collections;

@Getter
public class SaveDiffer {

    private static ArrayList<String> listSortUnion(Map<String, Object> data1, Map<String, Object> data2) {
        var dataKeys1 = new ArrayList<>(data1.keySet());
        var dataKeys2 = new ArrayList<>(data2.keySet());
        var unionSortKeys = new ArrayList<>(CollectionUtils.union(dataKeys1, dataKeys2));
        Collections.sort(unionSortKeys);
        return unionSortKeys;
    }

    public static LinkedHashMap<String, Object[]> buildChangesValue(HashMap<String, Object> data1,
                                                                    HashMap<String, Object> data2) {
        var result = new LinkedHashMap<String, Object[]>();
        var list = listSortUnion(data1, data2);
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
