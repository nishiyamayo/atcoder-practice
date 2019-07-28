package abc134;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class E {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n + 10];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        int[] ans = new int[n + 10];
        Arrays.fill(ans, -(1 << 30));
        ans[0] = ar[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (ans[len - 1] >= ar[i]) {
                ans[len] = ar[i];
                len++;
            } else {
                int idx = upperBound(ans, ar[i]);
                debug(i, idx);
                ans[idx] = ar[i];
            }
        }
        System.out.println(len);
    }

    public int upperBound(int[] array, int value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] < value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }


    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
