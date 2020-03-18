package past19;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class O {
    int n;
    Dice[][] ds;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ds = new Dice[n][6];
        PriorityQueue<Dice> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                ds[i][j] = new Dice(i, j, sc.nextInt());
                q.add(ds[i][j]);
            }
        }
        double[] exs = new double[n];
        Arrays.fill(exs, 1);
        double target = 1;
        while (!q.isEmpty()) {
            Dice cur = q.remove();
            double max = target;
//            double max = 0;
//            for (int i = 0; i < n; i++) {
//                double sum = 0;
//                for (int j = 0; j < 6; j++) {
//                    sum += 1.0 * (ds[i][j].ex + 1) / 6;
//                }
//                max = Math.max(sum, max);
//            }
            cur.ex = max;
            exs[cur.idx] += cur.ex / 6;
            target = Math.max(target, exs[cur.idx]);
//            debug(target, ds);
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            double sum = 1;
            for (int j = 0; j < 6; j++) {
                sum += ds[i][j].ex / 6;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }

    class Dice implements Comparable<Dice> {
        int idx, s, v;
        int ascIdx;
        double ex;
        Dice(int idx, int s, int v) {
            this.idx = idx;
            this.s = s;
            this.v = v;
            ascIdx = -1;
        }

        @Override
        public int compareTo(Dice o) {
            return o.v - v;
        }

        @Override
        public String toString() {
            return String.format("%f", ex);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new O().run();
    }
}
