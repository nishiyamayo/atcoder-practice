package abc161;

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

    int k;
    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        k = sc.nextInt();

        LinkedList<Long> q = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            q.add((long)i);
        }

        long x = -1;
        for (int i = 0; i < k; i++) {
            x = q.removeFirst();
            if (x % 10 != 0)
                q.addLast(x * 10 + (x % 10 - 1) );
            q.addLast(x * 10 + (x % 10));
            if (x % 10 != 9)
                q.addLast(x * 10 + (x % 10 + 1) );
        }

//        int cnt = 0;
//        long i;
//        for (i = 1; cnt < k; i++) {
//            if (ok(i)) cnt++;
//        }

//        out.println(i - 1);

        out.println(x);
        out.flush();
    }

    boolean ok(long v) {
        String s = "" + v;
        int l = s.length();
        for (int i = 0; i < l - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) > 1) {
                return false;
            }
        }
        return true;
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
