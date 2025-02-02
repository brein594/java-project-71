package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.nio.file.Paths;

class AppTest {
    @Test
    public void getDataWorkTest() throws Exception {
        var expected = new HashMap<String, Object>(Map.of("host", "hexlet.io", "timeout", "50"));
        var string = "{ \"host\" : \"hexlet.io\", \"timeout\" : \"50\" }";
        var actual = Differ.getData(string);
        assertEquals(expected, actual, "errorTest");
    }

    @Test
    public void readFixtureTest() throws Exception {
        var expected = "/home/hexlet/play_brain/java-project-71/app/src/test/resources/file1.json";
        var string = "/home/hexlet/play_brain/java-project-71/app/src/test/resources/file1.json";
        var actual = Differ.readFixture(string).toString();
        assertEquals(expected, actual, "errorTest");
    }

    @Test
    public void readFileTest() throws Exception {
        String expected = "test";
        var path = Paths.get("/home/hexlet/play_brain/java-project-71/app/src/test/resources/file3.json");
        String actual = Differ.readFile(path);
        assertEquals(expected, actual, "errorTest");
    }

    @Test
    public void generateTest() throws Exception {
        String expected = "- follow: false\n"
                + "  host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "+ timeout: 20\n"
                + "+ verbose: true\n";
        var path1 = "/home/hexlet/play_brain/java-project-71/app/src/test/resources/file1.json";
        var path2 = "/home/hexlet/play_brain/java-project-71/app/src/test/resources/file2.json";
        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual, "errorTest");
    }

}
