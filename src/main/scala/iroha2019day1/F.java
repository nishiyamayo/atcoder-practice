package iroha2019day1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class F {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = 2;
        ArrayList<Integer> as = new ArrayList<>();

        while (n != 1 && p < 100000) {
            while (n % p == 0) {
                as.add(p);
                n /= p;
            }
            p++;
        }
        if (n != 1) as.add(n);

        if (as.size() < k) {
            System.out.println(-1);
        } else {
            int[] ans = new int[k];
            for (int i = 0; i < k - 1; i++) {
                ans[i] = as.get(i);
            }
            ans[k - 1] = 1;
            for (int i = as.size() - 1; i >= k - 1; i--) {
                ans[k - 1] *= as.get(i);
            }

            PrintWriter out = new PrintWriter(System.out);
            out.print(ans[0]);
            for (int i = 1; i < k; i++) {
                out.print(" " + ans[i]);
            }
            out.println();
            out.flush();
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
