package abc126;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt() - 1;
        String s = sc.next();
        System.out.println(s.substring(0, k) + s.substring(k, k + 1).toLowerCase() + s.substring(k + 1));
    }
}
