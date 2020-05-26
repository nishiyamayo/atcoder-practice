package past002;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class J {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public J() {
        this(System.in, System.out);
    }

    public J(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        s = sc.next() + "=";
        cur = 0;
        out.println(exp());

        out.flush();
    }

    String s;
    int cur;

    char next() {
        char c = s.charAt(cur++);
        return c;
    }

    String exp() {
        StringBuilder sb = new StringBuilder();
        sb.append(fac());
        char c = next();
//        debug(c);
        while (c != '=') {
            cur--;
            sb.append(fac());
            c = next();
        }
//        debug(sb);
        return sb.toString();
    }

    String fac() {
        StringBuilder sb = new StringBuilder();
        sb.append(rev());
        char c = next();
        while (c != ')' && c != '=') {
            cur--;
            sb.append(rev());
            c = next();
        }
        cur--;
//        debug(sb);
        return sb.toString();
    }

    String rev() {
        char c = next();
        if (c == '(') {
            String s = fac();
            StringBuilder sb = new StringBuilder(s);
            int l = s.length();
            cur++;
            for (int i = 0; i < l; i++) sb.append(s.charAt(l - i - 1));
//            debug(sb);
            return sb.toString();
        } else if (c == ')') {
            cur--;
            return "";
        } else {
            return "" + c;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new J().run();
    }
}