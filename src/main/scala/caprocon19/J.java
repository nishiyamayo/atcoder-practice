package caprocon19;

import java.util.*;

public class J {
    Scanner sc = new Scanner(System.in);

    void run() {
        int T = sc.nextInt();
        for (int i =0; i < T; i++) {
            System.out.println(solve());
        }
    }

    long solve() {
        int n = sc.nextInt(), m = sc.nextInt();
        MySet[] ss = new MySet[n];
        for (int i = 0; i < n; i++) {
            ss[i] = new MySet();
            for (int j = 0; j < m; j++) {
                int c = sc.nextInt();
                int cnt = ss[i].getOrDefault(c, 0);
                ss[i].put(c, cnt + 1);
            }
        }

        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (Map.Entry<Integer, Integer> entry : ss[i].entrySet()) {
                int c0 = entry.getValue();
                int c1 = ss[i + 1].getOrDefault(entry.getKey(), 0);
                ans += Math.min(c0, c1);
            }
        }
        return ans;
    }

    class MySet extends HashMap<Integer, Integer> {}

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new J().run();
    }

}
