package abc171;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class C {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public C() {
        this(System.in, System.out);
    }

    public C(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        long n = sc.nextLong();
        LinkedList<String> ans = new LinkedList<>();

        do {
            n--;
            ans.addFirst("" + (char)('a' + n % 26));
            n /= 26;
        } while (n != 0);


        out.println(String.join("", ans));

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}