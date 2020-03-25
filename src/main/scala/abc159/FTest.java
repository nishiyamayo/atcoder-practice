package abc159;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class FTest {

    @Test
    void example1() {
        String inText = "3 4\n" +
                "2 2 4";

        String outText = "5\n";

        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new F(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }

    @Test
    void example2() {
        String inText = "5 8\n" +
                "9 9 9 9 9";

        String outText = "0\n";

        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new F(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }

    @Test
    void example3() {
        String inText = "10 10\n" +
                "3 1 4 1 5 9 2 6 5 3";

        String outText = "152\n";

        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new F(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }

}
    