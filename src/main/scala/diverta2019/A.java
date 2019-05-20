package diverta2019;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        System.out.println(n - k + 1);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
