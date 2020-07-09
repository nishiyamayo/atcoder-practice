package abc082;

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
        String s = sc.next();
        String t = sc.next();
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        char[] ts = t.toCharArray();
        Arrays.sort(ts);

        String S = new String(ss);
        String T = new StringBuilder(new String(ts)).reverse().toString();
        out.println(S.compareTo(T) < 0 ? "Yes" : "No");

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}