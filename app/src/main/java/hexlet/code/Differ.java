package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FilenameUtils;

public class Differ {

    public static Path readPathFile(String filepath) {
        return Paths.get(filepath).toAbsolutePath().normalize();
    }

    public static String readFile(Path filepath) throws Exception {
        return Files.readString(filepath).trim();
    }

    public static String getType(Path path) {
        return FilenameUtils.getExtension(String.valueOf(path));
    }

    private static List<String> listSortUnion(Map<String, Object> data1, Map<String, Object> data2) {
        var listKeys1 = new ArrayList<>(data1.keySet());
        var listKeys2 = new ArrayList<>(data2.keySet());
        var listKeys3 = new ArrayList<>(CollectionUtils.union(listKeys1, listKeys2));
        Collections.sort(listKeys3);
        return listKeys3;
    }


    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        var textFile1 = readFile(readPathFile(filePath1));
        var textFile2 = readFile(readPathFile(filePath2));
        var typeFile1 = getType(readPathFile(filePath1));
        var typeFile2 = getType(readPathFile(filePath2));
        var dataFile1 = Parser.getData(textFile1, typeFile1);
        var dataFile2 = Parser.getData(textFile2, typeFile2);
        var listUnion = listSortUnion(dataFile1, dataFile2);
        return Formatter.getResult(listUnion, dataFile1, dataFile2, formatName);
    }

/*
    public static String generateYml(String filePath1, String filePath2) throws Exception {
        var textFile1 = readFile(readPathFile(filePath1));
        var textFile2 = readFile(readPathFile(filePath2));
        var dataFile1 = Parser.getDataYml(textFile1);
        var dataFile2 = Parser.getDataYml(textFile2);
        var listUnion = listSortUnion(dataFile1, dataFile2);
        return WriteResult.getResult(listUnion, dataFile1, dataFile2);
    }

 */

}
