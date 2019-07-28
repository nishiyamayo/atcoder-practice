package abc135;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        long cnt = 0;
        long carry = 0;
        for (int i = 0; i < n; i++) {
            int b = sc.nextInt();
            if (a[i] <= b + carry) {
                cnt += a[i];
                a[i] -= carry;
                carry = b - Math.max(a[i], 0);
            } else {
                cnt += b + carry;
                carry = 0;
            }
//            debug(cnt, carry);
        }
        cnt += Math.min(a[n], carry);
        System.out.println(cnt);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
