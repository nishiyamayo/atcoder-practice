package abc162;

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
        int N = sc.nextInt();
        String S = sc.next();
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (char c : S.toCharArray()) {
            int s = cnt.getOrDefault(c, 0) + 1;
            cnt.put(c, s);
        }

        int m = 0;
        for (int i = 0; i < N; i++) {
            for (int l = 1; l < N; l++) {
                if (i + 2 * l >= N) continue;
                if (S.charAt(i) != S.charAt(i + l) && S.charAt(i + l) != S.charAt(i + 2 * l) && S.charAt(i) != S.charAt(i + 2 * l)) {
                    m++;
                }
            }
        }

        out.println(1L * cnt.getOrDefault('R', 0) * cnt.getOrDefault('G', 0) * cnt.getOrDefault('B', 0) - m);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}