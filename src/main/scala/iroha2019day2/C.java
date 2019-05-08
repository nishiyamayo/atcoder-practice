package iroha2019day2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            s.add(a[i]);
        }
        HashMap<Integer, Integer> i2i = new HashMap<>();
        int p = 1;
        for (int x: s) {
            i2i.put(x, p++);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i2i.get(a[i]));
        }
    }
}
