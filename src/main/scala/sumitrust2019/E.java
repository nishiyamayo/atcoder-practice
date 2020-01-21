package sumitrust2019;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    int n;
    int[] a;
    void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt() + 1;
        }
        System.out.println(solve());
    }

    long MOD = 1000000007;
    long solve() {
        int[] cnt = new int[n + 1];
        cnt[0] = 3;


        long ans = 1;
        for (int i = 0; i < n; i++) {
            int idx = a[i];
            ans = ans * cnt[idx - 1] % MOD;
            cnt[idx - 1] --;
            cnt[idx] ++;
            if (cnt[idx - 1] < 0 || cnt[idx] > 3) return 0;
        }
        return ans;
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
