package joi2019_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    int m, r;
    void run() {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        r = sc.nextInt();

        System.out.println(dijkstra());
    }

    int[][] dirs = {
            // 0
            {0, 1, 2, 3, 2, 3, 4, 3, 4, 5},
            // 1
            {1, 0, 1, 2, 1, 2, 3, 2, 3, 4},
            // 2
            {2, 1, 0, 1, 2, 1, 2, 3, 2, 3},
            // 3
            {3, 2, 1, 0, 3, 2, 1, 4, 3, 2},
            // 4
            {2, 1, 2, 3, 0, 1, 2, 1, 2, 3},
            // 5
            {3, 2, 1, 2, 1, 0, 1, 2, 1, 2},
            // 6
            {4, 3, 2, 1, 2, 1, 0, 3, 2, 1},
            // 7
            {3, 2, 3, 4, 1, 2, 3, 0, 1, 2},
            // 8
            {4, 3, 2, 3, 2, 1, 2, 1, 0, 1},
            // 9
            {5, 4, 3, 2, 3, 2, 1, 2, 1, 0}
    };
    long dijkstra() {
        // あまりがr, 押したキーがxの時の最小の操作回数
        long[][] d = new long[m][10];
        for (long[] a: d) Arrays.fill(a, 1L << 50);
        PriorityQueue<P> q = new PriorityQueue<>();
        for (int i = 1; i < 10; i++) {
            int nextR = i % m;
            long nextC = dirs[0][i] + 1;
            if (d[nextR][i] > nextC) {
                d[nextR][i] = nextC;
                q.add(new P(nextR, i, nextC));
            }
        }

        while (!q.isEmpty()) {
            P cur = q.remove();
            if (cur.to == r) return cur.cost;
            if (d[cur.to][cur.dig] != cur.cost) continue;

            for (int i = 0; i < 10; i++) {
                int nextR = (cur.to * 10 + i) % m;
                long nextC = cur.cost + dirs[cur.dig][i] + 1;
                if (d[nextR][i] > nextC) {
                    d[nextR][i] = nextC;
                    q.add(new P(nextR, i, nextC));
                }
            }
        }
        return -1;
    }

    class P implements Comparable<P> {

        int to;
        int dig;
        long cost;
        P(int to, int dig, long cost) {
            this.to = to;
            this.dig = dig;
            this.cost = cost;
        }

        @Override
        public int compareTo(P o) {
            return Long.compare(cost, o.cost);
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
