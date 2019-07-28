package vprocon.con07;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        int sum = 0;
        boolean satMark = false;
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt() * 10;
            sum += ar[i];
            satMark |= ar[i] == 30;
        }

        if (satMark) {
            System.out.println("None");
        } else if (sum == n * 50) {
            System.out.println("Named");

        } else if ( sum >= 45 * n) {
            System.out.println("High");

        } else {
            System.out.println("Common");

        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }

}
