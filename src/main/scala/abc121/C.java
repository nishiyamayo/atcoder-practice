package abc121;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        V[] vs = new V[n];

        for (int i = 0; i < n; i++) {
            vs[i] = new V(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(vs);

        long ret = 0;
        for (int i = 0;m > 0;i++) {
            if (m >= vs[i].b) {
                ret += 1L * vs[i].a * vs[i].b;
                m -= vs[i].b;
            } else {
                ret += 1L * vs[i].a * m;
                m = 0;
            }
        }

        System.out.println(ret);
    }

    class V implements Comparable<V> {

        int a, b;

        V(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(V o) {
            return a - o.a;
        }
    }

    public static void main(String[] args) {
        new C().run();
    }
}
