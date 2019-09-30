package abc141;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        PriorityQueue<Long> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            q.add(-sc.nextLong());
        }

        for (int i = 0; i < m; i++) {
            long x = q.remove();
            q.add(x / 2);
        }

        long sum = 0;
        while (!q.isEmpty()) sum += q.remove();

        System.out.println(-sum);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

}
