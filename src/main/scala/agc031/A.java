package agc031;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    long MOD = (long)1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String s = sc.next();

        int[] cnts = new int[26];
        for (int i = 0; i < len; i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        long ans = 1L;
        for (int i = 0; i < 26; i++) {
            ans = ((cnts[i] + 1) * ans) % MOD;
        }
        System.out.println((ans + MOD - 1) % MOD);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
