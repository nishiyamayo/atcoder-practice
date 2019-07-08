package bcu30_2018;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ages = new int[30];
        for (int i = 0; i < n; i++) ages[sc.nextInt()]++;

        System.out.print(ages[0]);
        for (int i = 1; i < 30; i++)System.out.print(" " + ages[i]);
        System.out.println();
    }
}
