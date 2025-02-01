package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;

public class Differ {

    public static Path readFixture(String filepath) {
        return Paths.get(filepath).toAbsolutePath().normalize();
    }

    public static String readFile(Path filepath) throws Exception {
        return Files.readString(filepath).trim();
    }

    public static <T> HashMap<String, Object> getData(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        var result = mapper.readValue(content,  new TypeReference<HashMap<String, Object>>(){});
        return result;
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        var textFile1 = readFile(readFixture(filePath1));
        var textFile2 = readFile(readFixture(filePath2));
        var DataFile1 = getData(textFile1);
        var DataFile2 = getData(textFile2);
        var listKeys1 = new ArrayList<>(DataFile1.keySet());
        var listKeys2 = new ArrayList<>(DataFile2.keySet());
        var listKeys3 = new ArrayList<>(CollectionUtils.union(listKeys1, listKeys2));
        Collections.sort(listKeys3);
        /*
        LinkedHashMap<String, Object> sortDataFile1 = DataFile1.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
         */
        var result = new StringBuilder();
        for (var key : listKeys3) {
            if (DataFile1.getOrDefault(key, null) != null) {
                if (DataFile2.getOrDefault(key, null) != null) {
                    if(DataFile1.get(key).equals(DataFile2.get(key))) {
                        result.append("  ");
                        result.append(key);
                        result.append(": ");
                        result.append(DataFile1.get(key));
                        result.append(System.lineSeparator());
                    } else {
                        result.append("- ");
                        result.append(key);
                        result.append(": ");
                        result.append(DataFile1.get(key));
                        result.append(System.lineSeparator());
                        result.append("+ ");
                        result.append(key);
                        result.append(": ");
                        result.append(DataFile2.get(key));
                        result.append(System.lineSeparator());
                    }
                } else {
                    result.append("- ");
                    result.append(key);
                    result.append(": ");
                    result.append(DataFile1.get(key));
                    result.append(System.lineSeparator());
                }
            } else if (DataFile2.getOrDefault(key, null) != null) {
                result.append("+ ");
                result.append(key);
                result.append(": ");
                result.append(DataFile2.get(key));
                result.append(System.lineSeparator());
            } else {
                result.append(System.lineSeparator());
            }
        }
        return result.toString();
    }
}
