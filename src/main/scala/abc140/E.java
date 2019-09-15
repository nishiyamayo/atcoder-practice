package abc140;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class E {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        LinkedList<Pair> l = new LinkedList<>(), r = new LinkedList<>();
        l.addLast(new Pair(p[0], 0));
        r.addLast(new Pair(p[n - 1], 0));

        long ans = 0;
        for (int i = 1; i < n; i++) {
            Pair ll = l.removeLast();
            Pair rr = r.removeLast();

            if (ll.p > p[i]) {
                int c = ll.c + 1;
                while (!l.isEmpty()) {
                    Pair t = l.removeLast();
                    if (t.p > p[i]) {
                        l.addLast(t);
                        break;
                    }
                }
                ans += 1L * c * p[i];
                l.addLast(new Pair(p[i], c));
            } else {
                ans += 1L * ll.c * ll.p;
                ans += ll.p;
                l.addLast(ll);
                l.addLast(new Pair(p[i], 0));
            }
            if (rr.p > p[n - i - 1]) {
                int c = rr.c + 1;
                while (!r.isEmpty()) {
                    Pair t = r.removeLast();
                    if (t.p > p[n - i - 1]) {
                        r.addLast(t);
                        break;
                    }
                }
                ans += 1L * c * p[n - i - 1];
                r.addLast(new Pair(p[n - i - 1], c));
            } else {
                ans += 1L * rr.c * rr.p;
                r.addLast(rr);
                r.addLast(new Pair(p[n - i - 1], 0));
            }

            debug(ll, l, ans);
            debug(rr, r, ans);
        }
        System.out.println(ans);
    }

    class Pair {
        int p, c;
        Pair(int p, int c) {
            this.p = p;
            this.c = c;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", p, c);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
