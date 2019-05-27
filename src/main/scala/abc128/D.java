package abc128;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] vs = new int[n];
        for (int i = 0; i < n; i++) {
            vs[i] = sc.nextInt();
        }

        int ans = 0;
        for (int l = 0; l <= Math.min(n, k); l++) for (int r = 0; l + r <= Math.min(n, k); r++) {
            for (int in = 0; in <= l + r && in + l + r <= k; in++) {
                PriorityQueue<Integer> q = new PriorityQueue<>();
                int sum = 0;
                for (int i = 0; i < l; i++) {
                    sum += vs[i];
                    q.add(vs[i]);
                }
                for (int i = 0; i < r; i++) {
                    sum += vs[n - i - 1];
                    q.add(vs[n - i - 1]);
                }
                for (int i = 0; i < in; i++) {
                    int t = q.remove();
//                    debug(t);
                    sum -= t;
                }
//                debug(l, r, in, sum);
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
