package abc144;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

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
        long a = sc.nextInt(), b = sc.nextInt(), x = sc.nextInt();
        if (a * a * b / 2 >= x) {
            double angle = Math.PI / 2 - Math.atan(1.0 * x / a / b / b * 2);
            out.println(angle * 180 / Math.PI);

        } else {
            double angle = Math.atan(2.0 * (a * a * b - x) / (a * a * a));
            out.println(angle * 180 / Math.PI);
        }


        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}