package abc036;

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
        int n = sc.nextInt();
        int[] a = new int[n];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            a[i] = x;
            set.add(x);
        }

        int[] s = new int[set.size()];
        int index = 0;
        for (int x : set){
            s[index++] = x;
        }
        Arrays.sort(s);


        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            m.put(s[i], i);
        }

        for (int i = 0; i < n; i++) {
            out.println(m.get(a[i]));
        }

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}