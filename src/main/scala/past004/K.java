package past004;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class K {
    long MOD = (long) 1e9;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        int k = sc.nextInt();
        long[][] a = new long[k][22];
        long[] t = new long[k];
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int ai = sc.nextInt();
                a[i][ai] += 1;

                long sum = 0;
                for (int l = ai + 1; l <= 20; l++) {
                    sum += a[i][l];
                }
                t[i] += sum;
                t[i] %= MOD;
            }
        }


        int q = sc.nextInt();
        long ans = 0;
        long[] cnts = new long[22];
        for (int i = 0; i < q; i++) {
            int b = sc.nextInt() - 1;
            long[] sum = new long[22];
            sum[20] = cnts[20];
            for (int j = 19; j >= 0; j--) {
                sum[j] += sum[j + 1] + cnts[j];
            }
            ans += t[b];
            ans %= MOD;
            for (int j = 1; j <= 20; j++) {
                ans += a[b][j] * sum[j + 1] % MOD;
                cnts[j] += a[b][j];
                ans %= MOD;
            }
        }
        out.println(ans);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new K().run();
    }
}