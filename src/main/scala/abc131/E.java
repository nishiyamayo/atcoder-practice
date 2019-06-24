package abc131;

import java.util.Arrays;
import java.util.Scanner;

public class E {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        if (n == 2) {
            if (k == 0) {
                System.out.println(1);
                System.out.println("1 2");
            } else {
                System.out.println(-1);
            }
            return;
        }
        if (k > (n - 1) * (n - 2) / 2) {
            System.out.println(-1);
            return;
        }
        System.out.println(n * (n - 1) / 2 - k);
        boolean[][] b = new boolean[n][n];
        for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) {
            b[i][j] = true;
        }
        for (int i = 1; i < n; i++) for (int j = i + 1; j < n; j++) {
            if (k == 0) continue;
            k--;
            b[i][j] = false;
        }
        for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) {
            if (b[i][j]) {
                System.out.println((i + 1) + " " + (j + 1));
            }
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
