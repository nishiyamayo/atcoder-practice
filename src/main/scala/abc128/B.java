package abc128;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        P[] ps = new P[n];
        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            int c = sc.nextInt();
            ps[i - 1] = new P(s, c, i);
        }
        Arrays.sort(ps);
        for (int i = 0; i < n; i++) {
            System.out.println(ps[i].i);
        }
    }

    class P implements Comparable<P> {

        String s;
        int c, i;
        P(String s, int c, int i) {
            this.s = s;
            this.c = c;
            this.i = i;
        }

        @Override
        public int compareTo(P o) {
            if (s.equals(o.s)) {
                return o.c - c;
            }
            return s.compareTo(o.s);
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
