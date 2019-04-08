package abc123;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {

    int x, y, z;
    int k;
    long[] a, b, c;

    void run() {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
        k = sc.nextInt();
        a = new long[x];
        b = new long[y];
        c = new long[z];

        for (int i = 0; i < x; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < y; i++) {
            b[i] = sc.nextLong();
        }
        for (int i = 0; i < z; i++) {
            c[i] = sc.nextLong();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        PriorityQueue<V> q = new PriorityQueue<>();
        q.add(new V(a[x - 1] + b[y - 1] + c[z - 1], x - 1, y - 1, z - 1));
        HashSet<Long> used = new HashSet<>();
        used.add(ints2long(x - 1, y - 1, z - 1));
        for (;k > 0; k--) {
            V cur = q.remove();
            System.out.println(cur.cost);
            if (cur.a - 1 >= 0 && !used.contains(ints2long(cur.a - 1, cur.b, cur.c))) {
                q.add(new V(a[cur.a - 1] + b[cur.b] + c[cur.c], cur.a - 1, cur.b, cur.c));
                used.add(ints2long(cur.a - 1, cur.b, cur.c));
            }

            if (cur.b - 1 >= 0 && !used.contains(ints2long(cur.a, cur.b - 1, cur.c))) {
                q.add(new V(a[cur.a] + b[cur.b - 1] + c[cur.c], cur.a, cur.b - 1, cur.c));
                used.add(ints2long(cur.a, cur.b - 1, cur.c));
            }

            if (cur.c - 1 >= 0 && !used.contains(ints2long(cur.a, cur.b, cur.c - 1))) {
                q.add(new V(a[cur.a] + b[cur.b] + c[cur.c - 1], cur.a, cur.b, cur.c - 1));
                used.add(ints2long(cur.a, cur.b, cur.c - 1));
            }
        }
    }

    long ints2long(long x, long y, long z) {
        return x * 10000 * 10000 + y * 10000 + z;
    }

    class V implements Comparable<V> {
        long cost;
        int a, b, c;
        V(long cost, int a, int b, int c) {
            this.cost = cost;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(V o) {
            return (o.cost - cost) > 0 ? 1: -1;
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
