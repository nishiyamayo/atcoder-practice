package wupc2019;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s = sc.next().toCharArray();

        for (int i = s.length - 1; i > 0; i--) {
            if (s[i - 1] == 'W' && s[i] == 'A') {
                s[i - 1] = 'A';
                s[i] = 'C';
            }
        }

        System.out.println(new String(s));
    }
}
