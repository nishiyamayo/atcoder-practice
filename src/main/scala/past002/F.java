package past002;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class F {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public F() {
        this(System.in, System.out);
    }

    public F(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt();
        P[] ps = new P[n];
        for (int i = 0; i < n; i++) {
            ps[i] = new P(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(ps);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int cur = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            while (cur < n && ps[cur].a <= i) {
                q.add(-ps[cur].b);
                cur++;
            }
            ans -= q.remove();
            out.println(ans);
        }


        out.flush();
    }

    class P implements Comparable<P> {
        int a, b;
        P(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(P o) {
            return a - o.a;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}