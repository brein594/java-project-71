package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.nio.file.Paths;

class AppTest {
    @ParameterizedTest
    @ValueSource(strings = {"stylish", "json", "yml", "yaml"})
    public void getDataTest(String nameFormat) throws Exception {
        var expected = new HashMap<String, Object>(Map.of("host", "hexlet.io", "timeout", "50"));
        var string = "{ \"host\" : \"hexlet.io\", \"timeout\" : \"50\" }";
        var actual = Parser.getData(string, nameFormat);
        assertEquals(expected, actual);
    }

    @Test
    public void getDataDefaultTest() {
        var expected = "Please enter format json/yaml/yml or no enter format";
        var string = "{ \"host\" : \"hexlet.io\", \"timeout\" : \"50\" }";
        Exception exception = assertThrows(Exception.class, () -> {
            Parser.getData(string, "def");
        });
        var actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void readFileTest() throws Exception {
        String expected = "test";
        var path = Paths.get("./src/test/resources/file3.json");
        String actual = Differ.readFile(path);
        assertEquals(expected, actual);
    }


    public void generateStylishVoidTest() throws Exception {
        String expected = Differ.readFile(Differ.readPathFile("./src/test/resources/file1_stylish"));
        var path1 = "./src/test/resources/file1.json";
        var path2 = "./src/test/resources/file2.json";
        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "stylish, ./src/test/resources/file1_stylish",
        "plain, ./src/test/resources/file1_plain"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void generateTest1(String style, String filePath) throws Exception {
        String expected = Differ.readFile(Differ.readPathFile(filePath));
        var path1 = "./src/test/resources/file1.json";
        var path2 = "./src/test/resources/file2.json";
        String actual = Differ.generate(path1, path2, style);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "stylish, ./src/test/resources/file2_stylish",
        "plain, ./src/test/resources/file2_plain",
        "json, ./src/test/resources/file2_json"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void generateJsonTest(String style, String filePath) throws Exception {
        String expected = Differ.readFile(Differ.readPathFile(filePath));
        var path1 = "./src/test/resources/file1s9.json";
        var path2 = "./src/test/resources/file2s9.json";
        String actual = Differ.generate(path1, path2, style);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "stylish, ./src/test/resources/file2_stylish",
        "plain, ./src/test/resources/file2_plain",
        "json, ./src/test/resources/file2_json"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void generateYamlTest(String style, String filePath) throws Exception {
        String expected = Differ.readFile(Differ.readPathFile(filePath));
        var path1 = "./src/test/resources/file1s9.yml";
        var path2 = "./src/test/resources/file2s9.yml";
        String actual = Differ.generate(path1, path2, style);
        assertEquals(expected, actual);
    }
}
