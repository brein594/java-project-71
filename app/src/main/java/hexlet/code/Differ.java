package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.MyValue;

public class Differ {

    public static Path readFixture(String filepath) throws Exception {
        return Paths.get(filepath);
    }

    public static String readFile(Path filepath) throws Exception {
        return Files.readString(filepath).trim();
    }

    public static HashMap<String,Object> getData(String content) throws Exception {
        //var result = new HashMap<K, V>();
        ObjectMapper mapper = new ObjectMapper();
        var result = mapper.readValue(content,  new TypeReference<HashMap<String,Object>>(){});
        return result;
    }

    public static String generate(String filePath1, String filePath2) {
        String diff ="";
        return diff;
    }
}
