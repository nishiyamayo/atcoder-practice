package abc146;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class B {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public B() {
        this(System.in, System.out);
    }

    public B(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt();
        String s = sc.next();
        for (char c: s.toCharArray()) {
            out.print((char)('A' + (c - 'A' + n) % 26));
        }
        out.println();

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}