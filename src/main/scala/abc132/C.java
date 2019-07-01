package abc132;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    int MAX = 100000;
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ds = new int[MAX + 1];

        for (int i = 0; i < n; i++) {
            ds[sc.nextInt()]++;
        }
        n /= 2;
        int cnt = 0;
        for (int i = 1; i <= MAX; i++) {
            ds[i] += ds[i - 1];
            if (ds[i] == n) cnt++;
        }
//        debug(ds);
        System.out.println(cnt);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
