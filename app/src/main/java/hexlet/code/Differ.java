package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FilenameUtils;

public class Differ {

    private static Path readPathFile(String filepath) {
        return Paths.get(filepath).toAbsolutePath().normalize();
    }

    public static String readFile(Path filepath) throws Exception {
        return Files.readString(filepath).trim();
    }

    public static String getTypeFile(Path path) {
        return FilenameUtils.getExtension(String.valueOf(path));
    }

    private static ArrayList<String> listSortUnion(Map<String, Object> data1, Map<String, Object> data2) {
        var dataKeys1 = new ArrayList<>(data1.keySet());
        var dataKeys2 = new ArrayList<>(data2.keySet());
        var unionSortKeys = new ArrayList<>(CollectionUtils.union(dataKeys1, dataKeys2));
        Collections.sort(unionSortKeys);
        return unionSortKeys;
    }

    private static HashMap<String, Object> getData(String filePath) throws Exception {
        var textFile = readFile(readPathFile(filePath));
        var typeFile = getTypeFile(readPathFile(filePath));
        return Parser.getData(textFile, typeFile);
    }

    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        var dataFile1 = getData(filePath1);
        var dataFile2 = getData(filePath2);
        var listUnion = listSortUnion(dataFile1, dataFile2);
        var resultDiffer = SaveDiffer.buildChangesValue(listUnion, dataFile1, dataFile2); //создаем данные
        return Formatter.format(resultDiffer, formatName);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
