package abc130;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class DTest {

    @Test
    void example1() {
        String inText = "4 10\n" +
                "6 1 2 7";

        String outText = "2\n";

        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new D(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }
    
    @Test
    void example2() {
        String inText = "3 5\n" +
                "3 3 3";
    
        String outText = "3\n";
    
        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new D(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }
    
    @Test
    void example3() {
        String inText = "10 53462\n" +
                "103 35322 232 342 21099 90000 18843 9010 35221 19352";
    
        String outText = "36\n";
    
        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new D(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }
    
}
    