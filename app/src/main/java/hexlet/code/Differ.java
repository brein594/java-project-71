package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.HashMap;
import org.apache.commons.io.FilenameUtils;

public class Differ {

    public static Path readPathFile(String filepath) {
        return Paths.get(filepath).toAbsolutePath().normalize();
    }

    public static String readFile(Path filepath) throws Exception {
        return Files.readString(filepath).trim();
    }

    public static String getTypeFile(Path path) {
        return FilenameUtils.getExtension(String.valueOf(path));
    }


    private static HashMap<String, Object> getData(String filePath) throws Exception {
        var textFile = readFile(readPathFile(filePath));
        var typeFile = getTypeFile(readPathFile(filePath));
        return Parser.getData(textFile, typeFile);
    }

    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        var dataFile1 = getData(filePath1);
        var dataFile2 = getData(filePath2);
        var resultDiffer = SaveDiffer.buildChangesValue(dataFile1, dataFile2); //создаем данные
        return Formatter.format(resultDiffer, formatName);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
