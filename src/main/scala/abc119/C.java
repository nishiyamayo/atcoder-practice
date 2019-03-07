package abc119;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    int a, b, c, n;
    int[] ls;
    int[] ts;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
        ts = new int[]{a, b, c};
        ls = new int[n];
        for (int i = 0; i < n; i++) {
            ls[i] = sc.nextInt();
        }

        int max = 1 << (n * 3);
        int mask = (1 << n) - 1;
        int ans = 1 << 30;
        for (int i = 0; i < max; i++) {
            int ab = i & mask;
            int bb = (i >> n) & mask;
            int cb = (i >> (n * 2)) & mask;
            ans = Math.min(ans, calc(ab, bb, cb));
        }
        System.out.println(ans);
    }

    int calc(int ab, int bb, int cb) {
//        debug(Integer.toBinaryString(ab), Integer.toBinaryString(ab), Integer.toBinaryString(ab));
        if (ab == 0 || bb == 0 || cb == 0) {
            return 1 << 30;
        }
        if ((ab & bb) > 0 || (bb & cb) > 0 || (cb & ab) > 0) {
            return 1 << 30;
        }
        int[] bs = {ab, bb, cb};
        int cost = 0;
        for (int j = 0; j < 3; j++) {
            int len = 0;
            cost += (Integer.bitCount(bs[j]) - 1) * 10;
            for (int i = 0; i < n; i++) if (((bs[j] >> i) & 1) == 1) {
                len += ls[i];
            }
            cost += Math.abs(ts[j] - len);
        }
        return cost;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
