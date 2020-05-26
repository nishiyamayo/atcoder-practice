package past002;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class M {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public M() {
        this(System.in, System.out);
    }

    public M(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int d = sc.nextInt();
        int l = sc.nextInt();
        int n = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
        HashMap<Integer, Integer> mc = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            ArrayList<Integer> list = m.getOrDefault(c, new ArrayList<>());
            int cnt = mc.getOrDefault(c, 0);
            if (cnt > 0) {
                list.get(cnt - 1);
            }
        }
        int[] ks = new int[n], fs = new int[n], ts = new int[n];
        for (int i = 0; i < n; i++) {
            ks[i] = sc.nextInt();
            fs[i] = sc.nextInt();
            ts[i] = sc.nextInt();
        }

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new M().run();
    }
}