package abc162;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

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
        int k = sc.nextInt();
        long sum = 0;
        for (int a = 1; a <= k; a++) {
            for (int b = 1; b <= k; b++) {
                for (int c = 1; c <= k; c++) {
                    sum += gcd(gcd(a, b), c);
                }
            }
        }
        out.println(sum);

        out.flush();
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int gcd(int a, int b) {
        if (map.containsKey(a * 1000 + b)) return map.get(a * 1000 + b);
        if (b == 0) {
            map.put(a * 1000 + b, a);
            return a;
        }
        int ret = gcd(b, a % b);
        map.put(a * 1000 + b, ret);
        return ret;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}