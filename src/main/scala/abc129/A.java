package abc129;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);
        int[] ar = new int[3];
        for (int i = 0; i < 3; i++) ar[i] = sc.nextInt();
        Arrays.sort(ar);
        System.out.println(ar[0] + ar[1]);
    }


    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
