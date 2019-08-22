package abc009;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    int k;
    long m;

    void run() {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        m = sc.nextInt();
        long[] A = new long[k], X = new long[k];
        long[][] C = new long[k][k];

        for (int i = 0; i < k; i++) {
            A[i] = sc.nextLong();
            X[i] = A[i];
        }

        for (int i = 0; i < k; i++) {
            C[k - 1][k - i - 1] = sc.nextLong();
        }
        for (int i = 0; i < k - 1; i++) {
            C[i][i + 1] = (1L << 40) - 1;
        }

        long ans = calc(C, A);
        System.out.println(ans);
    }

    long calc(long[][] C, long[] A) {
        long[][] R = new long[k][k];
        for (int i = 0; i < k; i++) {
            R[i][i] = (1L << 40) - 1;
        }
        m--;
        while (m > 0) {
            if ((m & 1) == 1) R = mult(R, C);
            C = mult(C, C);
            m >>= 1;
        }

        long[] ans = mult(R, A);
        return ans[0];
    }

    long[][] mult(long[][] A, long[][] B) {
        long[][] R = new long[k][k];
        for (int h = 0; h < k; h++) for (int i = 0; i < k; i++) for (int j = 0; j < k; j++) {
            R[h][i] ^= A[h][j] & B[j][i];
        }
        return R;
    }

    long[] mult(long[][] A, long[] B) {
        long[] R = new long[k];
        for (int i = 0; i < k; i++) for (int j = 0; j < k; j++) {
            R[i] ^= A[i][j] & B[j];
        }
        return R;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

}
