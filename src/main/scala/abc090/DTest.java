package abc090;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DTest {

    @Test
    void example1() {
        String inText = "5 2";

        String outText = "7\n";

        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new D(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }
    
    @Test
    void example2() {
        String inText = "10 0";
    
        String outText = "100\n";

        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new D(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }

    @Test
    void example3() {
        String inText = "31415 9265";

        String outText = "287927211\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Assertions.assertTimeout(Duration.ofSeconds(2), () -> {
            new D(in, out).run();
            assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
        });
    }
}
