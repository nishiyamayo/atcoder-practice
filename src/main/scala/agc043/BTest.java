package agc043;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class BTest {

    @Test
    void example1() {
        String inText = "4\n" +
                "1231";

        String outText = "1\n";

        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new B(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }
    
    @Test
    void example2() {
        String inText = "10\n" +
                "2311312312";
    
        String outText = "0\n";
    
        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new B(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }
    
}
    