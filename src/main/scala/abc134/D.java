package abc134;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class D {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) ar[i] = sc.nextInt();
        boolean ok = true;
        int cnt = 0;
        LinkedList<Integer> ans = new LinkedList<>();

        for (int i = n; i > 0; i--) {
            if (sum[i] % 2 != ar[i]) {
                cnt++;
                ans.addFirst(i);
                for (int j = 1; 1L * j * j <= 1L * i; j++) {
                    if (i % j == 0) {
                        sum[j] += 1;
                        if (i / j != j) {
                            sum[i / j] += 1;
                        }
                    }
                }
            }
        }
//        debug(sum);
//        debug(ans);
        PrintWriter out = new PrintWriter(System.out);
        if (ok) {
            out.println(cnt);
            if (cnt != 0) {
                out.print(ans.removeFirst());
                for (int a : ans) out.print(" " + a);
                out.println();
            }
        } else {
            out.println(-1);
        }
        out.flush();
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
