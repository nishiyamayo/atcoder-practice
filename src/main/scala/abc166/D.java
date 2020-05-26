package abc166;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public D() {
        this(System.in, System.out);
    }

    public D(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        long x = sc.nextInt();
        HashMap<Integer, Long> tars = new HashMap<>();
        tars.put(0, 0L);
        for (int i = 1; i <= 3000; i++) {
            tars.put(i, 1L * i * i * i * i * i);
            tars.put(-i, -1L * i * i * i * i * i);
        }

        ok(out, x, tars, tars);

        out.flush();
    }

    void ok(PrintWriter out, long x, HashMap<Integer, Long> m1, HashMap<Integer, Long> m2) {
        for (Map.Entry<Integer, Long> e1 : m1.entrySet()) {
            for (Map.Entry<Integer, Long> e2 : m2.entrySet()) {
                if (e2.getValue() - e1.getValue() == x) {
                    out.println(e2.getKey() + " " + e1.getKey());
                    return;
                }
            }
        }
    }



    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}