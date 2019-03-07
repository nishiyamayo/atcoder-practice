package rcom2019;

import java.util.Scanner;

public class A {

    int[] x, y;
    int n;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            System.out.println(i);
        }

    }


    public static void main(String[] args) {
        new A().run();

    }
}