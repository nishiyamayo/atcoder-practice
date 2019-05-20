package abc126;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class F {

    void run() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), k = sc.nextInt();
        int[] pow = new int[m + 1];
        pow[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow[i] = pow[i - 1] * 2;
        }
        if (k > pow[m] - 1 || (m == 1 && k == 1)) {
            System.out.println(-1);
            return;
        }
        int[] ans = new int[1 << (m + 1)];
        if (k == 0) {

            for (int i = 0; i < (1 << m); i++) {
                ans[i * 2] = ans[i * 2 + 1] = i;
            }
        } else {
            int x = 0;
            for (int i = 1; i < (1 << m); i++, x++) {
                if (x == k) x++;
                ans[i] = ans[2 * (1 << m) - i] = x;
            }
            ans[0] = ans[1 << m] = k;
        }

        PrintWriter out = new PrintWriter(System.out);

        out.print(ans[0]);
        for (int i = 1; i < (1 << (m + 1)); i++) {
            out.print(" " + ans[i]);
        }
        out.println();
        out.flush();
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
