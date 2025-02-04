package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Collections;


import org.apache.commons.collections4.CollectionUtils;

public class Differ {

    public static Path readPathFile(String filepath) {
        return Paths.get(filepath).toAbsolutePath().normalize();
    }

    public static String readFile(Path filepath) throws Exception {
        return Files.readString(filepath).trim();
    }


    public static String generate(String filePath1, String filePath2) throws Exception {
        var textFile1 = readFile(readPathFile(filePath1));
        var textFile2 = readFile(readPathFile(filePath2));
        var dataFile1 = Parser.getData(textFile1);
        var dataFile2 = Parser.getData(textFile2);
        var listKeys1 = new ArrayList<>(dataFile1.keySet());
        var listKeys2 = new ArrayList<>(dataFile2.keySet());
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
        var result = new StringBuilder("{\n");
        for (var key : listKeys3) {
            if (dataFile1.getOrDefault(key, null) != null) {
                if (dataFile2.getOrDefault(key, null) != null) {
                    if (dataFile1.get(key).equals(dataFile2.get(key))) {
                        result.append("  ");
                        result.append(key);
                        result.append(": ");
                        result.append(dataFile1.get(key));
                        result.append(System.lineSeparator());
                    } else {
                        result.append("- ");
                        result.append(key);
                        result.append(": ");
                        result.append(dataFile1.get(key));
                        result.append(System.lineSeparator());
                        result.append("+ ");
                        result.append(key);
                        result.append(": ");
                        result.append(dataFile2.get(key));
                        result.append(System.lineSeparator());
                    }
                } else {
                    result.append("- ");
                    result.append(key);
                    result.append(": ");
                    result.append(dataFile1.get(key));
                    result.append(System.lineSeparator());
                }
            } else if (dataFile2.getOrDefault(key, null) != null) {
                result.append("+ ");
                result.append(key);
                result.append(": ");
                result.append(dataFile2.get(key));
                result.append(System.lineSeparator());
            } else {
                result.append(System.lineSeparator());
            }
        }
        result.append("}");
        return result.toString();
    }


    public static String generateYml(String filePath1, String filePath2) throws Exception {
        var textFile1 = readFile(readPathFile(filePath1));
        var textFile2 = readFile(readPathFile(filePath2));
        var dataFile1 = Parser.getDataYml(textFile1);
        var dataFile2 = Parser.getDataYml(textFile2);
        var listKeys1 = new ArrayList<>(dataFile1.keySet());
        var listKeys2 = new ArrayList<>(dataFile2.keySet());
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
        var result = new StringBuilder("{\n");
        for (var key : listKeys3) {
            if (dataFile1.getOrDefault(key, null) != null) {
                if (dataFile2.getOrDefault(key, null) != null) {
                    if (dataFile1.get(key).equals(dataFile2.get(key))) {
                        result.append("  ");
                        result.append(key);
                        result.append(": ");
                        result.append(dataFile1.get(key));
                        result.append(System.lineSeparator());
                    } else {
                        result.append("- ");
                        result.append(key);
                        result.append(": ");
                        result.append(dataFile1.get(key));
                        result.append(System.lineSeparator());
                        result.append("+ ");
                        result.append(key);
                        result.append(": ");
                        result.append(dataFile2.get(key));
                        result.append(System.lineSeparator());
                    }
                } else {
                    result.append("- ");
                    result.append(key);
                    result.append(": ");
                    result.append(dataFile1.get(key));
                    result.append(System.lineSeparator());
                }
            } else if (dataFile2.getOrDefault(key, null) != null) {
                result.append("+ ");
                result.append(key);
                result.append(": ");
                result.append(dataFile2.get(key));
                result.append(System.lineSeparator());
            } else {
                result.append(System.lineSeparator());
            }
        }
        result.append("}");
        return result.toString();
    }

}
