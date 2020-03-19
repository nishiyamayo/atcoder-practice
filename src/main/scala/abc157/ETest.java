package abc157;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ETest {

    @Test
    void example1() {
        String inText = "7\n" +
                "abcdbbd\n" +
                "6\n" +
                "2 3 6\n" +
                "1 5 z\n" +
                "2 1 1\n" +
                "1 4 a\n" +
                "1 7 d\n" +
                "2 1 7";

        String outText = "3\n" +
                "1\n" +
                "5\n";

        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new E(in, out).run();
        assertArrayEquals(outText.getBytes(), out.toByteArray());
    }

}