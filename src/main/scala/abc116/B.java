package abc116;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int m = 1;
        Set<Integer> used = new HashSet<>();
        for (; !used.contains(s); m++) {
            used.add(s);
            if (s % 2 == 0) {
                s /= 2;
            } else {
                s = s * 3 + 1;
            }
        }
        System.out.println(m);
    }

    public static void main(String[] args) {
        new B().run();
    }
}
