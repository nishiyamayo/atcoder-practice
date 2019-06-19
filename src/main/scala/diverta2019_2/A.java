package diverta2019_2;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        if (k == 1) {
            System.out.println(0);
        } else {
            System.out.println(n - k);
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
