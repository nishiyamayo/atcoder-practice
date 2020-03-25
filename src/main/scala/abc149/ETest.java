package abc149;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class ETest {

    @Test
    void example1() {
        String inText = "5 3\n" +
                "10 14 19 34 33";

        String outText = "202\n";

        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new E(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }
    @Test
    void example2() {
        String inText = "9 14\n" +
                "1 3 5 110 24 21 34 5 3";
    
        String outText = "1837\n";
    
        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new E(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }
    
    @Test
    void example3() {
        String inText = "9 73\n" +
                "67597 52981 5828 66249 75177 64141 40773 79105 16076";
    
        String outText = "8128170\n";
    
        ByteArrayInputStream in = new ByteArrayInputStream(inText.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new E(in, out).run();
        assertEquals(new String(outText.getBytes()), new String(out.toByteArray()));
    }

}
    