package joi2008;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class C {

    public static int upperBound(int[] array, int value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] > value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }


    public static int lowerBound(int[] array, int value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] >= value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // write your code
        int n = sc.nextInt(), m = sc.nextInt();
        int[] ps = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ps[i] = sc.nextInt();
        }

        int[] p2 = new int[(n + 1) * (n + 1)];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                p2[i * (n + 1) + j] = ps[i] + ps[j];
            }
        }

        int ans = 0;

        Arrays.sort(p2);

        for (int i = 0; i < (n + 1) * (n + 1); i++) {
            int l = p2[i];
            if (m < l) continue;
            int idx = upperBound(p2, m - l);
            idx--;
            int r = p2[idx];
            ans = Math.max(ans, l + r);
        }
        System.out.println(ans);
    }
}