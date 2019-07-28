package abc135;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        if (Math.abs(a + b) % 2 == 0) {
            System.out.println(Math.abs(a + b) / 2);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }


    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
