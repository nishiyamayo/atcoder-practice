package abc158;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        String s = sc.next();

        HashMap<Integer, Integer> cnt = new HashMap<>();
        if (P == 2 || P == 5) {
            long ans = 0;
            for (int i = 0; i < N; i++) {
                int x = s.charAt(i) - '0';
                if (x % P == 0) {
                    ans += i + 1;
                }
            }
            System.out.println(ans);
            return;
        }

        long ans = 0;
        int cur = 0;
        int pow = 1;
        for (int i = N - 1; i >= 0; i--) {
            int x = s.charAt(i) - '0';
            cur = (cur + x * pow) % P;
            int v = cnt.getOrDefault(cur, 0);
            cnt.put(cur, v + 1);
            ans += v;
            if (cur == 0) ans++;
            pow = (pow * 10) % P;
        }

        System.out.println(ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
