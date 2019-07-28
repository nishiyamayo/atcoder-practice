package abc134;

import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ar = new int[n];
        int first = 0, second = 0;
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
            if (first >= ar[i]) {
                second = Math.max(second, ar[i]);
            }
            first = Math.max(first, ar[i]);
        }

        for (int i = 0; i < n; i++) {
            if (ar[i] == first) {
                System.out.println(second);
            } else {
                System.out.println(first);
            }
        }
    }
}
