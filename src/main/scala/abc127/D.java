package abc127;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        PriorityQueue<P> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) q.add(new P(1, sc.nextInt()));

        for (int i = 0; i < m; i++) q.add(new P(sc.nextInt(), sc.nextInt()));

        long ans = 0;

        while (n > 0) {
            P cur = q.remove();

            if (n > cur.b) {
                n -= cur.b;
                ans += 1L * cur.b * cur.c;
            } else {
                ans += 1L * n * cur.c;
                n = 0;
            }
        }
        System.out.println(ans);
    }

    class P implements Comparable<P> {
        int b, c;
        P(int b, int c) {
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(P o) {
            return o.c - c;
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

}
