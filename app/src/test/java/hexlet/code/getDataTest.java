package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class getDataTest {
    @Test
    public void getDataWorkTest() throws Exception {
        var expected = new HashMap<String, Object>(Map.of("host", "hexlet.io", "timeout", "50"));
        var string = "{ host : hexlet.io, timeout : 50 }";
        var actual = Differ.getData(string);
        assertEquals(expected, actual);
    }
}
