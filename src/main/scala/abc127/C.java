package abc127;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n + 2];
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            a[l] += 1;
            a[r + 1] -= 1;
        }
        int cnt = 0;
        for (int i = 1; i <= n + 1; i++) {
            a[i] += a[i - 1];
            if (a[i] == m) cnt++;
        }
//        debug(a);
        System.out.println(cnt);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
