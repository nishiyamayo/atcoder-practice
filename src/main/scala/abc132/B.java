package abc132;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) ar[i] = sc.nextInt();
        for (int i = 0; i < n - 2; i++) {
            if (ar[i] < ar[i + 1] && ar[i + 1] < ar[i + 2] || ar[i] > ar[i + 1] && ar[i + 1] > ar[i + 2]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
