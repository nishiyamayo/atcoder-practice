package abc139;

import abc138.F;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
    int n;
    int[][] vs;
    void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        vs = new int[n][n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                vs[i][j] = sc.nextInt() - 1;
            }
        }

        HashSet<Integer> s = new HashSet<>();

        int[] cnts = new int[n];
        int[] spends = new int[n];
        for (int i = 0; i < n; i++) {
            cnts[i] = 0;
            s.add(i);
        }

        int d = 0;
        PriorityQueue<V> q = new PriorityQueue<>();
        boolean[] used = new boolean[n];
        for (;; d++) {
            for (int i: s) {
                used[i] = false;
            }
            for (int i: s) {
                int t = vs[i][cnts[i]];
//                debug(i, t, cnts[i], cnts[t]);
                int td = vs[t][cnts[t]];
                if (td != i) {
                    continue;
                }
                q.add(new V(cnts[i], i, t));
            }

            if (q.isEmpty()) {
                if (s.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(d);
                }
                return;
            }

            boolean end = true;

            while (!q.isEmpty()) {
                V c = q.remove();
                if (used[c.a] || used[c.b]) {
                    continue;
                }
                used[c.a] = used[c.b] = true;
                cnts[c.a]++;
                cnts[c.b]++;
                if (cnts[c.a] == n - 1) {
                    s.remove((Integer) c.a);
                }
                if (cnts[c.b] == n - 1) {
                    s.remove((Integer) c.b);
                }
                end = false;
            }
            if (end) {
                System.out.println(-1);
                break;
            }
        }
    }

    class V implements Comparable<V> {

        int d, a, b;
        V(int d, int a, int b) {
            this.d = d;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(V o) {
            return d - o.d;
        }
    }

    public int lowerBound(int[] array, int value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] >= value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }
    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
