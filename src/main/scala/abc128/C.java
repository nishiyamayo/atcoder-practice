package abc128;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    int n, m;
    int[][] ss;
    int[] ks;
    int[] ps;
    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();

        ss = new int[m][];
        ks = new int[m];
        ps = new int[m];
        for (int i = 0; i < m; i++) {
            ks[i] = sc.nextInt();
            ss[i] = new int[ks[i]];
            for (int j = 0; j < ks[i]; j++) {
                ss[i][j] = sc.nextInt() - 1;
            }
        }

        for (int i = 0; i < m; i++) {
            ps[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int S = 0; S < (1 << n); S++) {
            if (check(S)) cnt++;
        }
        System.out.println(cnt);
    }

    boolean check(int S) {
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < ks[i]; j++) {
                cnt += (S & (1 << ss[i][j])) > 0 ? 1 : 0;
            }
            if (cnt % 2 != ps[i]) return false;
        }
        return true;
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
