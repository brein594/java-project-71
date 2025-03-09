package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.nio.file.Paths;

class AppTest {
    @ParameterizedTest
    @ValueSource(strings = {"json", "yml", "yaml" })
    public void getDataTest(String nameFormat) throws Exception {
        var expected = new HashMap<String, Object>(Map.of("host", "hexlet.io", "timeout", "50"));
        var string = "{ \"host\" : \"hexlet.io\", \"timeout\" : \"50\" }";
        var actual = Parser.getData(string, nameFormat);
        assertEquals(expected, actual);
    }

    @Test
    public void getDataDefaultTest()  {
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

    @Test
    public void generateStylishVoidTest() throws Exception {
        String expected = Differ.readFile(Differ.readPathFile("./src/test/resources/StylishTest1.txt"));
        var path1 = "./src/test/resources/file1.json";
        var path2 = "./src/test/resources/file2.json";
        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }

    @Test
    public void generateStylishTest() throws Exception {

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        //String expected = Differ.readFile(Differ.readPathFile("./src/test/resources/StylishTest1.txt")).trim();
        //var path1 = "/home/hexlet/play_brain/java-project-71/app/src/test/resources/file1.json";
        var path1 = "./src/test/resources/file1.json";
        var path2 = "./src/test/resources/file2.json";
        String actual = Differ.generate(path1, path2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void generatePlainTest() throws Exception {
        String expected =
                "Property 'follow' was removed\n"
                        + "Property 'proxy' was removed\n"
                        + "Property 'timeout' was updated. From 50 to 20\n"
                        + "Property 'verbose' was added with value: true";
        var path1 = "./src/test/resources/file1.json";
        var path2 = "./src/test/resources/file2.json";
        String actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual, "errorTest");
    }

    @Test
    public void generateStylishStep9Test() throws Exception {
        String expected =
                "{\n"
                        + "    chars1: [a, b, c]\n"
                        + "  - chars2: [d, e, f]\n"
                        + "  + chars2: false\n"
                        + "  - checked: false\n"
                        + "  + checked: true\n"
                        + "  - default: null\n"
                        + "  + default: [value1, value2]\n"
                        + "  - id: 45\n"
                        + "  + id: null\n"
                        + "  - key1: value1\n"
                        + "  + key2: value2\n"
                        + "    numbers1: [1, 2, 3, 4]\n"
                        + "  - numbers2: [2, 3, 4, 5]\n"
                        + "  + numbers2: [22, 33, 44, 55]\n"
                        + "  - numbers3: [3, 4, 5]\n"
                        + "  + numbers4: [4, 5, 6]\n"
                        + "  + obj1: {nestedKey=value, isNested=true}\n"
                        + "  - setting1: Some value\n"
                        + "  + setting1: Another value\n"
                        + "  - setting2: 200\n"
                        + "  + setting2: 300\n"
                        + "  - setting3: true\n"
                        + "  + setting3: none\n"
                        + "}";
        var path1 = "./src/test/resources/file1s9.json";
        var path2 = "./src/test/resources/file2s9.json";
        String actual = Differ.generate(path1, path2, "stylish");
        assertEquals(expected, actual, "errorTest");
    }


    @Test
    public void generatePlainStep9Test() throws Exception {
        String expected =
                "Property 'chars2' was updated. From [complex value] to false\n"
                        + "Property 'checked' was updated. From false to true\n"
                        + "Property 'default' was updated. From null to [complex value]\n"
                        + "Property 'id' was updated. From 45 to null\n"
                        + "Property 'key1' was removed\n"
                        + "Property 'key2' was added with value: 'value2'\n"
                        + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                        + "Property 'numbers3' was removed\n"
                        + "Property 'numbers4' was added with value: [complex value]\n"
                        + "Property 'obj1' was added with value: [complex value]\n"
                        + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                        + "Property 'setting2' was updated. From 200 to 300\n"
                        + "Property 'setting3' was updated. From true to 'none'";
        var path1 = "./src/test/resources/file1s9.json";
        var path2 = "./src/test/resources/file2s9.json";
        String actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual, "errorTest");
    }

    @Test
    public void generateJsonStep11Test() throws Exception {
        String expected =
                "{\n"
                       + "  \"chars1\" : [ \"=\", [ \"a\", \"b\", \"c\" ] ],\n"
                       + "  \"chars2\" : [ [ \"d\", \"e\", \"f\" ], false ],\n"
                       + "  \"checked\" : [ false, true ],\n"
                       + "  \"default\" : [ \"null\", [ \"value1\", \"value2\" ] ],\n"
                       + "  \"id\" : [ 45, \"null\" ],\n"
                       + "  \"key1\" : [ \"-\", \"value1\" ],\n"
                       + "  \"key2\" : [ \"+\", \"value2\" ],\n"
                       + "  \"numbers1\" : [ \"=\", [ 1, 2, 3, 4 ] ],\n"
                       + "  \"numbers2\" : [ [ 2, 3, 4, 5 ], [ 22, 33, 44, 55 ] ],\n"
                       + "  \"numbers3\" : [ \"-\", [ 3, 4, 5 ] ],\n"
                       + "  \"numbers4\" : [ \"+\", [ 4, 5, 6 ] ],\n"
                       + "  \"obj1\" : [ \"+\", {\n"
                       + "    \"nestedKey\" : \"value\",\n"
                       + "    \"isNested\" : true\n"
                       + "  } ],\n"
                       + "  \"setting1\" : [ \"Some value\", \"Another value\" ],\n"
                       + "  \"setting2\" : [ 200, 300 ],\n"
                       + "  \"setting3\" : [ true, \"none\" ]\n"
                       + "}";
        var path1 = "./src/test/resources/file1s9.json";
        var path2 = "./src/test/resources/file2s9.json";
        String actual = Differ.generate(path1, path2, "json");
        assertEquals(expected, actual, "errorTest");
    }

}
