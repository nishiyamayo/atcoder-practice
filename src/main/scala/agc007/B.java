package agc007;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n], b = new int[n];
        int ac = 1, bc = 1;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt() - 1;
            a[i] = i + 1;
        }
    }
}
