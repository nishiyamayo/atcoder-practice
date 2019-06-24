package abc131;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        P[] ps = new P[n];

        long t = 0;
        for (int i = 0; i < n; i++) {
            ps[i] = new P(sc.nextInt(), sc.nextInt());
            t += ps[i].a;
        }

        Arrays.sort(ps);
        for (int i = 0; i < n; i++) {
            if (t > ps[i].b) t = ps[i].b;
            if (t - ps[i].a < 0) {
                System.out.println("No");
                return;
            }
            t -= ps[i].a;
        }

        System.out.println("Yes");
    }

    class P implements Comparable<P> {
        int a, b;
        P(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(P o) {
            return o.b - b;
        }
    }


    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
