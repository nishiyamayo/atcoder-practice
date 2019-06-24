package abc131;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        for (int i = 0; i < n - 1; i++) if (s.charAt(i) == s.charAt(i + 1)){
            System.out.println("Bad");
            return;
        }
        System.out.println("Good");
    }


    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
