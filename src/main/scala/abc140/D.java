package abc140;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        String s = sc.next();

        int ans = 0;
        int lr = 0, rl = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == 'R') {
                ans++;
            }
            if (s.charAt(n - i - 1) == s.charAt(n - i - 2) && s.charAt(n - i - 1) == 'L') {
                ans++;
            }
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) == 'R') {
                rl++;
            } else if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) == 'L') {
                lr++;
            }
        }
        ans += 2 * Math.min(Math.min(lr, rl), k);
        if (lr != rl && Math.min(lr, rl) < k) ans++;
        System.out.println(ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

}
