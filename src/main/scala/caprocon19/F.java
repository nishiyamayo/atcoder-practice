package caprocon19;

import nikkei2019.B;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class F {
    Scanner sc = new Scanner(System.in);

    HashSet<Character> a2z = new HashSet<>();
    HashSet<Character> A2Z = new HashSet<>();

    void run() {

        for (int i = 0; i < 26; i++) {
            a2z.add((char) ('a' + i));
            A2Z.add((char) ('A' + i));
        }

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            System.out.println(solve());
        }
    }


    String solve() {
        String s = sc.next();
        int l = s.length();

        if (!a2z.contains(s.charAt(0))) {
            return "NO";
        }

        int wordCount = 1;

        for (int i = 1; i < l; i++) {
            if (!a2z.contains(s.charAt(i)) && !A2Z.contains(s.charAt(i))) {
                return "NO";
            }
            if (A2Z.contains(s.charAt(i))) {
                wordCount++;
            }
            if (wordCount > 7) {
                return "NO";
            }
        }
        return "YES";
    }


    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
