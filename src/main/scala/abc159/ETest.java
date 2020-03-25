package abc159;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class ETest {

    @Test
    void example1() {
        String inText = "3 5 4\n" +
                "11100\n" +
                "10001\n" +
                "00111";

        String outText = "2\n";

        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new E(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }
    
    @Test
    void example2() {
        String inText = "3 5 8\n" +
                "11100\n" +
                "10001\n" +
                "00111";
    
        String outText = "0\n";
    
        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new E(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }
    
    @Test
    void example3() {
        String inText = "4 10 4\n" +
                "1110010010\n" +
                "1000101110\n" +
                "0011101001\n" +
                "1101000111";
    
        String outText = "3\n";
    
        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new E(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }
    
}
    