package past19;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class N {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt(), c = sc.nextInt();
        P[] ls = new P[n], rs = new P[n];

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt(), r = sc.nextInt(), p = sc.nextInt();
            ls[i] = new P(l, p);
            rs[i] = new P(r, p);
        }
        Arrays.sort(ls);
        Arrays.sort(rs);

        int l = 0, r = ls[0].x, idxl = 0, idxr = 0;
        long cost = 0;
        long ans = 1L << 60;
        while (idxl < n && idxr < n) {
            while ((r - l) < c) {
                cost += ls[idxl].c;
                idxl++;
                if (idxl < n) {
                    r = ls[idxl].x;
                    break;
                } else {
                    r = w;
                    break;
                }
            }
            debug(idxl, cost, l , r);

            while (idxr < n && (r - l) >= c) {
                debug(idxr);
                ans = Math.min(ans, cost);


                l = rs[idxr].x;
                cost -= rs[idxr].c;
                idxr++;
            }
        }

        if (r - l >= c) ans = Math.min(ans, cost);

        System.out.println(ans);
    }

    class P implements Comparable<P> {
        int x;
        int c;

        P(int x, int c) {
            this.x = x;
            this.c = c;
        }

        @Override
        public int compareTo(P o) {
            return Integer.compare(x, o.x);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new N().run();
    }

}
